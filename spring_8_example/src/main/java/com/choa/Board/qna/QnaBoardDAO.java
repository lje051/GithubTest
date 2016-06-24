package com.choa.Board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.Board.BoardDAO;
import com.choa.Board.BoardDTO;
import com.choa.Board.util.MakeRow;

import oracle.net.aso.q;

@Repository
public class QnaBoardDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String namespace="QnaMapper.";

	@Override
	public Integer boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(namespace+"write", boardDTO);	
	}

	@Override
	public Integer boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"mod", boardDTO);
	}

	@Override
	public Integer boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"del", num);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"view", num);
	}

	@Override
	public List<BoardDTO> boardList(MakeRow makeRow) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"list");
	}

	@Override
	public Integer boardCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"count");
	}
	
	public Integer replyBoardWrite(QnaBoardDTO qnaBoardDTO) throws Exception{
		sqlSession.update(namespace+"replyUpdate", qnaBoardDTO);
		return sqlSession.insert(namespace+"reply", qnaBoardDTO);
	}

}
