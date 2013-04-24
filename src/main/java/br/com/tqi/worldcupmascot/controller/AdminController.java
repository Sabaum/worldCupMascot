package br.com.tqi.worldcupmascot.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.tqi.worldcupmascot.service.MascotService;

@Resource
public class AdminController {

	private final MascotService mascotService;
	private Result result;
	
	public AdminController(MascotService mascotService, Result result) {
		this.mascotService = mascotService;
		this.result = result;
	}
	
	@Get("/admin")
	public void votes() {
		result.include("mascotList", mascotService.votes());
		result.use(Results.page()).of(MascotController.class).votes();
	}
}
