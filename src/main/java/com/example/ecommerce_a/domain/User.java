package com.example.ecommerce_a.domain;

/**
 * ユーザー情報を表すドメイン
 * 
 * @author mikami
 * 
 */
public class User {
	private Integer id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private Integer zipcode;
	private String prefectureTown;
	private String streetAddress;
	private String building;
	private Integer telephone;
	private String creditcard;

	public User(Integer id, String firstName, String lastName, String userName, String email, String password,
			Integer zipcode, String prefectureTown, String streetAddress, String building, Integer telephone,
			String creditcard) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.zipcode = zipcode;
		this.prefectureTown = prefectureTown;
		this.streetAddress = streetAddress;
		this.building = building;
		this.telephone = telephone;
		this.creditcard = creditcard;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrefectureTown() {
		return prefectureTown;
	}

	public void setPrefectureTown(String prefectureTown) {
		this.prefectureTown = prefectureTown;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", email=" + email + ", password=" + password + ", zipcode=" + zipcode + ", prefectureTown="
				+ prefectureTown + ", streetAddress=" + streetAddress + ", building=" + building + ", telephone="
				+ telephone + ", creditcard=" + creditcard + "]";
	}
	
}
