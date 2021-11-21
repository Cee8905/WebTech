package beans;

import java.io.Serializable;

public class Component implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long compId;
	private String 	compName;
	private String 	compDesc;
	private String 	comp_type;
	private String 	comp_unit;
	private String 	comp_value;
	
	public Long getCompId() {
		return compId;
	}
	public void setCompId(Long compId) {
		this.compId = compId;
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
	public String getComp_type() {
		return comp_type;
	}
	public void setComp_type(String comp_type) {
		this.comp_type = comp_type;
	}
	public String getComp_unit() {
		return comp_unit;
	}
	public void setComp_unit(String comp_unit) {
		this.comp_unit = comp_unit;
	}
	public String getComp_value() {
		return comp_value;
	}
	public void setComp_value(String comp_value) {
		this.comp_value = comp_value;
	}
	
}
