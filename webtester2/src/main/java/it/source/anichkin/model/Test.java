package it.source.anichkin.model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idAccount;
	private String name;
	private String discription;

	private List<Question> questions;

	public Test(String name, String discription, Long idAccount) {
		this.name = name;
		this.discription = discription;
		this.idAccount = idAccount;
	}

	public Test() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
