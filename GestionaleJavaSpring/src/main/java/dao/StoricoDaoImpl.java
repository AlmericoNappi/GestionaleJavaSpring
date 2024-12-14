package dao;

import java.util.ArrayList;
import java.util.List;

import model.Storico;

public class StoricoDaoImpl implements StoricoDao {

	private static List<Storico> listaStorico = new ArrayList<>();

	
	public List<Storico> ricercaPerMatricola(int matricola){

			for (Storico storico : listaStorico) {
				if (storico != null && storico.getMatricola() == matricola) {
					System.out.println("stai cercando" + storico.getIdStorico());
				}
				return listaStorico;
			}
			return null;
	}
	
	public Storico ricercaPerIdStorico(String IdStorico) {

		for (Storico storico : listaStorico) {
			if (storico != null && storico.getIdStorico().equals(IdStorico)) {
				System.out.println("stai cercando" + storico.getIdStorico());
			}
			return storico;
		}
		return null;
//	- ricercaPerCodiceFiscale, prende in ingresso un codice fiscale  cerca 
//	un impiegato, dentro listaImpiegato, con quel codice. Ritornare l'impiegato
//	cercato, altrimenti null.
	}

	public void inserisci(Storico i) {
		listaStorico.add(i);
		System.out.println("Storico " + i + " aggiunto con successo");
	}

	public boolean aggiorna(Storico i) {

		for (Storico storico : listaStorico) {
			if (storico.getIdStorico().equals(i.getIdStorico()))
				;
			storico.setDataFine(i.getDataFine());
			storico.setDataInizio(i.getDataFine());
			storico.setIdRuolo(i.getIdRuolo());
			storico.setMatricola(i.getMatricola());
			System.out.println(storico.getIdStorico() + " è stato modificato con successo");

		}
		return true;
//		}else{ 
//		return false;
//		System.out.println(i.getCognome()+ " non trovato");
//}
	}

//	- aggiorna,  prende in ingresso un'istanza i di Impiegato, la cerca, tramite
//	codice fiscale in listaImpiegato, e se la trova aggiorna il contenuto con l'istanza
//	i. Ritornare vero, se l'istanza è stata trovata.

	public boolean elimina(String idStorico) {

		
//		metodo equals da studiare
//		if(this == i) return true;
//		if(i == null || getClass() != i.getClass()) return false;
//		Storico storico =(Storico) i;
//		return matricola == storico.getMatricola()&&
//				Objects.equals(dataInizio, storico.getDataInizio()) &&
//				Objects.equals(dataFine, storico.getDataFine());

		for (Storico storico : listaStorico) {
			if (storico.getIdStorico() != null && storico.getIdStorico()== idStorico);
			listaStorico.remove(storico);
		}
		return false;
	}
//	for (Impiegato impiegato : listaImpiegato) {
//		if (impiegato != null && impiegato.getCodiceFiscale().equals(codiceFiscale)) {
//			System.out.println("vuoi eliminare " + impiegato.getCognome());
//			
//	}
//	}
//	
//	//	- elimina, prende in ingresso un codice fiscale e cerca, dentro listaImpiegato,
//// un impiegato con quel codice fiscale. Se lo trova lo elimina. Ritorna vero se
//// ha trovato un impiegato con quel codice.

	
	public static void main(String[] args) {

		Storico i1 = new Storico();
		i1.setDataFine("2 settembre");
		i1.setDataInizio("4 agosto");
		i1.setIdRuolo("a101");
		i1.setIdStorico("s101");
		i1.setMatricola(1);

		Storico i2 = new Storico();
		i2.setDataFine("12 settembre");
		i2.setDataInizio("12 agosto");
		i2.setIdRuolo("a102");
		i2.setIdStorico("s102");
		i2.setMatricola(2);

		Storico i3 = new Storico();
		i3.setDataFine("22 settembre");
		i3.setDataInizio("24 agosto");
		i3.setIdRuolo("a103");
		i3.setIdStorico("s103");
		i3.setMatricola(3);

		StoricoDao StoDao = new StoricoDaoImpl();
		StoDao.inserisci(i1);
		StoDao.aggiorna(i2);

		StoDao.inserisci(i3);
		System.out.println(listaStorico);
		StoDao.elimina(i3.getIdStorico());

		System.out.println(listaStorico);
	}
}