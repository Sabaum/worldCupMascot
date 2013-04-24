package br.com.tqi.worldcupmascot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="MASCOTE")
public class Mascot implements Serializable {

	private static final long serialVersionUID = -338740215692995461L;

	@Id
	@Column(name="ID_MASCOTE")
	private Integer mascotId;
	
	@Column(name="DS_MASCOTE")
	private String description;
	
	@Column(name="VR_VOTOS")
	private BigInteger votes;
	
	@Transient
	private BigDecimal percentage;
	
	public Mascot() {
	}

	public Integer getMascotId() {
		return mascotId;
	}

	public void setMascotId(Integer mascotId) {
		this.mascotId = mascotId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getVotes() {
		return votes;
	}

	public void setVotes(BigInteger votes) {
		this.votes = votes;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((mascotId == null) ? 0 : mascotId.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
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
		if (!(obj instanceof Mascot)) {
			return false;
		}
		Mascot other = (Mascot) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (mascotId == null) {
			if (other.mascotId != null) {
				return false;
			}
		} else if (!mascotId.equals(other.mascotId)) {
			return false;
		}
		if (votes == null) {
			if (other.votes != null) {
				return false;
			}
		} else if (!votes.equals(other.votes)) {
			return false;
		}
		return true;
	}

}
