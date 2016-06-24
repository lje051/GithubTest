package com.choa.s8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.Board.BoardService;
import com.choa.Board.qna.QnaBoardDTO;
import com.choa.Board.qna.QnaBoardService;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired(required=false)
	@Qualifier("qnaBoardService")
	private BoardService boardService;
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public void boardWrite(){}
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(QnaBoardDTO qnaBoardDTO, RedirectAttributes redirectAttributes){
		boardService.boardWrite(qnaBoardDTO, redirectAttributes);
		return "redirect:/qna/boardList";
	}
	
	@RequestMapping(value="/boardUpdate",  method=RequestMethod.GET)
	public void boardUpdate(int num, Model model){
		boardService.boardView(num, model);
	}
	@RequestMapping(value="/boardUpdate",  method=RequestMethod.POST)
	public String boardUpdate(QnaBoardDTO qnaBoardDTO, RedirectAttributes redirectAttributes){
		boardService.boardUpdate(qnaBoardDTO, redirectAttributes);
		return "redirect:/qna/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int num, RedirectAttributes redirectAttributes){
		boardService.boardDelete(num, redirectAttributes);
		return "redirect:/qna/boardList";
	}
	
	@RequestMapping("/boardView")
	public String boardView(int num, Model model){
		return boardService.boardView(num, model);
	}
	
	@RequestMapping(value="/boardList")
	public String boardList(@RequestParam(defaultValue="1", required=false)int curPage,
			@RequestParam(defaultValue="10", required=false) int perPage
			,Model model){
		System.out.println("curPage : "+ curPage);
		return boardService.boardList(curPage,perPage, model);
	}
	
	@RequestMapping(value="replyWrite", method=RequestMethod.GET)
	public void boadReply(QnaBoardDTO qnaBoardDTO, Model model){
		model.addAttribute("boardDTO", qnaBoardDTO);
	}
	@RequestMapping(value="replyWrite", method=RequestMethod.POST)
	public String boadReply(QnaBoardDTO qnaBoardDTO, RedirectAttributes redirectAttributes){
		((QnaBoardService)boardService).replyBoard(qnaBoardDTO, redirectAttributes);
		return "redirect:/qna/boardList";
		
	}
	
	

}
