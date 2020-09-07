package it.source.anichkin.model;

import java.io.Serializable;

public class Role implements Serializable {
	private static final long serialVersionUID = -2770957777512894091L;

	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
