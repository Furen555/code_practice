package it.source.anichkin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Account implements Serializable {
	private static final long serialVersionUID = 5375351223481631609L;

	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String password;
	private Date created;
	private Boolean active;
	private String currentRole;

	private List<Role> roles;

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
}
