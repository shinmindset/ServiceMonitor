package monitor.service;

import monitor.service.ServiceVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ServiceMonitorListDao {
	
	public void add(Connection c, ServiceVO serviceVO) throws ClassNotFoundException, SQLException{
		
		PreparedStatement ps = c.prepareStatement(
				"insert into monitor.SERVICE(HOST, PORT) values(?,?)");
		ps.setString(1, serviceVO.getHost());
		ps.setString(2, serviceVO.getPort());
		
		ps.executeUpdate();
		ps.close();
		//c.close();
	}
	public List<ServiceVO> getList(Connection c) throws ClassNotFoundException, SQLException{
		PreparedStatement ps = c.prepareStatement("select * from monitor.SERVICE");
		ResultSet rs = ps.executeQuery();
		
		if(!rs.next()){
			return Collections.emptyList();
		}
		List<ServiceVO> serviceList = new ArrayList<ServiceVO>();
		do{
			ServiceVO itemVO = makeSetFromResultSet(rs);
			serviceList.add(itemVO);
		}while(rs.next());
		return serviceList;
	}
	
	private ServiceVO makeSetFromResultSet(ResultSet rs) throws SQLException{
		ServiceVO serviceVO = new ServiceVO();
		serviceVO.setHost(rs.getString("HOST"));
		serviceVO.setPort(rs.getString("PORT"));
		return serviceVO;
	}
	
}
