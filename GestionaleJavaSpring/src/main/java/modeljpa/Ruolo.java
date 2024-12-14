package modeljpa;

import java.util.List;

public class Ruolo {
	private String idRuolo;

	private String descrizione;

private List<Storico>storicos;

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

public List<Storico> getStoricos() {
	return storicos;
}

public void setStoricos(List<Storico> storicos) {
	this.storicos = storicos;
}

}
