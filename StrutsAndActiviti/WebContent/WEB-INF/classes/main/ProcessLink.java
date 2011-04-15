package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.apache.struts2.ServletActionContext;

public class ProcessLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1850029495998358523L;

	public String processId;
	public ArrayList<Task> tasks = new ArrayList<Task> ();

	
	/**
	 * prepares Struts parameter - renders tasks list
	 * @param taskService
	 * @param processInstanceId
	 */
	public ArrayList<Task> retrieveActiveTaskList(TaskService taskService, String processInstanceId){
		
		List<Task> activeTasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();

		if(activeTasks==null || activeTasks.isEmpty()){
			System.out.println("Nu am gasit taskuri ");
			
		} else {
			
			System.out.println("Am task "+activeTasks);
			int count=0;
			for (Task task : activeTasks) {
				count++;
				System.out.println("Taskul este "+task.getName());
				//taskService.complete(task.getId());
				
				//adds cuurent task to the tasks list that will be passed on to Struts - jsp
				tasks.add(task);
				System.out.println("Lista mea contine acum: "+tasks);
			}
			System.out.println("Nr taskuri: "+count);
		}
		
		return tasks;
	}
	

	public String execute() {

		//get processId
		HttpServletRequest req = ServletActionContext.getRequest();

		this.processId = req.getParameter("processId");
		//verify processId
		System.out.println("Process definition id primit: "+processId);

		//get the same processEngine that we started in Process.java
		ProcessEngine processEngine = ProcessFactory.renderProcessEngine();

		TaskService taskService = processEngine.getTaskService();

		RuntimeService runtimeService = processEngine.getRuntimeService();

		ProcessInstanceQuery myProcessQuery = runtimeService.createProcessInstanceQuery().processDefinitionId(processId);
		List<ProcessInstance> myProcessList = myProcessQuery.list();


		ProcessInstance foundProcess = null;
		
		//identify current process based on given PID (via HttpRequest)
		for(ProcessInstance myProcess : myProcessList){

			System.out.println(myProcess.getProcessDefinitionId());

			if(myProcess.getProcessDefinitionId().equals(processId)){
				System.out.println("found!!!!");
				foundProcess = myProcess;
			}
		}


		if(foundProcess!=null){
			
			RepositoryService repositoryService = processEngine.getRepositoryService();
			repositoryService.createDeployment().addClasspathResource("ActivitiProcess.bpmn20.xml").deploy();
 
			tasks = this.retrieveActiveTaskList(taskService, foundProcess.getProcessInstanceId());
			System.out.println("rezultatul testului: "+tasks.isEmpty());
			
		} 


		return "success";

		
	}
}
