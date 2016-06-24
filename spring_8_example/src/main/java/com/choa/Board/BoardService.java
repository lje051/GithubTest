package com.choa.Board;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BoardService {
	//�۾���
	public void boardWrite(BoardDTO boardDTO, RedirectAttributes redirectAttributes);
	//�ۼ���
	public void boardUpdate(BoardDTO boardDTO, RedirectAttributes redirectAttributes);
	//�ۻ���
	public void boardDelete(int num, RedirectAttributes redirectAttributes);
	//�ۺ���
	public String boardView(int num, Model model);
	//�۸���Ʈ����
	public String boardList(int curPage, int perPage, Model model);
	
	

}
