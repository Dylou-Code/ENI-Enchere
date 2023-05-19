package fr.eni.encheres.bo;

import java.util.Date;

public class Encheres {
	
	private int id;
	private Date date;
	private int price;
	private int idArticle;
	private int idUser;
	
	
	public Encheres(int id, Date date, int price, int idArticle, int idUser) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.idArticle = idArticle;
		this.idUser = idUser;
	}
	
	public Encheres(Date date, int price, int idArticle, int idUser) {
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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
}
