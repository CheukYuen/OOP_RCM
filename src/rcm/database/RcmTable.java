import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RcmTable {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rset;
	private static String sql;

//	public static void main(String[] argv) {
//
//		try {
//
//			createRcmTable();
//
//		} catch (SQLException e) {
//
//			System.out.println(e.getMessage());
//
//		}
//
//	}
	private static void createRcmTable() throws SQLException {

		con = null;
		pstmt = null;

		String dropTableDeal = "DROP TABLE IF EXISTS deal";
		String createTableRCM = 
				 "CREATE TABLE deal ("
				+ "dealID INTEGER NOT NULL AUTO_INCREMENT," + "glass DOUBLE ,"
				+ "aluminum DOUBLE ," + "paper DOUBLE ,"
				+ "electronics DOUBLE ," + "plastic DOUBLE," + "cash DOUBLE,"
				+ "weight DOUBLE," + "dealDate TIMESTAMP,"
				+ "PRIMARY KEY (dealID))";
//		 String createTableRCM = "CREATE TABLE REGISTRATION " +
//                 "(id INTEGER not NULL, " +
//                 " first VARCHAR(255), " + 
//                 " last VARCHAR(255), " + 
//                 " age INTEGER, " + 
//                 " PRIMARY KEY ( id ))"; 

		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(dropTableDeal);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(createTableRCM);		
			System.out.println(createTableRCM);
			pstmt.executeUpdate();
			System.out.println("RCM table is created!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
