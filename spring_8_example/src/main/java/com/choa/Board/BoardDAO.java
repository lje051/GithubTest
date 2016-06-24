package com.choa.Board;

import java.util.List;

import com.choa.Board.util.MakeRow;

public interface BoardDAO {
	//�۾���
	public Integer boardWrite(BoardDTO boardDTO) throws Exception;
	//�ۼ���
	public Integer boardUpdate(BoardDTO boardDTO) throws Exception;
	//�ۻ���
	public Integer boardDelete(int num) throws Exception;
	//�ۺ���
	public BoardDTO boardView(int num) throws Exception;
	//�۸���Ʈ����
	public List<BoardDTO> boardList(MakeRow makeRow)throws Exception;
	//�۰���
	public Integer boardCount()throws Exception;

}
