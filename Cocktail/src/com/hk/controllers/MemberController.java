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
import com.hk.daos.ReplyDao;
import com.hk.dtos.CocktailDto;
import com.hk.dtos.IngreDto;
import com.hk.dtos.MemberDto;
import com.hk.dtos.ReplyDto;
import com.hk.utils.Util;
import com.sun.glass.ui.Window;
import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.scene.control.Alert;
import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

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
		ReplyDao rdao = new ReplyDao();

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
			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
			List<IngreDto> leq = cdao.leqCock();
			request.setAttribute("leq", leq);
			List<IngreDto> drink = cdao.drinkCock();
			request.setAttribute("drink", drink);
			List<IngreDto> syrup = cdao.syrupCock();
			request.setAttribute("syrup", syrup);
			List<IngreDto> color = cdao.colorCock();
			request.setAttribute("color", color);
			List<IngreDto> taste = cdao.tasteCock();
			request.setAttribute("taste", taste);
			List<IngreDto> alchol = cdao.alcholCock();
			request.setAttribute("alchol", alchol);
			dispatch("main.jsp", request, response);
		
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
					jsForward("안녕하세요 관리자님", "MemberController.do?command=main", response);
				}else if(ldto.getM_role().toUpperCase().equals("일반")){
					jsForward("안녕하세요","MemberController.do?command=main",response);
				}
			}
		}else if(command.equals("getuser")) {
			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
			int m_seq = Integer.parseInt(request.getParameter("m_seq"));
			MemberDto ldto = mdao.getUser(m_seq);
			request.setAttribute("ldto", ldto);
			dispatch("userstatus.jsp", request, response);
		
		}else if(command.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			jsForward("로그아웃 완료","MemberController.do?command=main", response);
			
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
 				jsForward("회원탈퇴 성공 안녕히가세요", "MemberController.do?command=main", response);
 			}else {
 				jsForward("회원탈퇴 실패", "MemberController.do?command=getuser&m_seq="+m_seq, response);
 			}
 			
 		}else if(command.equals("cocklist")) {
 			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
			List<CocktailDto> list = cdao.getAllCock();
			request.setAttribute("lists", list);
			dispatch("cocklist.jsp", request, response);
		
 		}else if(command.equals("cockdetail")) {
 			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
			
			
			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
			CocktailDto cdto = cdao.getCock(cock_seq);
			request.setAttribute("cdto", cdto);
			List<ReplyDto> rlist = rdao.getReply(cock_seq);
			request.setAttribute("rlist", rlist);
			System.out.println(cdto);
			dispatch("cockdetail.jsp", request, response);
		
 		}else if(command.equals("liked")) {
			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
			String liked = request.getParameter("liked");
			if(liked!=null) {
				cdao.upCount(cock_seq);
			}
			dispatch("MemberController.do?command=cockdetail&cock_seq="+cock_seq, request, response);
 		
 		}else if(command.equals("searchingre")) {
 			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
 			
			String base = request.getParameter("base");
 			String leq = request.getParameter("leq");
 			String drink = request.getParameter("drink");
 			String syrup = request.getParameter("syrup");
 			
 			List<CocktailDto> list = cdao.getIngre(new CocktailDto(0,null, base, null, leq,null, drink,null, syrup,null,null,null,null,null,null,null,null,null));
 			System.out.println(list);
 			request.setAttribute("ingre", list);
 			dispatch("result.jsp", request, response);
 			
 		}else if(command.equals("searchbase")) {
 			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
 			
			String base = request.getParameter("base");
 			List<CocktailDto> list = cdao.searchBase(new CocktailDto(0,null, base, null, null,null, null,null, null,null,null,null,null,null,null,null,null,null));
 			System.out.println(list);
 			request.setAttribute("ingre", list);
 			dispatch("result.jsp", request, response);
 			
 		}else if(command.equals("searchcham")) {
 			List<CocktailDto> top = cdao.topCock();
			request.setAttribute("top", top);
			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
 			
 			String base = request.getParameter("base");
 			String color = request.getParameter("color");
 			String taste = request.getParameter("taste");
 			String alchol = request.getParameter("alchol");
 			
 			List<CocktailDto> list = cdao.getCham(new CocktailDto(0,null, base, null, null,null, null,null, null,null,null,null,color,taste,alchol,null,null,null));
 			System.out.println(list);
 			request.setAttribute("ingre", list);
 			dispatch("result.jsp", request, response);
 		}else if(command.equals("insertform")) {
 			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
			List<IngreDto> leq = cdao.leqCock();
			request.setAttribute("leq", leq);
			List<IngreDto> drink = cdao.drinkCock();
			request.setAttribute("drink", drink);
			List<IngreDto> syrup = cdao.syrupCock();
			request.setAttribute("syrup", syrup);
			List<IngreDto> color = cdao.colorCock();
			request.setAttribute("color", color);
			List<IngreDto> taste = cdao.tasteCock();
			request.setAttribute("taste", taste);
			List<IngreDto> alchol = cdao.alcholCock();
			request.setAttribute("alchol", alchol);
			List<IngreDto> etc = cdao.etcCock();
			request.setAttribute("etc", etc);
			dispatch("insertcock.jsp", request, response);
 		
 		}else if(command.equals("insertcock")) {
 			String cock_name = request.getParameter("cock_name");
 			String base = request.getParameter("base");
 			String base_amt = request.getParameter("base_amt");
 			String leq = request.getParameter("leq");
 			String leq_amt = request.getParameter("leq_amt");
 			String drink = request.getParameter("drink");
 			String drink_amt = request.getParameter("drink_amt");
 			String syrup = request.getParameter("syrup");
 			String syrup_amt = request.getParameter("syrup_amt");
 			String etc = request.getParameter("etc");
 			String etc_amt = request.getParameter("etc_amt");
 			String color = request.getParameter("color");
 			String taste = request.getParameter("taste");
 			String alchol = request.getParameter("alchol");
 			String explain = request.getParameter("explain");
 			String make = request.getParameter("make");
 			
 			boolean isS = cdao.insertCockList(new CocktailDto(cock_name,base,base_amt,leq,leq_amt,drink,drink_amt,syrup,syrup_amt,etc,etc_amt,color,taste,alchol,explain,make));
 			if(isS) {
 				jsForward("칵테일 추가 성공", "MemberController.do?command=cocklist", response);
 			}else {
 				jsForward("칵테일 추가 실패", "MemberController.do?command=insertform", response);
 			}
 		}else if(command.equals("delcock")) {
 			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
 			boolean isS = cdao.delCock(cock_seq);
 			if(isS) {
 				jsForward("삭제성공", "MemberController.do?command=cocklist", response);
 			}else {
 				jsForward("삭제실패", "MemberController.do?command=cockdetail&cock_seq="+cock_seq, response);

 			}
 		}else if(command.equals("updateform")) {
 			
 			List<IngreDto> bases = cdao.baseCock();
			request.setAttribute("bases", bases);
			List<IngreDto> leq = cdao.leqCock();
			request.setAttribute("leq", leq);
			List<IngreDto> drink = cdao.drinkCock();
			request.setAttribute("drink", drink);
			List<IngreDto> syrup = cdao.syrupCock();
			request.setAttribute("syrup", syrup);
			List<IngreDto> color = cdao.colorCock();
			request.setAttribute("color", color);
			List<IngreDto> taste = cdao.tasteCock();
			request.setAttribute("taste", taste);
			List<IngreDto> alchol = cdao.alcholCock();
			request.setAttribute("alchol", alchol);
			List<IngreDto> etc = cdao.etcCock();
			request.setAttribute("etc", etc);
 			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
 			CocktailDto cdto = cdao.getCock(cock_seq);
 			request.setAttribute("cdto", cdto);
			dispatch("updatecock.jsp", request, response);
		
 		}else if(command.equals("updatecock")) {
			int cock_seq = Integer.parseInt(request.getParameter("cock_seq"));
 			String base = request.getParameter("base");
 			String base_amt = request.getParameter("base_amt");
 			String leq = request.getParameter("leq");
 			String leq_amt = request.getParameter("leq_amt");
 			String drink = request.getParameter("drink");
 			String drink_amt = request.getParameter("drink_amt");
 			String syrup = request.getParameter("syrup");
 			String syrup_amt = request.getParameter("syrup_amt");
 			String etc = request.getParameter("etc");
 			String etc_amt = request.getParameter("etc_amt");
 			String color = request.getParameter("color");
 			String taste = request.getParameter("taste");
 			String alchol = request.getParameter("alchol");
 			String explain = request.getParameter("explain");
 			String make = request.getParameter("make");
 			
 			boolean isS = cdao.updateCock(new CocktailDto(cock_seq,null,base,base_amt,leq,leq_amt,drink,drink_amt,syrup,syrup_amt,etc,etc_amt,color,taste,alchol,null,explain,make));
 			if(isS) {
 				jsForward("칵테일 수정 성공", "MemberController.do?command=cocklist", response);
 			}else {
 				jsForward("칵테일 수정 실패", "MemberController.do?command=updateform&cock_seq="+cock_seq, response);
 			}
		
 		}else if(command.equals("insertreply")) {
			String rep_id = request.getParameter("rep_id");
			String rep_content = request.getParameter("rep_content");
			int rep_cock_seq = Integer.parseInt(request.getParameter("rep_cock_seq"));
			
			boolean isS = rdao.insertReply(new ReplyDto(0,rep_content,rep_id,null,rep_cock_seq));
			if(isS) {
				jsForward("덧글작성완료","MemberController.do?command=cockdetail&cock_seq="+rep_cock_seq, response);
			}else {
				jsForward("덧글작성 실패", "MemberController.do?command=cockdetail&cock_seq="+rep_cock_seq, response);
			}
		}else if(command.equals("delreply")) {
			int rep_seq = Integer.parseInt(request.getParameter("rep_seq"));
			int rep_cock_seq = Integer.parseInt(request.getParameter("rep_cock_seq"));
			boolean isS = rdao.delReply(rep_seq);
			if(isS) {
				jsForward("삭제완료","MemberController.do?command=cockdetail&cock_seq="+rep_cock_seq, response);
			}else {
				jsForward("삭제실패", "MemberController.do?command=cockdetail&cock_seq="+rep_cock_seq, response);
			}
		}else if(command.equals("userlist")) {
			List<MemberDto> mlist = mdao.getAllUser();
			request.setAttribute("mlist", mlist);
			dispatch("userlist.jsp", request, response);
		
		}
		else if(command.equals("userstatus")) {
			int m_seq = Integer.parseInt(request.getParameter("m_seq"));
			String m_role = request.getParameter("m_role");
			String m_enabled = request.getParameter("m_enabled");
			
			boolean isS = mdao.updateMember(m_seq, m_role, m_enabled);
			if(isS) {
				jsForward("유저정보 변경완료", "MemberController.do?command=userlist", response);
			}else {
				jsForward("유저정보 변경실패", "MemberController.do?command=userlist", response);
			}
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
	public void jsForward(String msg, HttpServletResponse response) throws IOException{
		String str= "<script type='text/javascript'>"
				+"alert('"+msg+"');"
				+"</script>";
		PrintWriter pw = response.getWriter();
		pw.print(str);
		pw.close();
	}
}
