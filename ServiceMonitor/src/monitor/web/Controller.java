package monitor.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monitor.service.CallerRegister;
import monitor.service.Service;
import monitor.service.ServiceMonitorList;
import monitor.service.ServiceRegister;

/**
 * @author USER
 */

@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	static Map<String, Service> map = new HashMap<String, Service>(6);
	
	static{
		//Service Monitoring Page 
		map.put("M001", new ServiceMonitorList());
		//Service Registering Page
		map.put("SR01", new ServiceRegister());
		map.put("SR02", new ServiceRegister());
		//Caller Registering Page		
		map.put("CR01", new CallerRegister());
		map.put("CR02", new CallerRegister());
		
	}//end static
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post
		request.setCharacterEncoding("UTF-8");
		
		String key = request.getParameter("cmd");
		if(key == null){
			key = "M001"; //  Parameter , MainAction 
		}//end if
		
		System.out.println("KEY : "+key);
		
		Service service = map.get(key);
		try {
			service.execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//doPost

}//class
