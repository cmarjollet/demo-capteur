package demo.capteur.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.capteur.model.Capteur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/app-config.xml" })
public class ConfigurationServiceTest {

	@Autowired
	private ConfigurationService configurationService;

	@Test(expected = IllegalArgumentException.class)
	public void creer_un_capteur_null_doit_echouer() {
		configurationService.createCapteur(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void creer_un_capteur_avec_un_nom_null_doit_echouer() {
		createNewCapteur(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void creer_un_capteur_avec_un_nom_vide_doit_echouer() {
		createNewCapteur("  ");
	}

	@Test
	public void creer_un_capteur_doit_reussir() {
		Capteur capteur = createNewCapteur("monThermometre");
		Assert.assertNotNull(capteur);
		Assert.assertNotNull(capteur.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void mettre_a_jour_un_capteur_avec_un_id_null_doit_echouer() {
		Capteur capteur = createNewCapteur("leThermometreDeMonVoision");
		capteur.setId(null);
		configurationService.updateCapteur(capteur);
	}

	@Test(expected = IllegalArgumentException.class)
	public void mettre_a_jour_un_capteur_avec_un_nom_null_doit_echouer() {
		Capteur capteur = createNewCapteur("unAutreThermometre");
		capteur.setNom(null);
		configurationService.updateCapteur(capteur);
	}

	@Test(expected = IllegalArgumentException.class)
	public void mettre_a_jour_un_capteur_avec_un_nom_vide_doit_echouer() {
		Capteur capteur = createNewCapteur("unEthylometre");
		capteur.setNom(" ");
		configurationService.updateCapteur(capteur);
	}

	@Test
	public void mettre_a_jour_un_capteur_doit_reussir() {
		Capteur capteur = createNewCapteur("monAnémomètre");
		capteur.setNom("monNouvelAnémomètre");
		configurationService.updateCapteur(capteur);
	}

	private Capteur createNewCapteur(String nomCapteur) {
		Capteur capteur = new Capteur();
		capteur.setNom(nomCapteur);
		return configurationService.createCapteur(capteur);
	}

}
