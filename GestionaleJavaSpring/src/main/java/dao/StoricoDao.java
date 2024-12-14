package dao;

import java.util.List;

import model.Storico;

public interface StoricoDao {

	public List<Storico> ricercaPerMatricola(int matricola);

	public Storico ricercaPerIdStorico(String IdStorico);

	public void inserisci(Storico i);

	public boolean aggiorna(Storico i);

	public boolean elimina(String idStorico);
}
