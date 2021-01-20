package com.example.demo.models;

public class AJAXResponseBody {

	// Gio hang
	int quantityCart;
	int quantityItem;
	float priceItem;
	float priceTotal;

	// Danh gia/binh luan san pham
	String idComment;
	int rate;
	String dateInfo;
	String imageslink;
	String fullname;
	String content;

	// Chinh sua thong tin ca nhan
	String username;
	String password;
	String phone;
	String email;
	String address;
	String idAddressOld;
	String idAddressNew;

	// Ma xac thuc
	String code;
	
	String idCourse;
	String idVideo;
	
	

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantityCart() {
		return quantityCart;
	}

	public void setQuantityCart(int quantityCart) {
		this.quantityCart = quantityCart;
	}

	public int getQuantityItem() {
		return quantityItem;
	}

	public void setQuantityItem(int quantityItem) {
		this.quantityItem = quantityItem;
	}

	public float getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(float priceItem) {
		this.priceItem = priceItem;
	}

	public float getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getImageslink() {
		return imageslink;
	}

	public void setImageslink(String imageslink) {
		this.imageslink = imageslink;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(String dateInfo) {
		this.dateInfo = dateInfo;
	}

	public String getIdComment() {
		return idComment;
	}

	public void setIdComment(String idComment) {
		this.idComment = idComment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdAddressOld() {
		return idAddressOld;
	}

	public void setIdAddressOld(String idAddressOld) {
		this.idAddressOld = idAddressOld;
	}

	public String getIdAddressNew() {
		return idAddressNew;
	}

	public void setIdAddressNew(String idAddressNew) {
		this.idAddressNew = idAddressNew;
	}

}
