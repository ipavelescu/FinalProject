package user.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity

@Table(name = "User")

public class Register implements Serializable {

	private static final long serialVersionUID = -6430275524165380638L;
	
	private Long id;	
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private String mobile;
	
	private String eMail;
	
	private String address;
	
	private String facebookUserName;
	
	private String linkedInUserName;
	
	private String imdbUserName;
	
	
	@Id	
	@GeneratedValue	
	@Column(name = "id")	
	public Long getId() {
		return id;
	
	}
	
	public void setId(Long id) {	
		this.id = id;
	}
	
	@Column(name = "firstName")	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	@Column(name = "lastName")
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.firstName = lastName;
	}
	
	@Column(name = "userName")	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "eMail")	
	public String getEmail() {
		return eMail;
	}
	
	public void setEmail(String eMail) {
		this.eMail = eMail;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "mobile")	
	public String getMobile() {
		return mobile;	
	}
	
	public void setCellNo(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name = "address")	
	public String getAddress() {	
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "facebookUserName")
	public String getFacebookUserName() {
		return facebookUserName;
	}

	public void setFacebookUserName(String facebookUserName) {
		this.facebookUserName = facebookUserName;
	}

	@Column(name = "linkedInUserName")
	public String getLinkedInUserName() {
		return linkedInUserName;
	}

	public void setLinkedInUserName(String linkedInUserName) {
		this.linkedInUserName = linkedInUserName;
	}

	@Column(name = "imdbUserName")
	public String getImdbUserName() {
		return imdbUserName;
	}

	public void setImdbUserName(String imdbUserName) {
		this.imdbUserName = imdbUserName;
	}


}