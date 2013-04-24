package br.com.tqi.worldcupmascot.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {

	private Result result;

	public LoginController(Result result) {
		this.result = result;
	}
	
	@Get("/login")
	public void login(Boolean loginError) {
		result.include("loginError", loginError);
	}
	
	@Get("/loginFailed")
	public void loginFailed() {
		result.include("loginFailed", Boolean.TRUE);
		result.forwardTo(getClass()).login(Boolean.FALSE);
	}
	
	@Get("/logout")
	public void logout() {
		result.include("logout", Boolean.TRUE);
		result.forwardTo(getClass()).login(Boolean.FALSE);
	}
	
}
