package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.util.Date;

public class Encheres {
	
	private int id;
	private LocalDate date;
	private int price;
	private int idArticle;
	private int idUser;
	
	
	public Encheres(int id, LocalDate date, int price, int idArticle, int idUser) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.idArticle = idArticle;
		this.idUser = idUser;
	}
	
	public Encheres(LocalDate date, int price, int idArticle, int idUser) {
		super();
		this.date = date;
		this.price = price;
		this.idArticle = idArticle;
		this.idUser = idUser;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public int getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	@Override
	public String toString() {
		return "Encheres [id=" + id + ", date=" + date + ", price=" + price + ", idArticle=" + idArticle + ", idUser="
				+ idUser + "]";
	}
}
