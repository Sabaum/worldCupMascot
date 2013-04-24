package br.com.tqi.worldcupmascot.service;

import java.util.List;

import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.exception.VoteException;
import br.com.tqi.worldcupmascot.model.Mascot;

public interface MascotService {

	void vote(MascotEnum vote, String challenge, String response) throws VoteException;
	
	void vote(MascotEnum vote);
	
	List<Mascot> votes();

	boolean isResultLiberated() throws VoteException;
	
}
