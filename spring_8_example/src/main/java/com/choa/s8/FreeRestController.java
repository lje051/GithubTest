package com.choa.s8;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.choa.Board.BoardDTO;
import com.choa.Board.BoardService;
import com.choa.Board.free.FreeBoardDTO;
import com.choa.Board.free.FreeBoardService;
import com.choa.Board.reply.FreeboardReplyDTO;
import com.choa.Board.reply.FreeeBoardReplyService;

@RestController
@RequestMapping("/freeboard/**")
public class FreeRestController {

	@Autowired(required=false)
	@Qualifier("free")
	private FreeBoardService boardService;

	
	@Autowired
	private FreeeBoardReplyService si;
	
	@RequestMapping("/replyWrite")
	public ResponseEntity<FreeboardReplyDTO> replywrite(@RequestBody FreeboardReplyDTO freeboardReplyDTO){
		System.out.println("컨트롤러접근");
		System.out.println(freeboardReplyDTO.getRid());
		System.out.println(freeboardReplyDTO.getNum());
		System.out.println(freeboardReplyDTO.getrContents());
		
		si.replyWrite(freeboardReplyDTO);
		System.out.println(freeboardReplyDTO.getrContents()+" : 쓰려고했던내용!!!!!!!!!");
		return 	new ResponseEntity<FreeboardReplyDTO>(freeboardReplyDTO, HttpStatus.OK)	;
	}
	
	@RequestMapping("/freeRestList")
	public List<? extends BoardDTO> list(@RequestParam(defaultValue="2", required=false) int curPage, 
			@RequestParam(defaultValue="5", required=false)int perPage, Model model){
		return boardService.boardList(curPage, perPage);
	}
	
	@RequestMapping("/replyList/{curPage}/{perPage}/{num}/")
	public ResponseEntity<FreeboardReplyDTO> replyList(@PathVariable("curPage")int curPage, @PathVariable("perPage")int perPage, @PathVariable("num")int num){
		System.out.println(curPage+"커");
		System.out.println(num+"넘버");
		System.out.println(perPage+"퍼");
		List<FreeBoardDTO>ar=si.replyList(curPage, perPage, num);
		return 	new ResponseEntity<FreeboardReplyDTO>(ar, HttpStatus.OK)	;
	}
}
