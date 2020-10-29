package sk.ajt.bo_aplikacia;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {

	private static final String URL = "jdbc:derby:KlientiDB;create=true";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	// Zostrojime spojenie (most)
	private Connection conn = null;
	private Statement createStatement = null;
	private DatabaseMetaData dbmd = null;

	public DataBase() {
		// Skuska spojenia
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("Connection Successful.");
		} catch (SQLException e) {
			System.out.println("" + e);
			System.out.println("There is something wrong with the connection.");
		}

		// Ak je spojenie tak vytvorime "dodavku".
		if (conn != null) {
			try {
				createStatement = conn.createStatement();
			} catch (SQLException e) {
				System.out.println("There is something wrong with creating the create statement");
				e.printStackTrace();
			}
		}
		// Testujeme databasu ci je prazdny ? Checkujeme ci existuje data table.
		try {
			dbmd = conn.getMetaData();
		} catch (SQLException e) {
			System.out.println("There is something wrong with creating DatabaseMetaData.");
		}

		try {
			ResultSet rs = dbmd.getTables(null, "APP", "KLIENTI", null);
			if (!rs.next()) {
				String sql = "create table KLIENTI("
						+ "meno varchar(80), "
						+ "priezvisko varchar(80), "
						+ "rodneCislo varchar(80), "
						+ "idUctu varchar(80), "
						+ "aktualnyZostatok varchar(80), "
						+ "bonus varchar(80))";
				createStatement.execute(sql);
			}
		} catch (SQLException e) {
			System.out.println("There is something wrong with creating the data table.");
			e.printStackTrace();
		}
	}

	public ArrayList<Klient> getAllKlients() {
		String sql = "select * from KLIENTI";
		ArrayList<Klient> klienti = null;
		try {
			ResultSet rs = createStatement.executeQuery(sql);
			klienti = new ArrayList<Klient>();
			while (rs.next()) {
				String meno = rs.getString("meno");
				String priezvisko = rs.getString("priezvisko");
				String rodneCislo = rs.getString("rodneCislo");
				long idUctu = rs.getLong("idUctu");
				double aktualnyZostatok = rs.getDouble("aktualnyZostatok");
				double bonus = rs.getDouble("bonus");
				
				BankovyUcet ucet = new BankovyUcet(idUctu, aktualnyZostatok, bonus);
				Klient klient = new Klient(meno, priezvisko, rodneCislo, ucet);
				
				klienti.add(klient);
			}
		} catch (SQLException e) {
			System.out.println("There is something wrong with get all contacts.");
			e.printStackTrace();
		}
		return klienti;
	}

	public void addNewKlient(Klient klient) {
		String sql = "insert into KLIENTI (meno, priezvisko, rodneCislo, idUctu, aktualnyZostatok, bonus) values (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, klient.getMeno());
			preparedStatement.setString(2, klient.getPriezvisko());
			preparedStatement.setString(3, klient.getRodneCislo());
			preparedStatement.setLong(4, klient.getUcet().getIdUctu());
			preparedStatement.setDouble(5, klient.getUcet().getAktualnyZostatok());
			preparedStatement.setDouble(6, klient.getUcet().getBonus());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("There is something wrong with add new contact to database.");
			e.printStackTrace();
		}
	}

	public void updateUcet(BankovyUcet ucet) {
		String sql = "update KLIENTI set aktualnyZostatok = ? where idUctu = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setDouble(1, ucet.getAktualnyZostatok());
			preparedStatement.setLong(2, ucet.getIdUctu());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("There is something wrong with update new contact to database.");
			e.printStackTrace();
		}
	}

//	public void removeContact(Klient person) {
//		String sql = "delete from contacts where id = ?";
//		try {
//			PreparedStatement preparedStatement = conn.prepareStatement(sql);
//			preparedStatement.setInt(1, Integer.parseInt(person.getId()));
//			preparedStatement.execute();
//		} catch (SQLException e) {
//			System.out.println("There is something wrong with delete contacts from database.");
//			e.printStackTrace();
//		}
//	}
}
