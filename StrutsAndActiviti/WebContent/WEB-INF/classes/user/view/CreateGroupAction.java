package user.view;


import java.util.ArrayList;

import javax.persistence.Column;

import user.dao.GroupManager;


import user.model.Group;

import com.opensymphony.xwork2.ActionSupport;

public class CreateGroupAction extends ActionSupport {

	private static final long serialVersionUID = 908606616890722294L;
	
	private Long groupId;
	private String groupName, description;
	
	
	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Column(name="groupName", nullable=false)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public CreateGroupAction() {
	
	}
	
	public String execute() throws Exception {
	
		Group Gst = new Group();
		
		Gst.setGroupName(groupName);
		Gst.setDescription(description);
	
		if (GroupManager.addGroup(Gst))
		
			return "success";
		
		else
		
			return "fail";
	
	}

}