package demo.capteur.util;

public class Args {

	public static void notNull(Object parameter, String parameterName) {
		if (parameter == null) {
			throw new IllegalArgumentException("Le paramètre " + parameterName + " ne doit pas être null");
		}
	}

	public static void notEmpty(String parameter, String parameterName) {
		if (parameter == null || parameter.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre " + parameterName + " ne doit pas être null ou vide");
		}
	}

}
