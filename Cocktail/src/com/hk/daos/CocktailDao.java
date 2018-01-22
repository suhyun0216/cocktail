package com.hk.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.dtos.CocktailDto;

public class CocktailDao extends SqlMapConfig{

	private String namespace="com.hk.cock.";
	
	public CocktailDao() {
		// TODO Auto-generated constructor stub
	}
	
	//-----------공통-------------
	//칵테일 전체 목록조회
	public List<CocktailDto> getAllCock(){
		List<CocktailDto> list = new ArrayList<CocktailDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cocklist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	//칵테일 재료 목록 조회
	
	//칵테일 디테일조회
	public CocktailDto getCock(int cock_seq) {
		CocktailDto cdto = new CocktailDto();
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			cdto = sqlSession.selectOne(namespace+"cockdetail", cock_seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cdto;
	}
	//칵테일 검색
	
	//칵테일 좋아요
	public boolean upCount(int cock_seq) {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.update(namespace+"liked", cock_seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	//--------관리자----------
	//칵테일 목록 추가
	public boolean insertCockList(CocktailDto cdto) {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"insertcocklist", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;
	}
	//칵테일 목록 수정
	
	//칵테일 목록 삭제
	
	//칵테일 재료 추가
	
	//칵테일 재료 수정
	
	//칵테일 재료 삭제
	
	//칵테일 디테일 수정
	
	
}
