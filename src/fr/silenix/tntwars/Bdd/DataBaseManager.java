package fr.silenix.tntwars.Bdd;

import java.sql.SQLException;

public class DataBaseManager {

	private DbConnection dbConnectionMoney;

	public DataBaseManager() {
		
		DbCretentials credential = new DbCretentials("91.121.230.45", "lnzrhr_helkadia_db", "u%-_y0MOW42*6dvL", "lnzrhr_helkadia_db", 3306);
		
		this.dbConnectionMoney = new DbConnection(credential);
		
		
		
	}
	
	
	
	public DbConnection getDbConnectionMoney() {
		return dbConnectionMoney;
	}





	public void close() {
		try {
			this.dbConnectionMoney.close();
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}
	
	
	
}
