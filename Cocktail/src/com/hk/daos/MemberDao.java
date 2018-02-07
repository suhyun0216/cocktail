package com.hk.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hk.dtos.MemberDto;

public class MemberDao extends SqlMapConfig{

	private String namespace = "com.hk.cock.";
	
	public MemberDao() {
	
	}
		
		//----------공통
		
		//회원가입
		public boolean insertUser(MemberDto dto) {
			int count = 0;
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				count = sqlSession.insert(namespace+"regist", dto);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return count>0?true:false;
		}
		//로그인
		public MemberDto getLogin(String m_id, String m_pw) {
			MemberDto dto = new MemberDto();
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("m_id", m_id);
				map.put("m_pw", m_pw);
				dto = sqlSession.selectOne(namespace+"login",map);
		
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return dto;
		}
		
		//내정보 보기
		public MemberDto getUser(int m_seq) {
			MemberDto dto = new MemberDto();
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				dto = sqlSession.selectOne(namespace+"getuser", m_seq);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return dto;
		}
		
		//내정보 수정
		public boolean updateUser(MemberDto mdto) {
			int count = 0;
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				count = sqlSession.update(namespace+"updateuser", mdto);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return count>0? true:false;
		}
		//회원탈퇴
		public boolean delUser(int m_seq) {
			int count = 0;
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				count = sqlSession.update(namespace+"deluser", m_seq);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return count>0?true:false;
		}
		//아이디 중복체크
		public MemberDto idChk(String m_id) {
			MemberDto dto = null;
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				dto = sqlSession.selectOne(namespace+"idchk", m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return dto;
		}
		//-------------------관리자
		
		//회원정보 보기
		public List<MemberDto> getAllUser(){
			List<MemberDto> list = new ArrayList<MemberDto>();
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				list = sqlSession.selectList(namespace+"userlist");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
			return list;
		}
	
		//회원 등급, 상태 변경하기
		public boolean updateMember(int m_seq, String m_role, String m_enabled) {
			int count = 0;
			SqlSession sqlSession = null;
			try {
				sqlSession = getSqlSessionFactory().openSession(true);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("m_seq", m_seq);
				map.put("m_role", m_role);
				map.put("m_enabled", m_enabled);
				count = sqlSession.update(namespace+"userstatus", map);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			return count>0?true:false;
		}
}
