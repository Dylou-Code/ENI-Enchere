package fr.eni.encheres.bo;

public class Utilisateurs {
	
		private int id;
		private String pseudo;
	 	private String firstName;
	    private String lastName;
	    private String email;
	    private String phoneNumber;
	    private String street;
	    private String zipCode;
	    private String city;
	    private String password;
	    private int credit;
	    private boolean admin;
	    
	     
		public Utilisateurs(int id, String pseudo, String firstName, String lastName, String email, String phoneNumber,
				String street, String zipCode, String city, String password, int credit, boolean admin) {
			super();
			this.id = id;
			this.pseudo = pseudo;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.street = street;
			this.zipCode = zipCode;
			this.city = city;
			this.password = password;
			this.credit = credit;
			this.admin = admin;
		}
		
		
		public Utilisateurs(String pseudo, String firstName, String lastName, String email, String phoneNumber,
				String street, String zipCode, String city, String password) {
			super();
			this.pseudo = pseudo;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.street = street;
			this.zipCode = zipCode;
			this.city = city;
			this.password = password;
		}


		public Utilisateurs() {
			super();
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPseudo() {
			return pseudo;
		}
		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getCredit() {
			return credit;
		}
		public void setCredit(int credit) {
			this.credit = credit;
		}
		public boolean isAdmin() {
			return admin;
		}
		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		//permet de débug
		@Override
		public String toString() {
			return "Utilisateurs [id=" + id + ", pseudo=" + pseudo + ", firstName=" + firstName + ", lastName="
					+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", street=" + street
					+ ", zipCode=" + zipCode + ", city=" + city + ", password=" + password + ", credit=" + credit
					+ ", admin=" + admin + "]";
		}
	  
		
		
	    
}
