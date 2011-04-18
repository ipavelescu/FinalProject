package main;
import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

public class Logout extends ActionSupport {
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception { 
		
	    @SuppressWarnings("rawtypes")
		Map session = ActionContext.getContext().getSession();
	    session.remove("user"); 
	    return SUCCESS;
	}
	
}