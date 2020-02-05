package aliptic.java.services;

import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aliptic.java.gestion.produits.ProductLine;
import aliptic.java.gestion.produits.DAO;
import aliptic.java.gestion.produits.ProductDBUtils;
import aliptic.java.gestion.produits.ProductLineDAO;
import aliptic.java.services.exceptions.ProductNotFoundException;

@RestController
public class ProductLineController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductLineController.class);
	
	@GetMapping(path = "/pls", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ProductLine> productLinesAll(@RequestParam(value = "code", defaultValue = "Classic Cars") String code) {
		List<ProductLine> products = null;
		try (Connection connection = ProductDBUtils.getInstance().getConnection()) {
			DAO<ProductLine> productDAO = new ProductLineDAO(connection);
			products = productDAO.findAll();
			//products.stream().forEach(p -> System.out.println(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@GetMapping(path = "/pl", produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductLine productLineDAO(@RequestParam(value = "code", defaultValue = "Classic Cars") String code) {
		ProductLine productLine = null;
		try (Connection connection = ProductDBUtils.getInstance().getConnection()){
			DAO<ProductLine> productLineDAO = new ProductLineDAO(connection);
			productLine = productLineDAO.find(code);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.toString());
		}
		if (productLine == null) {
			LOGGER.debug("ProductNotFound : " + code);
			throw new ProductNotFoundException(code);
		}
		return productLine;
	}
	
	@GetMapping(path = "/plJSON", produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductLine productLineJSON(@RequestParam(value = "code") String code) {
		return new ProductLine(code, "Test description JSON", "");
	}
	
	@GetMapping(path = "/plXML", produces=MediaType.APPLICATION_XML_VALUE)
	public ProductLine productLineXML(@RequestParam(value = "code") String code) {
		return new ProductLine(code, "Test description XML", "");
	}
}
