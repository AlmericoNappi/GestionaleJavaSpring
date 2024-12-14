package dao;

import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public class ImpiegatoDaoImpl implements ImpiegatoDao {

	private static List<Impiegato> listaImpiegato = new ArrayList<>();

	public List<Impiegato> ricercaImpiegatoPerCognome(String Cognome) {
		List<Impiegato> lista = new ArrayList<>();

		for (Impiegato impiegato : listaImpiegato) {
			if (impiegato != null && impiegato.getCognome().equals(Cognome)) {
				lista.add(impiegato);
			}
			System.out.println("stai cercando " + impiegato.getNome()+" " + Cognome);
		}
			return lista;
		}
		
	
	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {

		for (Impiegato impiegato : listaImpiegato) {
			if (impiegato != null && impiegato.getCodiceFiscale().equals(codiceFiscale)) {
				System.out.println("stai cercando: " + impiegato.getCognome());
			}
			return impiegato;
		}
		return null;
//		- ricercaPerCodiceFiscale, prende in ingresso un codice fiscale  cerca 
//		un impiegato, dentro listaImpiegato, con quel codice. Ritornare l'impiegato
//		cercato, altrimenti null.
	}

	public void inserisci(Impiegato i) {
		listaImpiegato.add(i);
		System.out.println("impiegato " + i + " aggiunto con successo");
	}

	public boolean aggiorna(Impiegato i) {

		for (Impiegato impiegato : listaImpiegato) {
			if (impiegato.getCodiceFiscale().equals(i.getCodiceFiscale()))
				;
			impiegato.setNome(i.getNome());
			impiegato.setCognome(i.getCognome());
			impiegato.setMatricola(i.getMatricola());
			System.out.println(impiegato.getCognome() + " è stato modificato con successo");

		}
		return true;
//			}else{ 
//			return false;
//			System.out.println(i.getCognome()+ " non trovato");
//	}
	}

//		- aggiorna,  prende in ingresso un'istanza i di Impiegato, la cerca, tramite
//		codice fiscale in listaImpiegato, e se la trova aggiorna il contenuto con l'istanza
//		i. Ritornare vero, se l'istanza è stata trovata.

	public boolean elimina(String codiceFiscale) {
			for (Impiegato impiegato : listaImpiegato) {
				if (impiegato != null && impiegato.getCodiceFiscale().equals(codiceFiscale))
					listaImpiegato.remove(impiegato);
				}
		return false;
	}
	
//		for (Impiegato impiegato : listaImpiegato) {
//			if (impiegato != null && impiegato.getCodiceFiscale().equals(codiceFiscale)) {
//				System.out.println("vuoi eliminare " + impiegato.getCognome());
//				
//		}
//		}
//		
//		//	- elimina, prende in ingresso un codice fiscale e cerca, dentro listaImpiegato,
////	 un impiegato con quel codice fiscale. Se lo trova lo elimina. Ritorna vero se
////	 ha trovato un impiegato con quel codice.
	@Override
	public String toString() {
		return "ImpiegatoDao [listaImpiegato=" + listaImpiegato + "]";
	}

	public static void main(String[] args) {

		Impiegato i1 = new Impiegato();
		i1.setNome("alme");
		i1.setCognome("nappi");
		i1.setMatricola(1);
		i1.setCodiceFiscale("lrc");

		Impiegato i2 = new Impiegato();
		i2.setNome("Almerico");
		i2.setCognome("Nappi");
		i2.setMatricola(3);

		ImpiegatoDao ImpDao = new ImpiegatoDaoImpl();
		ImpDao.inserisci(i1);
		ImpDao.aggiorna(i2);

		Impiegato i3 = new Impiegato();
		i3.setNome("Michele");
		i3.setCognome("nappi");
		i3.setMatricola(2);
		i3.setCodiceFiscale("mcl");

		ImpDao.inserisci(i3);
		System.out.println(listaImpiegato);
		ImpDao.elimina("mcl");
		System.out.println(listaImpiegato);
		//ImpDao.ricercaImpiegatoPerCognome("Nappi");
	}
}
