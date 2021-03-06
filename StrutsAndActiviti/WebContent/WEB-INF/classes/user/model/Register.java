package user.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import user.dao.GroupManager;

@Entity

@Table(name = "User")

public class Register implements Serializable {

	private static final long serialVersionUID = -6430275524165380638L;
	
	private Long userId;	
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private Set<MyGroup> groups;
	
	private String mobile;
	
	private String email;
	
	private String address;
	
	private String facebookUserName;
	
	private String linkedInUserName;
	
	private String imdbUserName;
	
	
	@Id	
	@GeneratedValue	
	@Column(name = "userId")	
	public Long getUserId() {
		return userId;
	
	}
	
	public void setUserId(Long userId) {	
		this.userId = userId;
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
		this.lastName = lastName;
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
		return email;
	}
	
	public void setEmail(String eMail) {
		this.email = eMail;
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

	public void setMobile(String mobile) {
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

	@Column (name = "linkedInUserName")
	public String getLinkedInUserName() {
		return linkedInUserName;
	}

	public void setLinkedInUserName(String linkedInUserName) {
		this.linkedInUserName = linkedInUserName;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "UserXGroup", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "groupId") })
	public Set<MyGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<MyGroup> groups) {
		this.groups = groups;
	}
	


	@Column(name = "imdbUserName")
	public String getImdbUserName() {
		return imdbUserName;
	}

	public void setImdbUserName(String imdbUserName) {
		this.imdbUserName = imdbUserName;
	}


}