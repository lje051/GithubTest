package com.choa.Board.free;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.Board.BoardDAO;
import com.choa.Board.BoardDTO;
import com.choa.Board.util.MakeRow;

@Repository(value="freeDAO")
public class FreeBoardDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace="FreeBoardMapper.";
	@Override
	public Integer boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		return sqlSession.selectOne(namespace+"view", num);
		
	}

	@Override
	public List<BoardDTO> boardList(MakeRow makeRow) throws Exception {
		
		return sqlSession.selectList(namespace+"list", makeRow);
	}

	@Override
	public Integer boardCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
