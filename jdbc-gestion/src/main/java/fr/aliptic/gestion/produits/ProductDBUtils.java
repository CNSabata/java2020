package fr.aliptic.gestion.produits;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

public class ProductDBUtils {
	public String getDriver() {
		return driver;
	}
	public String getDbms() {
		return dbms;
	}
	public String getServer() {
		return server;
	}
	public String getPort() {
		return port;
	}
	public String getDatabase() {
		return database;
	}
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "ProductDBUtils[" +
	Arrays.stream(new String[] { dbms, driver, server, port, database, user, password })
		.collect(Collectors.joining(", ")) + "]";
	}
	
	private String driver;
	private String dbms;
	private String server;
	private String port;
	private String database;
	private String url;
	private String user;
	private String password;
	
	
	private static ProductDBUtils instance = new ProductDBUtils();
	
	private ProductDBUtils() {
		try {
			loadProperties();
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static ProductDBUtils getInstance() {
		return instance;
	}
    
    public Connection getConnection() throws SQLException {
    	return DriverManager
    			.getConnection("jdbc:" + url, user, password);
    }
	
	private void loadProperties() {
		Properties properties = new Properties();
		try {
			properties.load(ProductDBUtils.class
					.getClassLoader()
					.getResourceAsStream("db-products.properties"));
			
			driver = (String) properties.getProperty("driver");
			dbms = (String) properties.getProperty("dbms");
			server = (String) properties.getProperty("server");
			port = (String) properties.getProperty("port");
			database = (String) properties.getProperty("database");
			url = (String) properties.getProperty("dbms") + "://" +
					(String) properties.getProperty("server") + ":" + 
					(String) properties.getProperty("port") + "/" +
					(String) properties.getProperty("database");
			user = (String) properties.getProperty("user");
			password = (String) properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
