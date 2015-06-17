package blatt8;

public class Reihenschaltung extends ZusammengesetzeSchaltung {

	public double getWiderstand() {
		double reihe = 0;
		for (Schaltung s : schaltung) {
			reihe += s.getWiderstand();
		}
		return reihe;
	}

}