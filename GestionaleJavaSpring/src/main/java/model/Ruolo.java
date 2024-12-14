package model;


public class Ruolo {
	
	private String idRuolo;
	private String descrizione;
	
	public String getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(String idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", descrizione=" + descrizione
				+ "]";
	}
	
	
}
