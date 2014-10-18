package monitor.service;

import monitor.service.ServiceMonitorListDao;
import monitor.service.ServiceVO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.connection.ConnectionProvider;
import com.mysql.jdbc.Connection;

public class ServiceMonitorList implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		request.setCharacterEncoding("UTF-8");

		ServiceMonitorListDao dao = new ServiceMonitorListDao();
		ServiceVO vo = new ServiceVO();
		Connection conn = null;
		conn = ConnectionProvider.getConnection();
		
		Iterator it = null;
		it = dao.getList(conn).iterator();
		
		request.setAttribute("it", it);
		conn.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/monitor/ServiceList.jsp");
		rd.forward(request, response);
	}//execute

}//class
