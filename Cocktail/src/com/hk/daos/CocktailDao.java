package com.hk.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.dtos.CocktailDto;
import com.hk.dtos.IngreDto;

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
	public List<CocktailDto> getIngre(CocktailDto cdto){
		List<CocktailDto> list = new ArrayList<CocktailDto>();
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"searchingre",cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//칵테일 취향조회
	public List<CocktailDto> getCham(CocktailDto cdto){
		List<CocktailDto> list = new ArrayList<CocktailDto>();
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"searchcham",cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
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
	
	//칵테일 베이스 검색
	public List<CocktailDto> searchBase(CocktailDto cdto){
		List<CocktailDto> list = new ArrayList<CocktailDto>();
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"searchbase",cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	
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
	
	//칵테일 좋아요 순으로 정렬
	public List<CocktailDto> topCock(){
		List<CocktailDto> list = new ArrayList<CocktailDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cocktop");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//베이스 종류
	public List<IngreDto> baseCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cockbase");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> leqCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cockleq");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> drinkCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cockdrink");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> syrupCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cocksyrup");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> colorCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cockcolor");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> tasteCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cocktaste");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> alcholCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cockalchol");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<IngreDto> etcCock(){
		List<IngreDto> list = new ArrayList<IngreDto>();
		SqlSession  sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace+"cocketc");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	//--------관리자----------
	//칵테일 목록 추가
	public boolean insertCockList(CocktailDto cdto) {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"insertcock", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;
	}
	
	//칵테일 목록 삭제
	public boolean delCock(int cock_seq) {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"delcock", cock_seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	//칵테일 디테일 수정
	public boolean updateCock(CocktailDto cdto) {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"updatecock", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
}
