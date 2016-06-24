package com.choa.Board;

import java.util.List;

import com.choa.Board.util.MakeRow;

public interface BoardDAO {
	//글쓰기
	public Integer boardWrite(BoardDTO boardDTO) throws Exception;
	//글수정
	public Integer boardUpdate(BoardDTO boardDTO) throws Exception;
	//글삭제
	public Integer boardDelete(int num) throws Exception;
	//글보기
	public BoardDTO boardView(int num) throws Exception;
	//글리스트보기
	public List<BoardDTO> boardList(MakeRow makeRow)throws Exception;
	//글갯수
	public Integer boardCount()throws Exception;

}
