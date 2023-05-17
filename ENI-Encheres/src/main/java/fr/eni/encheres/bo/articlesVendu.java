package fr.eni.encheres.bo;

import java.time.LocalDate;

/*
 * La classe ArticleVendus regroupe les attribus des colonnes de la table 
 * articles_vendus dans la BDD
 * Elle dispose aussi d'attributs en relation avec d'autres classes qui 
 * correspond aux clés étrangères de la table dans la bdd 
 */
public class articlesVendu {
	private int no_article; 
	private String articleName; 
	private String description; 
	private LocalDate dateStartEnchere; 
	private LocalDate dateEndEnchere; 
	private int prixInitial; 
	private int prixVente; 
	private Utilisateurs utilisateur; 
	private Categories categorie; 
	private String etat_vente; 
	private String image;
	private Retraits retrait;
	
	
	//initilisation du constructeur par default 
	public articlesVendu() {
		super();;
	}


	public articlesVendu(int no_article, String articleName, String description, LocalDate dateStartEnchere,
			LocalDate dateEndEnchere, int prixInitial, int prixVente, Utilisateurs utilisateur, Categories categorie,
			String etat_vente, String image, Retraits retrait) {
		super();
		this.no_article = no_article;
		this.articleName = articleName;
		this.description = description;
		this.dateStartEnchere = dateStartEnchere;
		this.dateEndEnchere = dateEndEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.etat_vente = etat_vente;
		this.image = image;
		this.retrait = retrait;
	}


	public int getNo_article() {
		return no_article;
	}


	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}


	public String getArticleName() {
		return articleName;
	}


	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateStartEnchere() {
		return dateStartEnchere;
	}


	public void setDateStartEnchere(LocalDate dateStartEnchere) {
		this.dateStartEnchere = dateStartEnchere;
	}


	public LocalDate getDateEndEnchere() {
		return dateEndEnchere;
	}


	public void setDateEndEnchere(LocalDate dateEndEnchere) {
		this.dateEndEnchere = dateEndEnchere;
	}


	public int getPrixInitial() {
		return prixInitial;
	}


	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Categories getCategorie() {
		return categorie;
	}


	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}


	public String getEtat_vente() {
		return etat_vente;
	}


	public void setEtat_vente(String etat_vente) {
		this.etat_vente = etat_vente;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Retraits getRetrait() {
		return retrait;
	}


	public void setRetrait(Retraits retrait) {
		this.retrait = retrait;
	}


	@Override
	public String toString() {
		return "articlesVendu [no_article=" + no_article + ", articleName=" + articleName + ", description="
				+ description + ", prixInitial=" + prixInitial + ", prixVente=" + prixVente + ", utilisateur="
				+ utilisateur + ", etat_vente=" + etat_vente + ", image=" + image + ", retrait=" + retrait + "]";
	}
	
	
	
	
	
	
}
