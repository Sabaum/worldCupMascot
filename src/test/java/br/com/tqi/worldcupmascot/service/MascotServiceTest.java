package br.com.tqi.worldcupmascot.service;

import java.math.BigInteger;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.exception.VoteException;
import br.com.tqi.worldcupmascot.repository.ConfigParamRepository;
import br.com.tqi.worldcupmascot.repository.MascotRepository;
import br.com.tqi.worldcupmascot.service.impl.MascotServiceImpl;
import br.com.tqi.worldcupmascot.util.Constants;

public class MascotServiceTest {

	private ReCaptchaImpl reCaptcha;
	private MascotRepository mascotRepository;
	private ConfigParamRepository configParamRepository;
	private MascotService mascotService;
	private ReCaptchaResponse reCaptchaResponse;
	
	@Before
	public void setUp() {
		reCaptcha = Mockito.mock(ReCaptchaImpl.class);
		mascotRepository = Mockito.mock(MascotRepository.class);
		configParamRepository = Mockito.mock(ConfigParamRepository.class);
		mascotService = new MascotServiceImpl(reCaptcha, mascotRepository, configParamRepository);
		
		reCaptchaResponse = Mockito.mock(ReCaptchaResponse.class);
	}

	@Test
	public void voteWithCaptchaValid() throws VoteException {
		final String challenge = "challenge";
		final String response = "response";
		Mockito.when(reCaptcha.checkAnswer("rpms.com.br", challenge, response))
		.thenReturn(reCaptchaResponse);

		Mockito.when(reCaptchaResponse.isValid())
		.thenReturn(Boolean.TRUE);
		
		MascotEnum mascot = MascotEnum.AMIJUBI;
		mascotService.vote(mascot, challenge, response);
		
		Mockito.verify(mascotRepository).vote(mascot);
	}
	
	@Test(expected=VoteException.class)
	public void voteWithCaptchaNotValid() throws VoteException {
		final String challenge = "challenge";
		final String response = "response";
		Mockito.when(reCaptcha.checkAnswer("rpms.com.br", challenge, response))
		.thenReturn(reCaptchaResponse);

		Mockito.when(reCaptchaResponse.isValid())
		.thenReturn(Boolean.FALSE);
		
		MascotEnum mascot = MascotEnum.AMIJUBI;
		mascotService.vote(mascot, challenge, response);
	}
	
	@Test
	public void vote() {
		MascotEnum mascot = MascotEnum.AMIJUBI;
		mascotService.vote(mascot);
		
		Mockito.verify(mascotRepository).vote(mascot);
	}
	
	@Test
	public void votes() {
		Mockito.when(mascotRepository.voteCount())
		.thenReturn(BigInteger.valueOf(100));
		
		mascotService.votes();

		Mockito.verify(mascotRepository).voteCount();
		Mockito.verify(mascotRepository).votes();
	}
	
	@Test
	public void isResultLiberated() throws VoteException {
		Mockito.when(configParamRepository.getParamValueById(Constants.RESULT_LIBERATION_DATE_PARAMETER_ID))
			.thenReturn("01/01/2013 00:00:00");
		
		Assert.assertTrue(mascotService.isResultLiberated());
	}
	
	@Test
	public void isResultNotLiberated() throws VoteException {
		Mockito.when(configParamRepository.getParamValueById(Constants.RESULT_LIBERATION_DATE_PARAMETER_ID))
			.thenReturn("01/01/2020 00:00:00");
		
		Assert.assertFalse(mascotService.isResultLiberated());
	}

	@Test(expected=VoteException.class)
	public void isResultLiberatedFail() throws VoteException {
		Mockito.when(configParamRepository.getParamValueById(Constants.RESULT_LIBERATION_DATE_PARAMETER_ID)).thenReturn("wrongData");
		
		mascotService.isResultLiberated();
	}
}
