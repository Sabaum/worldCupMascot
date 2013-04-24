package br.com.tqi.worldcupmascot.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tqi.worldcupmascot.enums.MascotEnum;
import br.com.tqi.worldcupmascot.model.Mascot;
import br.com.tqi.worldcupmascot.repository.MascotRepository;

@Transactional
@Repository
public class MascotRepositoryImpl implements MascotRepository {

	@PersistenceContext(unitName="mascotPU")
	private EntityManager entityManager;
	
	@Override
	public void vote(MascotEnum mascotEnum) {
		Mascot mascot = entityManager.find(Mascot.class, mascotEnum.getValue());
		mascot.setVotes(mascot.getVotes().add(BigInteger.ONE));
		
		entityManager.persist(mascot);
		entityManager.flush();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mascot> votes() {
		return ((Session) entityManager.getDelegate()).createCriteria(Mascot.class)
				/*.setProjection(Projections.projectionList()
						.add(Projections.property("mascotId"), "voteId")
						.add(Projections.property("votes"), "votes"))
				.setResultTransformer(new AliasToBeanResultTransformer(VoteTO.class))*/
				.list();
	}
	
	@Override
	public BigInteger voteCount() {
		return (BigInteger) ((Session) entityManager.getDelegate()).createCriteria(Mascot.class)
				.setProjection(Projections.sum("votes"))
				.uniqueResult();
	}
}
