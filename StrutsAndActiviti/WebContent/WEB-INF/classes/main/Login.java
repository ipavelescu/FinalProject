package main;

import java.util.Map;

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

        if (isInvalid(getUserName()))
        {
            errorflag = true;
        }

       
        
        if(errorflag==false)
        {
            return INPUT;
        }

        Map session = ActionContext.getContext().getSession();
        session.put("user",getUserName());
        
        return SUCCESS;
    }

    private boolean isInvalid(String value) {
            return (value != null || value.length() > 0);
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