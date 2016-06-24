package com.choa.Board;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BoardService {
	//글쓰기
	public void boardWrite(BoardDTO boardDTO, RedirectAttributes redirectAttributes);
	//글수정
	public void boardUpdate(BoardDTO boardDTO, RedirectAttributes redirectAttributes);
	//글삭제
	public void boardDelete(int num, RedirectAttributes redirectAttributes);
	//글보기
	public String boardView(int num, Model model);
	//글리스트보기
	public String boardList(int curPage, int perPage, Model model);
	
	

}
