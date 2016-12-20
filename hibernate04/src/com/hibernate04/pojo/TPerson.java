package com.hibernate04.pojo;

/**
 * TPerson entity. @author MyEclipse Persistence Tools
 */

public class TPerson implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	

	private Integer PId;
	private String PName;
	//¶à¶Ô1·½n:1
	private TAddress address;

	public TPerson() {
	}

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public TAddress getAddress() {
		return address;
	}

	public void setAddress(TAddress address) {
		this.address = address;
	}

	
	

}