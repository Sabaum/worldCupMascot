package br.com.tqi.worldcupmascot.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.exception.VoteException;
import br.com.tqi.worldcupmascot.model.Mascot;
import br.com.tqi.worldcupmascot.service.MascotService;

import com.google.common.base.Preconditions;

/**
 * Controlador relacionado a votos.
 * Requisições REST relacionados à votação são tratadas neste Controller
 * @author Renato
 *
 */
@Resource
public class MascotController {

	private final Validator validator;
	private final Result result;
	private final MascotService mascotService;
	
	public MascotController(MascotService mascotService,
			Result result, Validator validator) {
		this.mascotService = mascotService;
		this.result = result;
		this.validator = validator;
	}
	
	@Get
	public void vote() {
	}
	
	@Post
	public void vote(MascotEnum vote, String recaptcha_challenge_field, String recaptcha_response_field) {
		try {
			if (vote == null) {
				validator.add(new ValidationMessage("Escolha um mascote ante de clicar em 'Votar'.", "error"));
			} else {
				Preconditions.checkNotNull(vote);
				mascotService.vote(vote, recaptcha_challenge_field, recaptcha_response_field);
				result.include("successVar", Boolean.TRUE);
			}
		} catch (VoteException e) {
			validator.add(new ValidationMessage(e.getMessage(), "error"));
		}
		validator.onErrorForwardTo(getClass()).vote();
			
	}
	
	/**
	 * Método facilitador de chamadas externas (JMeter e afins)
	 * @param vote
	 */
	@Post("/voteForExternalCalls")
	public void vote(MascotEnum vote) {
		if (vote == null) {
			validator.add(new ValidationMessage("vote.notnull", "error"));
		} else {
			Preconditions.checkNotNull(vote);
			mascotService.vote(vote);
			result.include("success", Boolean.TRUE);
			result.include("successMessage", "success.vote");
		}
		validator.onErrorForwardTo(getClass()).vote();
	}
	
	@Get
	public List<Mascot> votes() {
		try {
			if (mascotService.isResultLiberated()) {
				return mascotService.votes();
			} else {
				validator.add(new ValidationMessage("Aguarde a liberação do resultado", "error"));
			}
		} catch (VoteException e) {
			validator.add(new ValidationMessage(e.getMessage(), "error"));
		}
		validator.onErrorForwardTo(getClass()).vote();
		return null;
	}
}
