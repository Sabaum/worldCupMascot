package br.com.tqi.worldcupmascot.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.exception.VoteException;
import br.com.tqi.worldcupmascot.model.Mascot;
import br.com.tqi.worldcupmascot.repository.ConfigParamRepository;
import br.com.tqi.worldcupmascot.repository.MascotRepository;
import br.com.tqi.worldcupmascot.service.MascotService;
import br.com.tqi.worldcupmascot.util.Constants;

@Service
public class MascotServiceImpl implements MascotService {

	private static final BigDecimal PERCENTAGE_FACTOR = BigDecimal.valueOf(100);
	
	private ReCaptchaImpl reCaptcha;
	private MascotRepository mascotRepository;
	private ConfigParamRepository configParamRepository;
	
	@Autowired
	public MascotServiceImpl(ReCaptchaImpl reCaptcha, MascotRepository mascotRepository,
			ConfigParamRepository configParamRepository) {
		this.reCaptcha = reCaptcha;
		this.mascotRepository = mascotRepository;
		this.configParamRepository = configParamRepository;
	}
	
	/**
	 * Valida o captcha e em caso de match de código de verificação, adiciona um voto ao mascote.
	 * @throws VoteException 
	 */
	public void vote(MascotEnum vote, String challenge, String response) throws VoteException {

		reCaptcha.setPrivateKey("6LehGeASAAAAADGBDdp7dSa6us77Tu0xsD1gw9qX");

		if (StringUtils.isEmpty(response)) {
			throw new VoteException("Código de verificação não pode ser vazio");
		}
		ReCaptchaResponse reCaptchaResponse =
				reCaptcha.checkAnswer("rpms.com.br", challenge, response);

		if (!reCaptchaResponse.isValid()) {
			throw new VoteException("Código de verificação digitado não é valido");
		} else {
			mascotRepository.vote(vote);
		}
	}

	/**
	 * Método facilitador para chamadas externas (JMeter e afins)
	 * Não valida recaptcha.
	 */
	public void vote(MascotEnum vote) {
		mascotRepository.vote(vote);
	}

	/**
	 * Retorna lista com o resultado da votação.
	 */
	public List<Mascot> votes() {
		BigDecimal totalVotes = new BigDecimal(mascotRepository.voteCount());
		
		List<Mascot> mascotList = mascotRepository.votes();
		for (Mascot mascot : mascotList) {
			mascot.setPercentage(percentage(new BigDecimal(mascot.getVotes()), totalVotes));
		}
		
		return mascotList;
	}

	private BigDecimal percentage(BigDecimal votes, BigDecimal totalVotes) {
		if (votes.equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		}

		return votes.multiply(PERCENTAGE_FACTOR).divide(totalVotes, MathContext.DECIMAL32).setScale(1,RoundingMode.HALF_UP);
	}

	/**
	 * Verifica se o resultado da votação já foi liberado.
	 */
	public boolean isResultLiberated() throws VoteException {
		try {
			String param = configParamRepository.getParamValueById(Constants.RESULT_LIBERATION_DATE_PARAMETER_ID);
			Date paramDate = new SimpleDateFormat(Constants.PT_BR_DATE_PATTERN).parse(param);
			return new Date().after(paramDate); 
		} catch (ParseException e) {
			throw new VoteException("Base de dados inconsistente. Entrar em contato com a administração", e);
		}
	}
}
