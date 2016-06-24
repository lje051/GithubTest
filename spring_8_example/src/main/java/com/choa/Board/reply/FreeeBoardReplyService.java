package com.choa.Board.reply;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.Board.free.FreeBoardDTO;
import com.choa.Board.util.MakeRow;

@Service
public class FreeeBoardReplyService {
 
	@Autowired	
	private FreeboardReplyDAO freeboardReplyDAO;
	
	
	public List<FreeBoardDTO> replyList(int curPage, int perPage, int num){
		MakeRow mr=new MakeRow();
		mr.setCurPage(curPage);
		mr.setPerPage(perPage);
		Map<String, Object>a=new HashMap<String, Object>();
		a.put("map", mr);
		a.put("num", num);
		List<FreeBoardDTO>ar=freeboardReplyDAO.replyList(a); 
		return ar;
		
	}
	public void replyWrite(FreeboardReplyDTO freeboardReplyDTO){
		System.out.println("**서비스호출***");
		Calendar ca = Calendar.getInstance();
		long date = ca.getTimeInMillis();
		/*Date.valueOf(s)*/
		Date d = new Date(date);
		freeboardReplyDTO.setR_date(d);
		freeboardReplyDAO.replyWrite(freeboardReplyDTO);
	}
	
}
