package fr.silenix.tntwars.Bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbConnection {

	private DbCretentials dbCredentials;

	private Connection connection;

	public DbConnection(DbCretentials dbCredentials) {

		this.dbCredentials = dbCredentials;
		this.connect();
	}

	private void connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.dbCredentials.toUri(), this.dbCredentials.getUser(),
					this.dbCredentials.getPass());

			Logger.getLogger("Minecraft").info("Connexion établie");
		} catch (SQLException | ClassNotFoundException ex) {
			// TODO Bloc catch généré automatiquement
			ex.printStackTrace();
		}

	}

	public void close() throws SQLException {

		if (this.connection != null) {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}
		}

	}

	public Connection getConnection() throws SQLException {
		if (this.connection != null) {
			if (!this.connection.isClosed()) {
				return this.connection;
			}
		}
		connect();
		return this.connection;
	}

}
