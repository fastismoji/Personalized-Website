package com.gmu.rmohod.bean;
/**
 * JavaBean class to store all Student's survey form data
 * 
 * @author Rasika
 *
 */
public class StudentBean {
	private String studentId;
	private String name;
	private String email;
	private String telephoneNumber;
	
	private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private String streetAddress;
	private String zipcode;
	private String city;
	private String state;
	
	private String graduationMonth;
	private String graduationYear;
	private String recommendGMU; 
	private String hearAboutGMU;
	private String likeAboutGMU;
	
	private String comments;
	private String dateOfSurvey;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGraduationMonth() {
		return graduationMonth;
	}
	public void setGraduationMonth(String graduationMonth) {
		this.graduationMonth = graduationMonth;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getRecommendGMU() {
		return recommendGMU;
	}
	public void setRecommendGMU(String recommendGMU) {
		this.recommendGMU = recommendGMU;
	}
	public String getHearAboutGMU() {
		return hearAboutGMU;
	}
	public void setHearAboutGMU(String hearAboutGMU) {
		this.hearAboutGMU = hearAboutGMU;
	}
	public String getLikeAboutGMU() {
		return likeAboutGMU;
	}
	public void setLikeAboutGMU(String likeAboutGMU) {
		this.likeAboutGMU = likeAboutGMU;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDateOfSurvey() {
		return dateOfSurvey;
	}
	public void setDateOfSurvey(String dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}
	
}
