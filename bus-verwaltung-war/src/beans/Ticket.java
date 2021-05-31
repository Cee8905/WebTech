package beans;

import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long ticket_id;
	private String 	category;
	private String 	parameters;
	private String 	fb_oc;
	
	public Long getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Long ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getFb_oc() {
		return fb_oc;
	}
	public void setFb_oc(String fb_oc) {
		this.fb_oc = fb_oc;
	}
	
}
