package modeljpa;

public class Storico {
	private static final long serialVersionUID = 1L;

	private String idStorico;

	private int matricola;
	
	private String idRuolo;
	
	private String dataInizio;
	
	private String dataFine;
	
	private Impiegato impiegato;
	
	private Ruolo ruolo;

	public String getIdStorico() {
		return idStorico;
	}

	public void setIdStorico(String idStorico) {
		this.idStorico = idStorico;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(String idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public Impiegato getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}