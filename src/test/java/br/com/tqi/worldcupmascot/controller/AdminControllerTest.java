package br.com.tqi.worldcupmascot.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.tqi.worldcupmascot.service.MascotService;
import br.com.tqi.worldcupmascot.service.impl.MascotServiceImpl;

public class AdminControllerTest {

	private MockResult result;
	private MascotService mascotService;
	private AdminController controller;

	@Before
	public void setUp() throws Exception {
		result = new MockResult();
		mascotService = Mockito.mock(MascotServiceImpl.class);
		controller = new AdminController(mascotService, result);
	}
	
	@Test
	public void voteAmijubi() {
		controller.votes();

		Mockito.verify(mascotService).votes();
		result.included("mascotList");
	}
	
}
