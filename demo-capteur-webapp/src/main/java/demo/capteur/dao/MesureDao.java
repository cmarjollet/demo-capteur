package demo.capteur.dao;

import org.springframework.stereotype.Repository;

import demo.capteur.model.Mesure;

@Repository
public class MesureDao extends AbstractHibernateDao<Mesure> {

	public MesureDao() {
		super(Mesure.class);
	}

}
