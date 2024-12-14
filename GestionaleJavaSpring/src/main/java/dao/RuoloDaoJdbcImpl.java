package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Ruolo;

public class RuoloDaoJdbcImpl implements RuoloDao {

	Ruolo ruo = new Ruolo();

	public void inserisci(Ruolo i) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "INSERT INTO ruolo(idRuolo, descrizione) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getIdRuolo());
			cmd.setString(2, i.getDescrizione());

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

	public boolean elimina(String idRuolo) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "delete from ruolo where idRuolo =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, idRuolo);

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

	public boolean aggiorna(Ruolo i) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "update ruolo set descrizione = ? where idRuolo =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getDescrizione());
			cmd.setString(2, i.getIdRuolo());
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

	public Ruolo ricercaPerId(String IdRu) {
		Ruolo ruo = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String qry = "SELECT * FROM ruolo WHERE idRuolo = ? ";

			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			cmd.setString(1, IdRu);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			
			if (esiste) {
				ruo = new Ruolo();
				ruo.setIdRuolo(IdRu);
				ruo.setDescrizione(res.getString("descrizione"));
			
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ruo;
	}

	public static void main(String[] args) throws SQLException {
		RuoloDao RuoDao = new RuoloDaoImpl();

		Ruolo r1 = new Ruolo();
		r1.setIdRuolo("a102");
		r1.setDescrizione("despaparecidos");

		Ruolo r2 = new Ruolo();
		r2.setIdRuolo("a105");
		r2.setDescrizione("findit");

		Ruolo r3 = new Ruolo();
		r3.setIdRuolo("a105");
		r3.setDescrizione("semat");

		Ruolo r4 = new Ruolo();
		r4.setIdRuolo("a104");
		r4.setDescrizione("delaz");

//		RuoDao.aggiungi(r4);
//		RuoDao.aggiorna(r4);
//		RuoDao.elimina("a102");
		RuoDao.ricercaPerId("a105");
	}
}
