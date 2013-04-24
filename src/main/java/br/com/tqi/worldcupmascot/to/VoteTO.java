package br.com.tqi.worldcupmascot.to;

import java.math.BigInteger;

public class VoteTO {

	private Integer voteId;
	private BigInteger votes;
	private Integer percentage;
	
	public VoteTO() {}
	
	public VoteTO(Integer voteId, Integer percentage) {
		this.voteId = voteId;
		this.percentage = percentage;
	}

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public BigInteger getVotes() {
		return votes;
	}

	public void setVotes(BigInteger votes) {
		this.votes = votes;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	
}
