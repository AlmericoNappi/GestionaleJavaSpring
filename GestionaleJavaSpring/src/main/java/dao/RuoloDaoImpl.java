package dao;

import java.util.ArrayList;
import java.util.List;
import model.Ruolo;

public class RuoloDaoImpl implements RuoloDao {

	private static List<Ruolo> listaRuolo = new ArrayList<>();

	public Ruolo ricercaPerId(String Id) {

		for (Ruolo ruolo : listaRuolo) {
			if (ruolo != null && ruolo.getIdRuolo().equals(Id)) {
				System.out.println("stai cercando" + ruolo.getIdRuolo());
			}
			return ruolo;
		}
		return null;
		// - ricercaPerCodiceFiscale, prende in ingresso un codice fiscale cerca
		// un impiegato, dentro listaImpiegato, con quel codice. Ritornare l'impiegato
		// cercato, altrimenti null.
	}

	public void inserisci(Ruolo i) {
		listaRuolo.add(i);
		System.out.println("ruolo " + i + " aggiunto con successo");
	}

	public boolean aggiorna(Ruolo i) {

		for (Ruolo ruolo : listaRuolo) {
			if (ruolo.getIdRuolo().equals(i.getIdRuolo()))
				;
			ruolo.setDescrizione(i.getDescrizione());
			System.out.println(ruolo.getIdRuolo() + " è stato modificato con successo");

		}
		return true;
		// }else{
		// return false;
		// System.out.println(i.getCognome()+ " non trovato");
		// }
	}

	// - aggiorna, prende in ingresso un'istanza i di Impiegato, la cerca, tramite
	// codice fiscale in listaImpiegato, e se la trova aggiorna il contenuto con
	// l'istanza
	// i. Ritornare vero, se l'istanza è stata trovata.

	public boolean elimina(String idRuolo) {
		for (Ruolo ruolo : listaRuolo) {
			if (ruolo != null && ruolo.getIdRuolo()==idRuolo)
				;
			listaRuolo.remove(ruolo);
		}
		return false;
	}
	// for (Impiegato impiegato : listaImpiegato) {
	// if (impiegato != null && impiegato.getCodiceFiscale().equals(codiceFiscale))
	// {
	// System.out.println("vuoi eliminare " + impiegato.getCognome());
	//
	// }
	// }
	//
	// // - elimina, prende in ingresso un codice fiscale e cerca, dentro
	// listaImpiegato,
	//// un impiegato con quel codice fiscale. Se lo trova lo elimina. Ritorna vero
	// se
	//// ha trovato un impiegato con quel codice.

	public static void main(String[] args) {

		Ruolo i1 = new Ruolo();
		i1.setIdRuolo("a10");
		i1.setDescrizione("first");

		Ruolo i2 = new Ruolo();
		i2.setIdRuolo("a11");
		i2.setDescrizione("second");

		Ruolo i3 = new Ruolo();
		i3.setIdRuolo("a12");
		i3.setDescrizione("terd");

		RuoloDao RuoDao = new RuoloDaoImpl();
		RuoDao.inserisci(i1);
		RuoDao.aggiorna(i2);

		RuoDao.inserisci(i3);
		System.out.println(listaRuolo);
		RuoDao.elimina(i3.getIdRuolo());

		System.out.println(listaRuolo);

	}

}
