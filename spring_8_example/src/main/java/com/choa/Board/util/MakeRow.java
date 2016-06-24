package com.choa.Board.util;

public class MakeRow {
	private int startRow;
	private int lastRow;
	private int curPage;
	private int perPage;
	
	public int getStartRow() {
		return (curPage-1)*perPage+1;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return curPage*perPage;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	

}
