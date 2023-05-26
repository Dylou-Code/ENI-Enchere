package fr.eni.encheres.bo;

public class Retraits {
	
	private ArticlesVendu article;
	private String street;
	private String zipCode;
	private String city;
	
	//le constructeur par défaut 
	public Retraits() {
		super();
	}
	
	public Retraits(ArticlesVendu article, String street, String zipCode, String city) {
		super();
		this.article = article;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public Retraits(String street, String zipCode, String city) {
		super();
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArticlesVendu getArticle() {
		return article;
	}

	public void setArticle(ArticlesVendu article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return street + " " + zipCode + " " + city;
	}

	
	
}
