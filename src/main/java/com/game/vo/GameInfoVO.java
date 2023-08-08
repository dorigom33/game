package com.game.vo;

public class GameInfoVO {
	private int giNum;
	private String giName;
	private String giDesc;

	public int getGiNum() {
		return giNum;
	}

	public void setGiNum(int giNum) {
		this.giNum = giNum;
	}

	public String getGiName() {
		return giName;
	}

	public void setGiName(String giName) {
		this.giName = giName;
	}

	public String getGiDesc() {
		return giDesc;
	}

	public void setGiDesc(String giDesc) {
		this.giDesc = giDesc;
	}

	@Override
	public String toString() {
		return "GameInfoVO [giNum=" + giNum + ", giName=" + giName + ", giDesc=" + giDesc + "]";
	}

}
