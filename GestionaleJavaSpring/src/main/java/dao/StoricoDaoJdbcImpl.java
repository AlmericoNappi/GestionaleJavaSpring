package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Storico;

public class StoricoDaoJdbcImpl implements StoricoDao {

	Storico sto = new Storico();

	public void inserisci(Storico i) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "INSERT INTO storico (idStorico, idRuolo, dataInizio, dataFine, matricola) VALUES(?,?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getIdStorico());
			cmd.setString(2, i.getIdRuolo());
			cmd.setString(3, i.getDataInizio());
			cmd.setString(4, i.getDataFine());
			cmd.setInt(5, i.getMatricola());

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

	public boolean aggiorna(Storico i) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			//String driver = "com.mysql.jdbc.Driver";
			String driver ="com.mysql.cj.jdbc.Driver";
			
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "update storico set matricola =?, idRuolo=?, dataInizio=?, dataFine = ? where idStorico =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, i.getMatricola());
			cmd.setString(2, i.getIdRuolo());
			cmd.setString(3, i.getDataInizio());
			cmd.setString(4, i.getDataFine());
			cmd.setString(5, i.getIdStorico());

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

	public boolean elimina(String idStorico) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "delete from storico where idStorico =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, idStorico);

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

	public Storico ricercaPerIdStorico(String IdStorico) {
		Storico sto = null;
		try {

			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String qry = "SELECT * FROM storico WHERE idStorico = ? ";

			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			cmd.setString(1, IdStorico);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			
			if (esiste) {
				sto = new Storico();
				sto.setIdStorico(IdStorico);
				sto.setIdRuolo(res.getString("idRuolo"));
				sto.setMatricola(res.getInt("matricola"));
				sto.setDataFine(res.getString("dataFine"));
				sto.setDataInizio(res.getString("dataInizio"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return sto;
	}
	public List<Storico> ricercaPerMatricola(int matricola)  {
		List<Storico> listaStorici = new ArrayList<>();
		try {

			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String qry = "SELECT * FROM storico WHERE matricola = ? ";

			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			cmd.setInt(1, matricola);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			
			while (esiste) {
				Storico r = new Storico();
				r.setIdStorico(res.getString("idStorico"));
				r.setIdRuolo(res.getString("idRuolo"));
				r.setMatricola(res.getInt("matricola"));
				r.setDataFine(res.getString("dataFine"));
				r.setDataInizio(res.getString("dataInizio"));
				
				listaStorici.add(r);

				esiste = res.next();
				
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaStorici;
	}
	
	public static void main(String[] args) throws SQLException {
//		StoricoDao stoDao = new StoricoDaoImpl();
//
//		Storico s1 = new Storico();
//		s1.setIdStorico("S105");
//		s1.setMatricola(5);
//		s1.setIdRuolo("a105");
//		s1.setDataFine("02-05-2002");
//		s1.setDataInizio("03-09-2009");
//
//		Storico s2 = new Storico();
//		s2.setIdStorico("S104");
//		s2.setMatricola(2);
//		s2.setIdRuolo("a104");
//		s2.setDataFine("02-05-2002");
//		s2.setDataInizio("02-05-2012");
////
//		 stoDao.inserisci(s1);
//		 stoDao.inserisci(s2);

//		// stoDao.aggiorna(s2);
//		// stoDao.aggiungi(s2);
//		// stoDao.elimina("s104");
//		stoDao.ricercaPerIdStorico("s104");
	}

}
