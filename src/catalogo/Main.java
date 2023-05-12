package catalogo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;

public class Main {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

	private static final String FILE = "catalogo.txt";

	private Map<String, Libri> archivio;

	public Main() {
		this.archivio = new HashMap<String, Libri>();
	}

	public void aggiungiElemento(Libri nuovoEl) {
		archivio.put(nuovoEl.getCodiceISBN(), nuovoEl);
		logger.info("Elemento aggiunto: ", nuovoEl.getCodiceISBN(), nuovoEl.getTitolo());
	}

	public void rimuoviElemento(String codiceISBN) {
		Libri rimuovi = archivio.remove(codiceISBN);
		if (rimuovi != null)
			logger.info("Elemento rimosso: ", rimuovi.getCodiceISBN(), rimuovi.getTitolo());
	}

	public Libri ricerca(String codiceISBN) {
		return archivio.get(codiceISBN);
	}

	public List<Libri> ricerca(Integer annoPubblicazione) {
		return archivio.values().stream().filter(book -> annoPubblicazione.equals(book.getAnnoPubblicazione()))
				.collect(Collectors.toList());
	}

	/*
	 * public List<Libri> ricercaAutore(String autore){ return
	 * archivio.values().stream().filter(book -> book intanceof Libri).map(book ->
	 * (Libri)book).filter(book ->
	 * autore.equals(book.getAutore())).collect(Collectors.toList()); }
	 */

	public void salvataggio() throws IOException {
		String nomeFile = "";
		for (Libri el : archivio.values()) {
			if (nomeFile.length() != 0) {
				nomeFile += "#";
			}
			if (el instanceof Libri) {
				nomeFile += Libri.toString((Libri) el);
			} else if (el instanceof Riviste) {
				nomeFile += Riviste.toString((Riviste) el);
			}
		}

		File file = new File(FILE);
		FileUtils.writeStringToFile(file, nomeFile, "UTF-8");
		logger.info("Salvataggio file " + FILE);
	}

	public void caricamento() throws IOException {
		this.archivio.clear();

		File file = new File(FILE);

		@SuppressWarnings("unused")
		String nomeFile = FileUtils.readFileToString(file, "UTF-8");

		logger.info("Caricamento file " + FILE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main catalogo = new Main();

		Libri book = new Libri(" 984lo3 ", "Napul3 ", 2023, 350, " Paolo Sorrentino ", "Calcio");

		Riviste rivista = new Riviste(" 4651sqa ", "Sorrisi&Canzoni ", 2006, 103, "", "", Periodo.SETTIMANALE);

		catalogo.aggiungiElemento(book);
		catalogo.aggiungiElemento(rivista);

		try {
			catalogo.salvataggio();
			catalogo.caricamento();

			// List ricerca autore

		} catch (IOException e) {
			logger.error("Errore ", e);
		}

	}

}
