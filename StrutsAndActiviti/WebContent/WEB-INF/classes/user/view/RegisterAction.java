package user.view;


import user.dao.RegisterDao;

import user.model.Register;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 908606616890722294L;
	
	private Long id;
	private String firstName, lastName, userName, password, mobile, email, address, facebookUserName, linkedInUserName, imdbUserName;
	
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacebookUserName() {
		return facebookUserName;
	}

	public void setFacebookUserName(String facebookUserName) {
		this.facebookUserName = facebookUserName;
	}

	public String getLinkedInUserName() {
		return linkedInUserName;
	}

	public void setLinkedInUserName(String linkedInUserName) {
		this.linkedInUserName = linkedInUserName;
	}

	public String getImdbUserName() {
		return imdbUserName;
	}

	public void setImdbUserName(String imdbUserName) {
		this.imdbUserName = imdbUserName;
	}

	public Long getId() {
		return id;	
	}
	
	public void setId(Long id) {	
		this.id = id;
	}
	
	
	public RegisterAction() {
	
	}
	
	public String execute() throws Exception {
	
		Register Rgst = new Register();
		
		System.out.println("Eu cred ca first name este: "+firstName+", iar last name este: "+lastName+" si pe eMail am: "+email+", iar parola este: "+password+". Stop.");
		
		Rgst.setAddress(address);
		Rgst.setMobile(mobile);
		Rgst.setEmail(email);
		Rgst.setFacebookUserName(facebookUserName);
		Rgst.setFirstName(firstName);
		Rgst.setImdbUserName(imdbUserName);
		//Rgst.setId(id);
		Rgst.setLastName(lastName);
		Rgst.setLinkedInUserName(linkedInUserName);
		Rgst.setPassword(password);
		Rgst.setUserName(userName);

		
		if (RegisterDao.registerUser(Rgst))
		
			return "success";
		
		else
		
			return "fail";
	
	}

}