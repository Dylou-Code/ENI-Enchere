package fr.eni.encheres.bo;


public class Categories {

	private int id;
	private String name;
	
	public Categories() {
		super();
	} 
	
	public Categories(int no_categorie, String libelle) {
		super();
		this.id = id;
		this.name = name;
	}
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + "]";
	}
	
}
