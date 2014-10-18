package monitor.service;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.connection.ConnectionProvider;

import com.mysql.jdbc.Connection;


public class CallerRegister implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("CR01")){
			RequestDispatcher rd = request.getRequestDispatcher("jsp/monitor/CRegister.jsp");
			rd.forward(request, response);
		}else{//SR02
				
				CallerVO callerVO = new CallerVO();
				String caller = request.getParameter("caller");
				String host = request.getParameter("host");
				String port = request.getParameter("port");
				String email = request.getParameter("email");
				String polling = request.getParameter("polling");
				
				callerVO.setCaller(caller);
				callerVO.setHost(host);
				callerVO.setPort(port);
				callerVO.setEmail(email);
				callerVO.setPollFrequency(Integer.valueOf(polling));

				Timer timer = new Timer();
				int frequency = callerVO.getPollFrequency()*1000;
				timer.schedule(new ServiceMonitorScheduling(callerVO), 0, frequency );
				
				
				RequestDispatcher rd = request.getRequestDispatcher("main.do?cmd=M001");
				rd.forward(request, response);
		}
	}//execute

}//class
