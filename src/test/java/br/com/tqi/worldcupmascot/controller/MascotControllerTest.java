package br.com.tqi.worldcupmascot.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.exception.VoteException;
import br.com.tqi.worldcupmascot.service.MascotService;
import br.com.tqi.worldcupmascot.service.impl.MascotServiceImpl;

public class MascotControllerTest {

	private MockValidator validator;
	private MockResult result;
	private MascotService mascotService;
	private MascotController controller;

	@Before
	public void setUp() throws Exception {
		validator = new MockValidator();
		result = new MockResult();
		mascotService = Mockito.mock(MascotServiceImpl.class);
		controller = new MascotController(mascotService, result, validator);
	}
	
	@Test
	public void voteAmijubi() {
		MascotEnum vote = MascotEnum.AMIJUBI;
		controller.vote(vote);

		Mockito.verify(mascotService).vote(vote);
	}
	
	@Test
	public void voteFuleco() {
		MascotEnum vote = MascotEnum.FULECO;
		controller.vote(vote);

		Mockito.verify(mascotService).vote(vote);
	}
	
	@Test
	public void voteZuzeco() {
		MascotEnum vote = MascotEnum.ZUZECO;
		controller.vote(vote);

		Mockito.verify(mascotService).vote(vote);
	}

	@Test
	public void voteWithCaptcha() throws VoteException {
		final String challenge = "challenge";
		final String response = "response";
		
		MascotEnum vote = MascotEnum.ZUZECO;
		controller.vote(vote, challenge, response);

		Mockito.verify(mascotService).vote(vote, challenge, response);
	}
	
	@Test(expected=ValidationException.class)
	public void voteNull() {
		controller.vote(null);
	}

}
