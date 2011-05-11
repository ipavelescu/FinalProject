package user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Group")
public class Group {
	
	private long groupId;
	private String groupName;
	private String description;

	
	public Group() {}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	@Id
	@GeneratedValue
	@Column(name="groupId")
	
	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Column(name="groupName")
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
 
}