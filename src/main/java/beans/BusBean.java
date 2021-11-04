package beans;

import java.io.Serializable;

// author: Sabine Ramp
public class BusBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer busId;
	private Integer busNr;
	private String busName;
	private String busDescription;
	private String requestor;
	
	public BusBean() {}
	
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
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
	public void setBusName(String bus_name) {
		this.busName = busName;
	}
	public String getBusDescription() {
		return busDescription;
	}
	public void setBusDescription(String bus_description) {
		this.busDescription = bus_description;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

}
