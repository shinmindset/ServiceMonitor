package monitor.service;

/**
 * 
 * - Check if service is up and cause of Exception.
 */

public class ServiceCheckRS {

	/**
	 * if Service is up
	 */
	private boolean isServiceUp;
	/**
	 * cause of Exception
	 */
	private Throwable cause;
	
	

	public boolean isServiceUp() {
		return isServiceUp;
	}



	public void setServiceUp(boolean isServiceUp) {
		this.isServiceUp = isServiceUp;
	}



	public Throwable getCause() {
		return cause;
	}



	public void setCause(Throwable cause) {
		this.cause = cause;
	}



	public ServiceCheckRS( boolean isServiceUp, Throwable cause) {
		this.isServiceUp = isServiceUp;
		this.cause = cause;
	}
	
}