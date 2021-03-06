package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.struts2.ServletActionContext;

public class TaskUpdated {

	public String taskId;
	public String userMessage;
	public Task myTask;
	
	public String execute(){
		
		//get processId
		HttpServletRequest req = ServletActionContext.getRequest();

		this.taskId = req.getParameter("taskId");
		this.userMessage = req.getParameter("userMessage");
		
		//get the same processEngine that we started in Process.java
		ProcessEngine processEngine = ProcessFactory.renderProcessEngine();

		TaskService taskService = processEngine.getTaskService();

		if(taskId!=null){
			myTask = taskService.createTaskQuery().taskId(taskId).singleResult();
			myTask.setDescription(myTask.getDescription()+"\n"+userMessage);
			taskService.complete(taskId);
		}

		return "success";
	}
	
}