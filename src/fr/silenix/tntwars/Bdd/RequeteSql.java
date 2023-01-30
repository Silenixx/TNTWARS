package fr.silenix.tntwars.Bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.silenix.tntwars.GMain;

public class RequeteSql {

	private Connection dbConnect;

	public RequeteSql(GMain gmain) {
		try {
			this.dbConnect = gmain.dataBaseManager.getDbConnectionMoney().getConnection();
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}
	
	
	public int GetMoneyJoueur(String Name) {
		
		try {
			final PreparedStatement prepare = this.dbConnect.prepareStatement("SELECT money FROM users WHERE name = ?; ");
			prepare.setString(1, Name);
			final ResultSet rs = prepare.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("money");
			}else {
				return 0;
			}
			
			
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
}
