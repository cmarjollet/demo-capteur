package demo.capteur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.capteur.dao.CapteurDao;
import demo.capteur.model.Capteur;
import demo.capteur.util.Args;

@Service
@Transactional
public class ConfigurationService {

	@Autowired
	private CapteurDao capteurDao;

	public Capteur createCapteur(Capteur capteur) {
		Args.notNull(capteur, "capteur");
		Args.notEmpty(capteur.getNom(), "capteur.nom");
		return capteurDao.create(capteur);
	}

	public Capteur updateCapteur(Capteur capteur) {
		Args.notNull(capteur, "capteur");
		Args.notNull(capteur.getId(), "capteur.id");
		Args.notEmpty(capteur.getNom(), "capteur.nom");
		return capteurDao.update(capteur);
	}

	public void deleteCapteur(Capteur capteur) {
		capteurDao.delete(capteur);
	}

	public Capteur findCapteurById(Long id) {
		return capteurDao.findById(id);
	}

	public List<Capteur> findAllCapteurs() {
		return capteurDao.findAll();
	}

}
