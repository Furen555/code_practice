package it.source.anichkin.model;

import java.io.Serializable;

public class Answear implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idQuest;
	private String name;
	private Boolean correct;

	public Answear(Long idQuest, String name, Boolean correct) {
		this.idQuest = idQuest;
		this.name = name;
		this.correct = correct;
	}

	public Answear() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdQuest() {
		return idQuest;
	}

	public void setIdQuest(Long idQuest) {
		this.idQuest = idQuest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

}
