package blatt8;

public class Widerstand implements Schaltung { // entspricht dem Blatt in Design
	private final double widerstand; // pattern

	public Widerstand(double widerstand) {
		this.widerstand = widerstand;
	}

	@Override
	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public int getAnzahlWiderstaende() {
		return 1;

	}

	@Override
	public void add(Schaltung s) {
		// bleibt leer
		 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	@Override
	public void remove(Schaltung s) {
		// bleibt leer
		 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

}