package com.choa.Board.reply;

import java.sql.Date;

public class FreeboardReplyDTO {
	
	private int rnum;
	private int num;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getrContents() {
		return rContents;
	}
	public void setrContents(String rContents) {
		this.rContents = rContents;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	private String rid;
	private String rContents;
	private Date r_date;

}
