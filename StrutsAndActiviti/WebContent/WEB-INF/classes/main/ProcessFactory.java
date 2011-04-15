package main;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class ProcessFactory {

	private static ProcessEngine pe;
	
	public static ProcessEngine renderProcessEngine(){
		
		if(pe==null){
			pe = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();
		}
		
		return pe;
	}
	
}
