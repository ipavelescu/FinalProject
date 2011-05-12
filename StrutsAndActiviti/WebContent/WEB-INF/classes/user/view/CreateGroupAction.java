package user.view;


import java.util.ArrayList;

import javax.persistence.Column;

import user.dao.GroupManager;


import user.model.Group;
import user.model.MyGroup;

import com.opensymphony.xwork2.ActionSupport;

public class CreateGroupAction extends ActionSupport {

	private static final long serialVersionUID = 908606616890722294L;
	
	private Long groupId;
	private String groupName, description;
	
	
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public CreateGroupAction() {
	
	}
	
	public String execute() throws Exception {
	
		MyGroup Gst = new MyGroup();
		
		
		Gst.setGroupName(groupName);
		Gst.setDescription(description);
	
		System.out.println("descriere: "+Gst.getGroupName());
		System.out.println("descriere: "+Gst.getDescription());
		
//		return "success";
		if (GroupManager.addGroup(Gst)){
			
			System.out.println("success");
			return "success";
		
		} else {
			System.out.println("fail");
			return "fail";
		}
	
	}

}