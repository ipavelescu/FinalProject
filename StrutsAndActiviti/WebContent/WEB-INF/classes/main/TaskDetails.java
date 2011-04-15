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

public class TaskDetails {

	public String taskId;
	public Task myTask;
	
	public String execute(){
		
		//get processId
		HttpServletRequest req = ServletActionContext.getRequest();
		System.out.println(req.getParameterNames().toString()+" = "+req.getParameterValues("taskId").toString());
		this.taskId = req.getParameter("taskId");
		//System.out.println("metoda "+req.getMethod());

		
		//get the same processEngine that we started in Process.java
		ProcessEngine processEngine = ProcessFactory.renderProcessEngine();

		TaskService taskService = processEngine.getTaskService();

		if(taskId!=null){
			myTask = taskService.createTaskQuery().taskId(taskId).singleResult();
		}
		
	//	System.out.println(myTask);
		return "success";
	}
	
}
