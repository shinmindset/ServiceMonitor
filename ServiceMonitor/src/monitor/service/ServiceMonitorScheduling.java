package monitor.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimerTask;

import javax.annotation.Resource;


/**
 * 
 *
 */

public class ServiceMonitorScheduling extends TimerTask{
	
	CallerVO target = null;
	/**
	 * Service Monitoring 
	 * 
	 * @param 
	 * @return
	 * @throws Exception 
	public void serviceMonitoring(CallerVO callerVO) throws Exception {
			
	}
	 */
	ServiceMonitorScheduling(CallerVO callerVO){
		this.target = callerVO;
	}
		
	@Override
	public void run(){
		SendMail email = new SendMail();
		ServiceCheckRS result = null;
		
		// service check
		result = ServiceChecker.check(target.getHost(), Integer.valueOf(target.getPort()));
		
		// Message send via email (service notification). 
		if (!result.isServiceUp()) {
			target.setCrntStatus("Not Up");
			if(!target.getCrntStatus().equals(target.getPrevStatus())){
				email.sendMail(target);
			}
			if(target.getPrevStatus() == null){
				target.setPrevStatus("Not Up");
			}
		}else{
			target.setCrntStatus("Up");
			if(!target.getCrntStatus().equals(target.getPrevStatus())){
				email.sendMail(target);
			}
			if(target.getPrevStatus() == null){
				target.setPrevStatus("Up");
			}
		}
	}

}
