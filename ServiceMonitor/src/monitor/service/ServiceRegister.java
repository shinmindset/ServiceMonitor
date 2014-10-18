package monitor.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.connection.ConnectionProvider;

import com.mysql.jdbc.Connection;


public class ServiceRegister implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("SR01")){
			RequestDispatcher rd = request.getRequestDispatcher("jsp/monitor/ServiceRegister.jsp");
			rd.forward(request, response);
		}else{//SR02
				
				ServiceVO serviceVO = new ServiceVO();
				String host = request.getParameter("host");
				String port = request.getParameter("port");
				
				serviceVO.setHost(host);
				serviceVO.setPort(port);
				
				ServiceMonitorListDao dao = new ServiceMonitorListDao();
				Connection conn = null;
				try {
					conn = ConnectionProvider.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dao.add(conn, serviceVO);
				conn.close();
				 
				
				RequestDispatcher rd = request.getRequestDispatcher("main.do?cmd=M001");
				rd.forward(request, response);
		}
	}//execute

}//class
