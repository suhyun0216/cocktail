package com.hk.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.hk.daos.CocktailDao;
import com.hk.daos.MemberDao;
import com.hk.dtos.CocktailDto;
import com.hk.dtos.MemberDto;
import com.hk.utils.Util;
import com.sun.glass.ui.Window;
import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.scene.control.Alert;

@WebServlet("/MemberController.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String command = request.getParameter("command");
		MemberDao mdao = new MemberDao();
		CocktailDao cdao = new CocktailDao();

		if(command.equals("regist")) {
			String m_name = request.getParameter("m_name");
			String m_id = request.getParameter("m_id");
			String m_pw = request.getParameter("m_pw");
			String m_email = request.getParameter("m_email");

			boolean isS = mdao.insertUser(new MemberDto(m_name, m_id, m_pw, m_email));
			if(isS) {
				jsForward("회원가입 성공", "login.jsp",response);
			}else {
				jsForward("회원가입 실패", "regist.jsp",response);
			}
		}else if(command.equals("registform")) {
			String id = request.getParameter("user");
			response.sendRedirect("regist.jsp");
		}else if(command.equals("main")) {
			response.sendRedirect("main.jsp");
		}else if(command.equals("idchk")) {
			String m_id = request.getParameter("m_id");
			MemberDto mdto = mdao.idChk(m_id);
			boolean isS = true;
			
			if(mdto==null) {
				isS=false;
				jsForward("사용가능아이디입니다", "regist.jsp?user="+m_id+"&isS=y", response);
			}else {
				jsForward("중복아이디입니다", "regist.jsp?user="+m_id+"&isS=n", response);
			}
		}else if(command.equals("loginform")) {
			response.sendRedirect("login.jsp");
		}else if(command.equals("login")) {
			String m_id = request.getParameter("m_id");
			String m_pw = request.getParameter("m_pw");

			MemberDto ldto = mdao.getLogin(m_id, m_pw);
			System.out.println(ldto);
			if(ldto.getM_id()!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("ldto", ldto);
				
				if(ldto.getM_role().toUpperCase().equals("관리자")){
					response.sendRedirect("adminmain.jsp");
				}else if(ldto.getM_role().toUpperCase().equals("일반")){
					jsForward("안녕하세요","main.jsp",response);
				}
			}
		}else if(command.equals("getuser")) {
			int m_seq = Integer.parseInt(request.getParameter("m_seq"));
			MemberDto ldto = mdao.getUser(m_seq);
			request.setAttribute("ldto", ldto);
			dispatch("userstatus.jsp", request, response);
		
		}else if(command.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			jsForward("로그아웃 완료","main.jsp", response);
			
		}else if(command.equals("updateuser")) {
			int m_seq = Integer.parseInt(request.getParameter("m_seq"));
			MemberDto ldto = mdao.getUser(m_seq);
			request.setAttribute("ldto", ldto);
			dispatch("userupdate.jsp", request, response);
			
		}else if(command.equals("updateinfo")) {
			int m_seq = Integer.parseInt(request.getParameter("m_seq"));
			String m_name = request.getParameter("m_name");
			String m_pw = request.getParameter("m_pw");
			String m_email = request.getParameter("m_email");
			
			boolean isS = mdao.updateUser(new MemberDto( m_seq,m_name, m_pw, m_email));
			if(isS){
				jsForward("수정성공", "MemberController.do?command=getuser&m_seq="+m_seq, response);
			}else{
				jsForward("수정실패", "MemberController.do?command=getuser&m_seq="+m_seq,response);
			}
			
 		}else if(command.equals("deluser")) {
 			int m_seq = Integer.parseInt(request.getParameter("m_seq"));
 			boolean isS = mdao.delUser(m_seq);
 			if(isS) {
 				HttpSession session = request.getSession();
 				session.invalidate();
 				jsForward("회원탈퇴 성공 안녕히가세요", "main.jsp", response);
 			}else {
 				jsForward("회원탈퇴 실패", "MemberController.do?command=getuser&m_seq="+m_seq, response);
 			}
 			
 		}else if(command.equals("cocklist")) {
			List<CocktailDto> list = cdao.getAllCock();
			request.setAttribute("lists", list);
			dispatch("cocklist.jsp", request, response);
		}else if(command.equals("cockdetail")) {
			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
			CocktailDto cdto = cdao.getCock(cock_seq);
			request.setAttribute("cdto", cdto);
			System.out.println(cdto);
			dispatch("cockdetail.jsp", request, response);
		}else if(command.equals("liked")) {
			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
			String liked = request.getParameter("liked");
			if(liked!=null) {
				cdao.upCount(cock_seq);
			}
			dispatch("MemberController.do?command=cockdetail&cock_seq="+cock_seq, request, response);
		}
	}

	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	public void jsForward(String msg, String url, HttpServletResponse response) throws IOException{
		String str= "<script type='text/javascript'>"
				+"alert('"+msg+"');"
				+"location.href='"+url+"';"
				+"</script>";
		PrintWriter pw = response.getWriter();
		pw.print(str);
	}
	public void alert(String msg, HttpServletResponse response) throws IOException{
		String str= "<script type='text/javascript'>"
				+"alert('"+msg+"');"
				+"</script>";
		PrintWriter pw = response.getWriter();
		pw.print(str);
		pw.close();
	}
}
