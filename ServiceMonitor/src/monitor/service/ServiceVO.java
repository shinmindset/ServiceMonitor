package monitor.service;


/**
 * 
 * - Service monitoring Vo
 * 
 * Detail
 * - Host, Port, and Status for Services 
 * @author Tyson
 * @version 1.0
 * @created 
 */
public class ServiceVO {

	//id
	private int id;
	//Host
	private String host;
	//Port
	private String port;
	//Status
	private boolean isUp;
	//Service Status
	private String ServiceStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public boolean isUp() {
		return isUp;
	}
	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}
	public String getServiceStatus() {
		return ServiceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		ServiceStatus = serviceStatus;
	}
	
}