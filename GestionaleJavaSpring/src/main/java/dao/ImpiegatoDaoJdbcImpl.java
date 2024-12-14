package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public class ImpiegatoDaoJdbcImpl implements ImpiegatoDao {


	public void inserisci(Impiegato i) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "INSERT INTO impiegato(Nome, Cognome, codiceFiscale, Matricola) VALUES(?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getNome());
			cmd.setString(2, i.getCognome());
			cmd.setString(3, i.getCodiceFiscale());
			cmd.setInt(4, i.getMatricola());

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public boolean aggiorna(Impiegato i) {

			Connection dbConnection = null;
			java.sql.PreparedStatement cmd = null;

			try {
				String driver = "com.mysql.cj.jdbc.Driver";

				Class.forName(driver);

				// Creiamo la stringa di connessione
				String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

				// Otteniamo una connessione con username e password
				dbConnection = DriverManager.getConnection(url, "root", "Alme191");

				String updateTableSQL = "update impiegato set nome=?, cognome=?, codiceFiscale=? where matricola =?";
				cmd = dbConnection.prepareStatement(updateTableSQL);

				cmd.setString(1, i.getNome());
				cmd.setString(2, i.getCognome());
				cmd.setString(3, i.getCodiceFiscale());
				cmd.setInt(4, i.getMatricola());
				// execute update SQL stetement
				cmd.executeUpdate();

				System.out.println("Record is updated to DBUSER table!");

			}

			catch (Exception e) {

				e.printStackTrace();
			} finally {

				if (cmd != null) {
					try {
						cmd.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (dbConnection != null) {
					try {
						dbConnection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return false;
		}


	public boolean elimina(String codiceFiscale) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "delete from impiegato where codiceFiscale =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, codiceFiscale);

			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return false;
	}
// false
	
	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {
		
			Impiegato imp = null;
			try {

				// QUERY
				// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
				String driver = "com.mysql.cj.jdbc.Driver";

				Class.forName(driver);

				// Creiamo la stringa di connessione
				String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

				// Otteniamo una connessione con username e password
				Connection con = DriverManager.getConnection(url, "root", "Alme191");

				String qry = "SELECT * FROM impiegato WHERE codiceFiscale = ?  ";

				// Creiamo un oggetto PrepareStatement per poter interrogare il db
				PreparedStatement cmd = con.prepareStatement(qry);

				cmd.setString(1, codiceFiscale);

				// Eseguiamo una query e immagazziniamone i risu3ltati
				// in un oggetto ResultSet
				ResultSet res = cmd.executeQuery();

				boolean esiste = res.next();// ---> la prima riga
				// --> seconda riga

				// Stampiamone i risultati riga per riga

				if (esiste) {
					imp = new Impiegato();
					imp.setCodiceFiscale(res.getString("codiceFiscale"));
					imp.setCognome(res.getString("cognome"));
					imp.setNome(res.getString("nome"));
					imp.setMatricola(res.getInt("matricola"));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("sdgfsda");

				e.printStackTrace();
			}
			return imp;
		}
	
	//inzio nuovo metodo ricercaImpiegatoPerCognome

	public List<Impiegato> ricercaImpiegatoPerCognome(String Cognome) {
		List<Impiegato> listaPersone = new ArrayList<>();
		try {

			// QUERY
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "root", "Alme191");

			String qry = "SELECT * FROM impiegato WHERE Cognome = ?  ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			cmd.setString(1, Cognome);

			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			while (esiste) {
				Impiegato imp = new Impiegato();
				imp.setCodiceFiscale(res.getString("codiceFiscale"));
				imp.setCognome(res.getString("cognome"));
				imp.setNome(res.getString("nome"));
				imp.setMatricola(res.getInt("matricola"));
				listaPersone.add(imp);
				esiste = res.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("sdgfsda");

			e.printStackTrace();
		}
		return listaPersone;
	}
	
	//fine

	public static void main(String[] args) throws SQLException {

		ImpiegatoDao impDao = new ImpiegatoDaoImpl();

		Impiegato i2 = new Impiegato();

		i2.setNome("alme");
		i2.setCognome("nappi");
		i2.setCodiceFiscale("trez");
		i2.setMatricola(3);
//	
//Impiegato i3 = new Impiegato();
//		
//		i3.setNome("faby");
//		i3.setCognome("tommaseo");
//		i3.setCodiceFiscale("quatroz");
//		i3.setMatricola(2);

		impDao.inserisci(i2);
//		
//		Impiegato i4 = new Impiegato();
//		
//		i4.setNome("Alme");
//		i4.setCognome("Nappi");
//		i4.setCodiceFiscale("trez");
//		i4.setMatricola(0003);
//		
//		impDao.aggiorna(i4);
//		impDao.elimina("doz");
//		Impiegato imp2 = impDao.ricercaPerCodiceFiscale("trez");
//		System.out.println(imp2.getCognome());
	}
}
