package com.hk.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.dtos.ReplyDto;

public class ReplyDao extends SqlMapConfig{
	private String namespace = "com.hk.cock.";
	
	public ReplyDao() {
		// TODO Auto-generated constructor stub
	}
	
	//--------공통
	//덧글 조회
	public List<ReplyDto> getReply(int cock_seq){
		List<ReplyDto> rlist = new ArrayList<ReplyDto>();
		SqlSession sqlSession = null;
		System.out.println("혹시");
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			rlist = sqlSession.selectList(namespace+"replyboard",cock_seq);
			System.out.println("실행됐음안됐음");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return rlist;
	}
	//덧글 작성기능
	public boolean insertReply(ReplyDto rdto) {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"insertreply",rdto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	//덧글 수정기능
	public boolean updateReply(ReplyDto rdto) {
		int count=0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"updatereply", rdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0? true:false;
	}
	//덧글 삭제기능
	public boolean delReply(int rep_seq) {
		int count=0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"delreply", rep_seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0? true:false;
	}
}
