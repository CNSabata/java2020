package fr.aliptic.gestion.produits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductLineDAO<T> extends DAO<ProductLine> {
	
	private static final String REQUEST_SELECT_ALL = "SELECT "
			+ "productLine, textDescription, htmlDescription, image "
			+ "FROM productlines";
	
	private static final String REQUEST_SELECT = "SELECT "
			+ "productLine, textDescription, htmlDescription, image "
			+ "FROM productlines "
			+ "WHERE productLine = ?";

	/* INSERT INTO table_name (column1, column2, column3, ...)
	 * VALUES (value1, value2, value3, ...); 
	 */
	
	private static final String REQUEST_INSERT = "INSERT INTO productlines "
			+ "(productLine, textDescription, htmlDescription, image) "
			+ "VALUES (?, ?, ?, ?)";
	
	/* UPDATE table_name
	 * SET column1 = value1, column2 = value2, ...
     * WHERE condition;
     */
	private static final String REQUEST_UPDATE = "UPDATE productlines "
			+ "SET textDescription = ?, "
			+ "htmlDescription = ?, "
			+ "image = ? "
			+ "WHERE productLine = ?";
	
	/* DELETE FROM table_name
	 * WHERE condition;
	 */
	
	private static final String REQUEST_DELETE = "DELETE FROM productlines "
			+ "WHERE productLine = ?";

	
	
	private ProductDBUtils pDBU = ProductDBUtils.getInstance();

	public ProductLineDAO(Connection connection) {
		super(connection);
		try {
			connection = pDBU.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(ProductLine productLine) {
		if (productLine == null || productLine.getId() == null)
			throw new IllegalArgumentException("Paramètre 'productLine' non valide.");
		
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_INSERT)) {
			pstm.setString(1, productLine.getId());
			pstm.setString(2, productLine.getTextDescription());
			pstm.setString(3, productLine.getHtmlDescription());
			pstm.setString(4, null);
			
			int res = pstm.executeUpdate();
				if(res > 0)
					out = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	
	@Override
	public boolean update(ProductLine productLine) {
		if (productLine == null || productLine.getId() == null)
			throw new IllegalArgumentException("Paramètre 'productLine' non valide.");
		
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_UPDATE)) {
			pstm.setString(1, productLine.getTextDescription());
			pstm.setString(2, productLine.getHtmlDescription());
			pstm.setBytes (3, productLine.getImage());
			pstm.setString(4, productLine.getId());
		
			System.out.println(pstm);
			
			int res = pstm.executeUpdate();
				if(res > 0)
					out = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	
	@Override
	public boolean delete(ProductLine productLine) {
		if (productLine == null) {
			throw new IllegalArgumentException("Paramètre 'productLine' "
					+ "non valide.");
		}
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_DELETE)) {
			pstm.setString(1, productLine.getId());
			
			int res = pstm.executeUpdate();
				if(res > 0)
					out = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}

	@Override
	public ProductLine find(Object productLine) {
		if (productLine == null) {
			throw new IllegalArgumentException("Paramètre 'productLine' "
					+ "non valide.");
		}
		if (!(productLine instanceof String)) {
			throw new IllegalArgumentException("Le paramètre est un " 
					+ "productLine, il doit être de type String.");
		}
		ProductLine out = null;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_SELECT); ){
			pstm.setString(1, (String) productLine);
			try (ResultSet resultSet = pstm.executeQuery();) {
				if(resultSet.next()) {
					out = new ProductLine(
							resultSet.getString("productLine"),
							resultSet.getString("textDescription"),
							resultSet.getString("htmlDescription"),
							null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	
	@Override
	public List<ProductLine> findAll() {
		List<ProductLine> productLines = new ArrayList<ProductLine>();
		try (Statement stmt = connection.createStatement();
				ResultSet res = stmt.executeQuery(REQUEST_SELECT_ALL);) {
			while (res.next()) {
				productLines.add(new ProductLine(
						res.getString("productLine"),
						res.getString("textDescription"),
						res.getString("htmlDescription"), null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return productLines;
	}

}
