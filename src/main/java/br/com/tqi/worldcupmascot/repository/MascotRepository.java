package br.com.tqi.worldcupmascot.repository;

import java.math.BigInteger;
import java.util.List;

import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.model.Mascot;

public interface MascotRepository {

	void vote(MascotEnum mascotEnum);
	
	List<Mascot> votes();

	BigInteger voteCount();
	
}
