package ueb02;

class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static StringSet findeDuplikate(String text) {
		// TODO Implementieren Sie die Methode gemäß dem obigen Javadoc Kommentar.

		text = text.replaceAll("[^A-Za-z0-9]", "");
		String [] parts = text.split (" ");
		String [] duplicates = new String [30];
		int k = 0;



		for (int i = 0; i < parts.length; i++) {

			for (int j = 1; j < parts.length; j++) {
				if (i == j)
					continue;

				if (parts [i].equals(parts [j])) {
					duplicates [k] = parts [i];
					k++;
				}
			}
		}

		StringSet duplikate = new StringSetImpl();

		for (int i = 0; i < duplicates.length; i++) {
			duplikate.add(duplicates[i]);
		}

		return duplikate;
	}
}
