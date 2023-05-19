package fr.eni.encheres.bo;

public class Retraits {
	
	private String street;
	private String zipCode;
	private String city;
	private ArticlesVendu article;
	
	//le constructeur par défaut 
	public Retraits() {
		super();
	}
	
	public Retraits(ArticlesVendu article, String street, String zipCode, String city) {
		super();
		this.article = article;
		this.street = street;
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
		return "Retraits [street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", article=" + article + "]";
	}
	
}
