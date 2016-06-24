package com.choa.Board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.Board.BoardDAO;
import com.choa.Board.BoardDTO;
import com.choa.Board.BoardService;
import com.choa.Board.util.MakeRow;

@Service
public class QnaBoardService implements BoardService {

	@Autowired(required=false)
	@Qualifier("boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public void boardWrite(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
		String message="";
		try {
			int result =boardDAO.boardWrite(boardDTO);
			if(result>0){
				redirectAttributes.addFlashAttribute("message", "글 등록 성공");
			}else {
				redirectAttributes.addFlashAttribute("message", "글 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "글 등록 실패");
		}

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
		try {
			int result = boardDAO.boardUpdate(boardDTO);
			if(result>0){
				redirectAttributes.addFlashAttribute("message", "글 수정 성공");
			}else {
				redirectAttributes.addFlashAttribute("message", "글 수정 실패");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "글 수정 실패");
			
		}

	}

	@Override
	public void boardDelete(int num, RedirectAttributes redirectAttributes) {
		try {
			int result = boardDAO.boardDelete(num);
			if(result>0){
				redirectAttributes.addFlashAttribute("message", "글 삭제 성공");
			}else {
				redirectAttributes.addFlashAttribute("message", "글 삭제 실패");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "글 삭제 실패");
			
		}

	}

	@Override
	public String boardView(int num, Model model) {
		String view="";
		try {
			BoardDTO boardDTO= boardDAO.boardView(num);
			System.out.println(boardDTO.getId());
			if(boardDTO !=null){
				model.addAttribute("boardDTO", boardDTO);
				view="qna/boardView";
			}else {
				view="redirect:/qna/boardList";
			}
		} catch (Exception e) {
			view="redirect:/qna/boardList";
		}
		return view;
	}

	@Override
	public String boardList(int curPage,int perPage, Model model) {
		String view="";
		try {
		MakeRow mr = new MakeRow();
		mr.setCurPage(curPage);
		mr.setPerPage(perPage);
		List<BoardDTO>list=	boardDAO.boardList(mr);
		System.out.println(list.size());
		if(list != null){
			model.addAttribute("boardList", list);
			view="qna/boardList";
		}else{
			view="redirect:/";
		}
			
		} catch (Exception e) {
			view="redirect:/";
		} 
		return view;
	}
	
	public void replyBoard(QnaBoardDTO qnaBoardDTO, RedirectAttributes redirectAttributes){
		
		try {
			int result = ((QnaBoardDAO)boardDAO).replyBoardWrite(qnaBoardDTO);
			if(result>0){
			redirectAttributes.addFlashAttribute("message", "답글 쓰기 성공");
			}else {
				redirectAttributes.addFlashAttribute("message", "답글 쓰기 실패");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "답글 쓰기 실패");
			e.printStackTrace();
		}
	}

}
