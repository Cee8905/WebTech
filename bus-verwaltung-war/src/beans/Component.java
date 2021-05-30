package beans;

import java.io.Serializable;

public class Component implements Serializable {

	private static final long serialVersionUID = 1L;
	private String 	compID;
	private String 	compName;
	private String 	compDesc;
	
	public String getCompID() {
		return compID;
	}
	public void setCompID(String compID) {
		this.compID = compID;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompDesc() {
		return compDesc;
	}
	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}
	
}
