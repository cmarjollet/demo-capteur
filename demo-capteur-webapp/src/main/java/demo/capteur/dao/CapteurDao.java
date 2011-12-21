package demo.capteur.dao;

import org.springframework.stereotype.Repository;

import demo.capteur.model.Capteur;

@Repository
public class CapteurDao extends AbstractHibernateDao<Capteur> {

	public CapteurDao() {
		super(Capteur.class);
	}

}
