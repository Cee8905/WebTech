package beans;

import java.io.Serializable;

// author: Sabine Ramp
public class Bus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long busId;
	private Integer busNr;
	private String busName;
	private String busDescription;
	private String requestor;
	
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public Integer getBusNr() {
		return busNr;
	}
	public void setBusNr(Integer busNr) {
		this.busNr = busNr;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusDescription() {
		return busDescription;
	}
	public void setBusDescription(String busDescription) {
		this.busDescription = busDescription;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

}
