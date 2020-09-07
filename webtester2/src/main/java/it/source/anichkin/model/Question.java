package it.source.anichkin.model;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idTest;
	private String name;

	private List<Answear> answears;

	public Question(Long idTest, String name) {
		this.idTest = idTest;
		this.name = name;
	}

	public Question() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Answear> getAnswears() {
		return answears;
	}

	public void setAnswears(List<Answear> answears) {
		this.answears = answears;
	}

	
	
}
