package it.source.anichkin.model;

import java.io.Serializable;

public class TestResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Long id_account;
	private Long id_test;
	private boolean percent;
	private String testName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_account() {
		return id_account;
	}
	public void setId_account(Long id_account) {
		this.id_account = id_account;
	}
	public Long getId_test() {
		return id_test;
	}
	public void setId_test(Long id_test) {
		this.id_test = id_test;
	}
	public boolean isPercent() {
		return percent;
	}
	public void setPercent(boolean percent) {
		this.percent = percent;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}

}
