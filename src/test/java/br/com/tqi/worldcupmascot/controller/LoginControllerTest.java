package br.com.tqi.worldcupmascot.controller;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class LoginControllerTest {

	private MockResult result;
	private LoginController controller;

	@Before
	public void setUp() throws Exception {
		result = new MockResult();
		controller = new LoginController(result);
	}
	
	@Test
	public void login() {
		controller.login(Boolean.TRUE);

		result.included("loginError");
	}
	
	@Test
	public void loginFailed() {
		controller.loginFailed();

		result.included("loginFailed");
	}
	
	@Test
	public void logout() {
		controller.logout();

		result.included("logout");
	}
	
}
