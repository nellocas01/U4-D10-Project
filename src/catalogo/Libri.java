package catalogo;

public class Libri {
	// attributi
	protected String codiceISBN;
	protected String titolo;
	protected Integer numPagine;
	protected Integer annoPubblicazione;
	protected String autore;
	protected String genere;

	// costruttore
	public Libri(String codiceISBN, String titolo, Integer numPagine, Integer annoPubblicazione, String autore,
			String genere) {
		this.setCodiceISBN(codiceISBN);
		this.setTitolo(titolo);
		this.setNumPagine(numPagine);
		this.setAnnoPubblicazione(annoPubblicazione);
		this.setAutore(autore);
		this.setGenere(genere);
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(Integer numPagine) {
		this.numPagine = numPagine;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public static String toString(Libri libro) {
		return Libri.class.getName() + libro.codiceISBN + libro.titolo + libro.numPagine + libro.annoPubblicazione
				+ libro.autore + libro.genere;
	}
}
