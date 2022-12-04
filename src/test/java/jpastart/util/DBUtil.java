package jpastart.util;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void initTestData() {
		initData("/test-data.xml");
	}

	private static void initData(String dataFile) {
		IDatabaseConnection conn = null;

		try {
			conn = getDatabaseConnection();
			IDataSet data = createDataSet(dataFile);
			DatabaseOperation.CLEAN_INSERT.execute(conn, data);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			close(conn);
		}
	}

	private static IDatabaseConnection getDatabaseConnection()
			throws DatabaseUnitException, SQLException {
		return new DatabaseConnection(getConnection());
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/jpastart?characterEncoding=utf8&useSSL=false",
				"jpauser",
				"jpapass"
		);
	}

	private static IDataSet createDataSet(String resource)
			throws DataSetException, FileNotFoundException {
		return new XmlDataSet(
				new InputStreamReader(DBUtil.class.getResourceAsStream(resource))
		);
	}

	private static void close(IDatabaseConnection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
	}

	public static void close(Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
			}
	}

	public static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
	}
}
