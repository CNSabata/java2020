package fr.aliptic.gestion.produits;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductLine {
	private String id;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	
	public ProductLine(String id, String textDescription, String htmlDescription, byte[] image) {
		super();
		this.id = id;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTextDescription() {
		return textDescription;
	}
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	public String getHtmlDescription() {
		return htmlDescription;
	}
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "ProductLine [" + 
				Arrays.stream(new String[] {id, textDescription})
		.collect(Collectors.joining(", ")) + "]";
	}
}
