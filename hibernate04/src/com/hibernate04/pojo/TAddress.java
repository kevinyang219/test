package com.hibernate04.pojo;

import java.util.HashSet;
import java.util.Set;


public class TAddress implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer AId;
	private String ACity;

	@SuppressWarnings("unused")
	//1¶Ô¶à1£ºn
	private Set<TPerson> persons =new HashSet<TPerson>(0);
	
	public Set<TPerson> getPersons() {
		return persons;
	}

	
	public void setPersons(Set<TPerson> persons) {
		this.persons = persons;
	}

	public TAddress() {
	}

	public Integer getAId() {
		return this.AId;
	}

	public void setAId(Integer AId) {
		this.AId = AId;
	}

	public String getACity() {
		return this.ACity;
	}

	public void setACity(String ACity) {
		this.ACity = ACity;
	}

}