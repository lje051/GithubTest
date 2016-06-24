package com.choa.s8;

import java.util.ArrayList;


import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.Board.BoardDTO;
import com.choa.Board.BoardService;
import com.choa.Board.free.FreeBoardService;
import com.choa.Board.free.FreeBoardDTO;
import com.choa.Board.qna.QnaBoardDTO;
import com.choa.Board.reply.FreeboardReplyDTO;

@Controller
@RequestMapping("/freeboard/**")
public class FreeboardController {
	
	@Autowired(required=false)
	@Qualifier("free")
	private BoardService boardService;
	
	@RequestMapping("/freeboardList")
	public void list(@RequestParam(defaultValue="1", required=false) int curPage, 
			@RequestParam(defaultValue="5", required=false) int perPage
			,Model model){
		boardService.boardList(curPage,perPage, model);
	}
	
	@RequestMapping("/freeBoardView")
	public void view(int num, Model model){
		boardService.boardView(num, model);
	}
	
	

}
