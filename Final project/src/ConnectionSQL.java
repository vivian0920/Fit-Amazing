import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
	
	
	private static String url ;
	private static String username;
	private static String password ;
    
	public static Connection getConnection() throws SQLException{
		String server = "jdbc:mysql://140.119.19.79/";
		String database = "Lab";
		url=server+database;
		username = "MG13";
		password = "qdj4e8";
		return DriverManager.getConnection(url, username, password);
	}
	
}
