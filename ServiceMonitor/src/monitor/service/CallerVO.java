package monitor.service;


/**
 * 
 * - Caller Registering Vo
 * 
 * Detail
 * - host, port, prevStatus, crntStatus, email, pollFrequency for interest and poll  
 * @author Tyson
 * @version 1.0
 * @created 
 */
public class CallerVO {

	//caller
	private String caller;
	//Host
	private String host;
	//Port
	private String port;
	//previous service Status
	private String prevStatus;
	//current service Status
	private String crntStatus;
	//email
	private String email;
	//polling frequency
	private int pollFrequency;
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
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
	public String getPrevStatus() {
		return prevStatus;
	}
	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}
	public String getCrntStatus() {
		return crntStatus;
	}
	public void setCrntStatus(String crntStatus) {
		this.crntStatus = crntStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPollFrequency() {
		return pollFrequency;
	}
	public void setPollFrequency(int pollFrequency) {
		this.pollFrequency = pollFrequency;
	}
	
	
}