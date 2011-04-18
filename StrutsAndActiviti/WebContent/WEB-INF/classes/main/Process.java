package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

import com.opensymphony.xwork2.ActionContext;

public class Process implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private ArrayList<String> processes;

    public ArrayList<String> getProcesses() {
        return processes;
    }

    public void setProcesses(ArrayList<String> arrayList) {
        this.processes = arrayList;
    }
    
    public List<ProcessInstance> currentProcesses;
    
    public String execute() {
    	
    	
        ProcessEngine processEngine = ProcessFactory.renderProcessEngine();
       // System.out.println("Engine 1: "+processEngine);
        
        // Get Activiti services
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        
        // Deploy the process definition
        repositoryService.createDeployment().addClasspathResource("ActivitiProcess.bpmn20.xml").deploy();
 
        //String procName = runtimeService.startProcessInstanceByKey("financialReport").getProcessDefinitionId();
        
        this.setProcesses(new ArrayList<String> ());
    	processes = this.getProcesses();
    	
        
      //  ProcessInstanceQuery myProc = runtimeService.createProcessInstanceQuery().processDefinitionKey(procName);
        List<ProcessInstance> currentProcesses = runtimeService.createProcessInstanceQuery().list();
        
        if(!(currentProcesses.isEmpty())){
	        for(ProcessInstance currentProcess : currentProcesses){
	        	processes.add(currentProcess.getProcessDefinitionId());
	        	
	        	System.out.println("Process definition id: "+currentProcess.getProcessDefinitionId());
	        	System.out.println("Process instance id: "+currentProcess.getProcessInstanceId());
	        	System.out.println("Process id: "+currentProcess.getId());
	        }
        } else {
        	ProcessInstance currentProcess = runtimeService.startProcessInstanceByKey("financialReport");
        	processes.add(currentProcess.getProcessDefinitionId());
        	System.out.println("else");
        	System.out.println("Process definition id: "+currentProcess.getProcessDefinitionId());
        	System.out.println("Process instance id: "+currentProcess.getProcessInstanceId());
        	System.out.println("Process id: "+currentProcess.getId());
    	}

    	for(String process : processes){
    		System.out.println("Value: "+process);
    	}
        
    	Map session = ActionContext.getContext().getSession();
    	System.out.println("Continutul sesiunii mele: "+session.containsKey("login"));
    	
        return "success";
    }
}
