package beans;

import java.io.Serializable;

// author: Sabine Ramp
public class BusBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer busId;
	private Integer busNr;
	private String bus_name;
	private String bus_description;
	private String requestor;
	
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
	public String getBus_name() {
		return bus_name;
	}
	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}
	public String getBus_description() {
		return bus_description;
	}
	public void setBus_description(String bus_description) {
		this.bus_description = bus_description;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

}
