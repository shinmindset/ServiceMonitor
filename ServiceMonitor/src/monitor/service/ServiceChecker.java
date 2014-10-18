package monitor.service;

import java.io.IOException;
import java.net.Socket;

/**
 * - Service Monitoring Check Class
 * 
 *  Detail
 * - check the service with Socket
 */

public class ServiceChecker {

	public static ServiceCheckRS check(String sysIp, int sysPort) {
		
		Socket clientSocket = null;
		
		try {
			
			clientSocket = new Socket(sysIp, sysPort);
			
			return new ServiceCheckRS(true, null);
		} catch (IOException e) {
			System.out.println("Service Monitoring Error 1: " + e.getMessage());
			return new ServiceCheckRS(false, e);
		} catch (Exception e) {
			System.out.println("Service Monitoring Error 2: " + e.getMessage());
			return new ServiceCheckRS(false, e);
		} finally {
			System.out.println("clinetSocket : "+clientSocket);
			if(clientSocket != null){
				try{
					clientSocket.close();
				}catch(Exception e){
					return new ServiceCheckRS(false, e);
				}
			}//if
			
		}//try
		
	}

}
