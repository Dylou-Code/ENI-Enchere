package fr.eni.encheres.bo;


public class Categories {

	private int id;
	private String name;
	private String defaultValue = null;
	
	public Categories() {
		super();
	} 
	
	public Categories(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Categories(int id, String name, String defaultValue) {
		super();
		this.id = id;
		this.name = name;
		this.defaultValue = defaultValue;
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
