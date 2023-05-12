package catalogo;

public class Riviste extends Libri {
	// attributi
	private Periodo periodicità;

	// costruttore
	public Riviste(String codiceISBN, String titolo, Integer numPagine, Integer annoPubblicazione, String autore,
			String genere, Periodo periodicità) {
		super(codiceISBN, titolo, numPagine, annoPubblicazione, autore, genere);
		this.setPeriodicità(periodicità);
	}

	public Periodo getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodo periodicità) {
		this.periodicità = periodicità;
	}

	public static String toString(Riviste rivista) {
		return Riviste.class.getName() + rivista.codiceISBN + rivista.titolo + rivista.numPagine
				+ rivista.annoPubblicazione;
	}
}
