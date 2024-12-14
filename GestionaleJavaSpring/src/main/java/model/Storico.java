package model;

public class Storico {

	private String idStorico;
	private int matricola;
	private String idRuolo;
	private String dataInizio;
	private String dataFine;
	
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
	@Override
	public String toString() {
		return "Storico [idStorico=" + idStorico + ", matricola=" + matricola
				+ ", idRuolo=" + idRuolo + ", dataInizio=" + dataInizio
				+ ", dataFine=" + dataFine + "]";
	}
	
	
	
}
