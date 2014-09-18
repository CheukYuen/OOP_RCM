
import java.sql.*;
import java.util.ArrayList;


public class DealTable {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rset;
	private static String sql;
	private Machine localRCM;

	public static void insertDeal() throws Exception {

		con = DBConnection.getConnection();
		// sql =
		// "insert into rcm4(dealID, glass, aluminum, paper, electronics, plastic, cash, dealDate ) value(?,?,?,?,?,?,?,?)";
		// sql = "insert into rcm4(glass) value(2.0)";
		// sql = "update machine set glassSum = glassSum +7.0,"
		// + " weightSum = weightSum + 99.0,"
		// + " cashSum = cashSum + 99.0 where machineID = 2 ";
		// sql =
		// "update machine set glassSum = glassSum +1 where machineID = 1 ";
		pstmt = con.prepareStatement(sql);
		pstmt.execute();
		con.close();

	}

	public static void updateTableCash(double payCash, int memberID)
			throws SQLException {

		con = DBConnection.getConnection();
		sql = "update machine set cashSum =  ?  where machineID = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, payCash);
		pstmt.setInt(2, memberID);
		pstmt.execute();
		con.close();

	}

	public static void updateTableData(ItemType itemType, double itemWeight,
			int memberID) throws SQLException {

		con = DBConnection.getConnection();
		int itemTypeNum = 5;

		// sql = "insert into rcm4 (glass, cash) value (?, ?)";
		// pstmt = con.prepareStatement(sql);
		// pstmt.setDouble(1, itemWeight);
		// pstmt.setDouble(2, cash);
		// pstmt.execute();
		// con.close();

		switch (itemType) {
		case glass:

			// sql = "insert into rcm5 (glass, cash) value(?, ?)";
			sql = "update machine set glassSum = glassSum +?,"
					+ " weightSum = weightSum + ?" + " where machineID = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, itemWeight);
			pstmt.setDouble(2, itemWeight);
			pstmt.setInt(3, memberID);
			pstmt.execute();
			con.close();
			break;
		case aluminum:

			sql = "update machine set aluminumSum = aluminumSum +?,"
					+ " weightSum = weightSum + ?" + " where machineID = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, itemWeight);
			pstmt.setDouble(2, itemWeight);

			pstmt.setInt(3, memberID);

			pstmt.execute();
			con.close();
			break;
		case plastic:
			sql = "update machine set plasticSum = plasticSum +?,"
					+ " weightSum = weightSum + ?" + " where machineID = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, itemWeight);
			pstmt.setDouble(2, itemWeight);
			pstmt.setInt(3, memberID);
			pstmt.execute();
			con.close();
			break;
		case paper:

			sql = "update machine set paperSum = paperSum +?,"
					+ " weightSum = weightSum + ?" + " where machineID = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, itemWeight);
			pstmt.setDouble(2, itemWeight);
			pstmt.setInt(3, memberID);
			pstmt.execute();
			con.close();
			break;
		case elctronics:
			sql = "update machine set elctronicsSum = elctronicsSum +?,"
					+ " weightSum = weightSum + ?" + " where machineID = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, itemWeight);
			pstmt.setDouble(2, itemWeight);
			pstmt.setInt(3, memberID);
			pstmt.execute();
			con.close();
			break;

		}

	}

	public static void main(String[] args) throws Exception {

		//insertDeal();
		// testData(9.9, 2.2);
		// ItemType item = ItemType.glass;
		// testData(item, 10.1, 19.9);
	}

}
