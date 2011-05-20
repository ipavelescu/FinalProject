package admin.view;
 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
 
import user.dao.GroupManager;
import user.dao.UserManager;
import user.model.MyGroup;
import user.model.Register;
 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
public class UserAction extends ActionSupport implements ModelDriven<Register>{
 
    private static final long serialVersionUID = 9149826260758390091L;
    private Register user;
    private List<Register> userList;
    public ArrayList<MyGroup> allGroups = new ArrayList<MyGroup>();
    private Long userId;
	private Set<MyGroup> groups = new HashSet<MyGroup>();
	public ArrayList<Long> selectedGroupIds = new ArrayList<Long>();
    private UserManager linkController;
 
    public UserAction() {
        linkController = new UserManager();
    }
	public Set<MyGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<MyGroup> groups) {		
		this.groups = user.getGroups();
		System.out.println("AM USER :" + user.getUserName()+ " Am group:" + groups);
	}  
    public String execute() {
    	
        if(null != user) {
            linkController.addOrUpdateUser(getUser());
        }
        this.userList = linkController.listAllUsers();
        System.out.println(userList);
        System.out.println(userList.size());
        
        return SUCCESS;
    }
    
    public String addOrUpdateUser() {
    	
        System.out.println(getUser());
        try {
        	linkController.addOrUpdateUser(getUser());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String delete() {
        linkController.delete(getUserId());
        return SUCCESS;
    }
    
    /**
    * To list a single user by Id.
    * @return String
    */
    public String edit() {
    	
    	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);   	
    	user = UserManager.listUserById(Long.parseLong( request.getParameter("userId")));
    	System.out.println("User ready!");
    	//lista cu toate grupurile existente in baza
    	this.allGroups = GroupManager.listGroup();
    	//list containing selected user's groups (pre-selected values)
    	this.groups = user.getGroups();
    	
		for(MyGroup group : groups)
		{
			Long groupId = group.getGroupId(); 
			(this.selectedGroupIds).add(groupId);
			
		}
		System.out.println("id)urile preselectate "+selectedGroupIds);
		System.out.println("AM USER :" + user.getUserName()+ " Am group:" + groups);
    	
    	return SUCCESS;
    }
    
    public Register getUser() {
        return user;
    }
    
    public void setUser(Register user) {
		this.user = user;
	}

	public void setUserList(List<Register> userList) {
		this.userList = userList;
	}

	public List<Register> getUserList() {
        return userList;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

	@Override
	public Register getModel() {
		return user;
	}
}