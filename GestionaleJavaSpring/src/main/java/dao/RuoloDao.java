package dao;

import model.Ruolo;

public interface RuoloDao {

	public Ruolo ricercaPerId(String Id);

	public void inserisci(Ruolo i);

	public boolean aggiorna(Ruolo i);

	public boolean elimina(String idRuolo);

}
