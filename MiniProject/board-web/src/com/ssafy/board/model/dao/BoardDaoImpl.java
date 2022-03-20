package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dto.Board;

public class BoardDaoImpl implements BoardDao {
	
	SqlSession session = MyAppSqlConfig.getSession();
	String namespace = "com.ssafy.board.model.dao.BoardDao.";
	
	@Override
	public List<Board> selectBoard() {
		//mapper 파일의 namespace + 그안의 sql문의 id
		return session.selectList(namespace+"selectBoard");
	}

	@Override
	public Board selectBoardById(int id) {
//		session.selectOne(arg0);
		
		return null;
	}

	@Override
	public void insertBoard(Board board) {
		session.insert(namespace+"insertBoard", board);
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
//		session.update(arg0)
	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub
//		session.delete(arg0)
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
//		session.update(arg0)
	}


}
