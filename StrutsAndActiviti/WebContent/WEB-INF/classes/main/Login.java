package main;

import java.util.List;
import java.util.Map;

import user.dao.UserManager;
import user.model.Register;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
    private String password;
 
    public String execute() throws Exception {

        boolean errorflag = false;
        System.out.println("asta returnez: "+passwordIsValid(getUserName(),getPassword()));
        System.out.println("valid: "+userNameIsValid(getUserName()));
        
        if (!userNameIsValid(getUserName()) || !passwordIsValid(getUserName(),getPassword()))
        {
            errorflag = true;
        }

       
        
        if(errorflag==true)
        {
        	//System.out.println("error true")
            return INPUT;
        }

        Map session = ActionContext.getContext().getSession();
        session.put("user",getUserName());
        
        return SUCCESS;
    }

    private boolean passwordIsValid(String username, String password){
    	
    	List<Register> resultList = (UserManager.listUser(username));
    	System.out.println("Lista e "+resultList);

    	if(resultList!=null && resultList.get(0).getPassword().equals(password)){
	    		return true;
	    }
    	
    	System.out.println("Authentication failed");
    	return false;
    }
    
    private boolean userNameIsValid(String value) {
            return (value.length() > 0);
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

}