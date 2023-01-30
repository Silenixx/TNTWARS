package fr.silenix.tntwars.Bdd;

public class DbCretentials {
	
	private String host;
	private String user;
	private String pass;
	private String dbName;
	private int port;



	public DbCretentials(String host, String user, String pass, String dbName, int port) {
		super();
		this.host = host;
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
		this.port = port;
	}


	public String toUri() {
		final StringBuilder sb = new StringBuilder();
		return sb.append("jdbc:mysql://")
			.append(host)
			.append(":")
			.append(port)
			.append("/")
			.append(dbName).toString();
	}

	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}

	


}
