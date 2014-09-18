
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rset;
	private static String sql;	
	
	public static void main(String[] argv) throws SQLException{

		con = getConnection();
		

	
}//close main
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/COEN275RCM", "root", "19890226");
		}catch(Exception e){
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		return conn;
	}

}
