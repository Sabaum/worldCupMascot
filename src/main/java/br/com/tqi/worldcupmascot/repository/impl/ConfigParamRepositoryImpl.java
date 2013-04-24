package br.com.tqi.worldcupmascot.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.model.Mascot;
import br.com.tqi.worldcupmascot.model.ConfigurationParameter;
import br.com.tqi.worldcupmascot.repository.ConfigParamRepository;

@Transactional
@Repository
public class ConfigParamRepositoryImpl implements ConfigParamRepository {

	@PersistenceContext(unitName="mascotPU")
	private EntityManager entityManager;
	
	@Override
	public String getParamValueById(Integer paramId) {
		 return (String) ((Session) entityManager.getDelegate()).createCriteria(ConfigurationParameter.class)
		 		.add(Restrictions.eq("parameterId", paramId))
		 		.setProjection(Projections.property("value"))
		 		.uniqueResult();
	}
}
