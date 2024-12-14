package modeljpa;

import java.util.List;


public class Impiegato{

		private String nome;
		
		private String cognome;
		
		private String codiceFiscale;
		private int matricola;

		private List<Storico> storicos;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		public int getMatricola() {
			return matricola;
		}

		public void setMatricola(int matricola) {
			this.matricola = matricola;
		}

		public List<Storico> getStoricos() {
			return storicos;
		}

		public void setStoricos(List<Storico> storicos) {
			this.storicos = storicos;
		}
		
		
		
}
