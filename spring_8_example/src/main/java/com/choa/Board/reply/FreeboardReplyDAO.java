package com.choa.Board.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.Board.free.FreeBoardDTO;

@Repository
public class FreeboardReplyDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private String namespace="FreeboardReplyMapper.";
	
	public List<FreeBoardDTO> replyList(Map<String, Object>a){
		return sqlsession.selectList(namespace+"replyList", a);
	
	}
	
	public void replyWrite(FreeboardReplyDTO dto){
		System.out.println("dao호출!!!!!!!!!!!");
		 sqlsession.insert(namespace+"replyWrite",dto);
		 
	}
	
}
