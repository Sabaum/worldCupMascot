package br.com.tqi.worldcupmascot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="PARAMETRO_CONFIGURACAO")
public class ConfigurationParameter implements Serializable {

	private static final long serialVersionUID = 7029612773230011996L;

	@Id
	@Column(name="ID_PARAMETRO")
	private Integer parameterId;
	
	@Column(name="DS_PARAMETRO")
	private String parameter;
	
	@Column(name="VR_PARAMETRO")
	private String value;
	
	public ConfigurationParameter() {}

	public Integer getParameterId() {
		return parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((parameterId == null) ? 0 : parameterId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ConfigurationParameter)) {
			return false;
		}
		ConfigurationParameter other = (ConfigurationParameter) obj;
		if (parameterId == null) {
			if (other.parameterId != null) {
				return false;
			}
		} else if (!parameterId.equals(other.parameterId)) {
			return false;
		}
		return true;
	}
	
}
