package com.globallink.ctm.scheduler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.globallink.ctm.delegate.IClientDelegate;

@DisallowConcurrentExecution
public class CLSClientVerificationJob  implements Job {
	
	@Autowired
	private IClientDelegate clientDelegate;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		clientDelegate.updateCLSClients();		
	}
}
