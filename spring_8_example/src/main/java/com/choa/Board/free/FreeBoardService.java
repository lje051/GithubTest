package com.choa.Board.free;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.Board.BoardDAO;
import com.choa.Board.BoardDTO;
import com.choa.Board.BoardService;
import com.choa.Board.util.MakeRow;

@Service(value="free")
public class FreeBoardService implements BoardService {

	@Autowired(required=false)
	@Qualifier("freeDAO")
	private BoardDAO boardDAO;
	
	@Override
	public void boardWrite(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardDelete(int num, RedirectAttributes redirectAttributes) {
		// TODO Auto-generated method stub

	}

	@Override
	public String boardView(int num, Model model) {
		try {
			model.addAttribute("board", boardDAO.boardView(num));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<? extends BoardDTO> boardList(int curPage, int perPage){
		
		MakeRow mr = new MakeRow();
		mr.setCurPage(curPage);
		mr.setPerPage(perPage);
		List<? extends BoardDTO> ar=null;
		try {
			ar = boardDAO.boardList(mr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	@Override
	public String boardList(int curPage,int perPage, Model model) {
		try {
			MakeRow mr = new MakeRow();
			mr.setCurPage(curPage);
			mr.setPerPage(perPage);
			model.addAttribute("freeList",boardDAO.boardList(mr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
