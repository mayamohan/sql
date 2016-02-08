package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompanyDAO {
	private String url = "jdbc:mysql://localhost:3306/companydb";
	private String username = "student";
	private String password = "student";
	private Connection conn;
	private ArrayList<ArrayList<String>> data;

	public ArrayList<ArrayList<String>> getQuery(String s) {

		try {
			data = new ArrayList<>();
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement(); /// method to execute nbb
			ResultSet rs = stmt.executeQuery(s);
			ArrayList<String> row = new ArrayList<>();
			ArrayList<String> header = new ArrayList<>();
			int counter = rs.getMetaData().getColumnCount();

			for (int i = 1; i < (counter+1); i++) {
				header.add(rs.getMetaData().getColumnName(i));
			}
			data.add(header);
			while (rs.next()) {
				row = new ArrayList<>();
				for (int i = 1; i < (counter+1); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		return data;
	}

	public int getUpdate(String s) {
		int updater =0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			updater = stmt.executeUpdate(s);
			stmt.close();
			conn.close();
			} 
		catch (Exception e) {
			System.out.println(e);
		}
		return updater;
}
}