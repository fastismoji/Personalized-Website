package com.gmu.rmohod.controller;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.gmu.rmohod.bean.DataBean;
import com.gmu.rmohod.databasemodel.StudentDAO;

/**
 * This class is ACtion class to store form data into database
 * 
 * @author Rasika
 *
 */

public class SurveyFormStoreActionServlet implements SessionAware{

	// Code to declare all the fields of survey form
	private String studentName;
	private String telephoneNumber;

	private String data;
	private String studentId;

	private String streetAddress;
	private String zip;
	private String city;
	private String state;

	private String graduationMonth;
	private String graduationYear;
	private String datalist;

	private String checkbox[];
	private String radioButton;

	private String comments;
	private String surveyDate;

	//Getters and Setters are all form fields
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private String studentEmail;
	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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

	public String getDatalist() {
		return datalist;
	}

	public void setDatalist(String datalist) {
		this.datalist = datalist;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(String radioButton) {
		this.radioButton = radioButton;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}


	//Code to create  Http Session
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	
	public String execute() {

		//Code to manage fields which are not required (not compulsory to be provided)
		if ("".equals(data)){
			data = "Not provided";
		}
		if ("".equals(streetAddress)){
			streetAddress = "Not provided";
		}
		if ("".equals(zip)){
			zip = "Not provided";
		}
		if ("".equals(city)){
			city = "Not provided";
		}
		if ("".equals(state)){
			state = "Not provided";
		}
		if ("".equals(surveyDate)){
			surveyDate = "Not provided";
		}

		System.out.println("name:\t"+studentName);
		System.out.println("email:\t"+studentEmail);
		System.out.println("telephoneNumber:\t"+telephoneNumber);
		System.out.println("data:\t"+data);
		System.out.println("studentId:\t"+studentId);
		System.out.println("streetAddress:\t"+streetAddress);
		System.out.println("zip:\t"+zip);
		System.out.println("state:\t"+state);
		System.out.println("city:\t"+city);
		System.out.println("graduationMonth:\t"+graduationMonth);
		System.out.println("graduationYear:\t"+graduationYear);
		System.out.println("datalist:\t"+datalist);
		//System.out.println("checkboxValues:\t"+checkboxValues[0]+","+checkboxValues[1]);
		System.out.println("radioButton:\t"+radioButton);
		System.out.println("comments:\t"+comments);
		System.out.println("surveyDate:\t"+surveyDate);

		/*
		 * Code to convert multiple checkbox 
		 * values into one string
		 * 
		 */
		String checkboxes = ""; 
		for(int i=0;i<checkbox.length;i++)
		{
			checkboxes+=checkbox[i];
			if((i+1)<checkbox.length)
			{
				checkboxes+=",";
			}
		}
		System.out.println("checkboxesselected:\t"+checkboxes);


		/*
		 * Code to save the student survey form 
		 * into database
		 * 
		 */
		StudentDAO studentdbObject = new StudentDAO();
		studentdbObject.saveStudentSurveyForm(studentId, studentName, studentEmail, telephoneNumber, 
				streetAddress, zip, city, state, graduationMonth, graduationYear, datalist,
				radioButton, checkboxes, comments, surveyDate, data);


		/*
		 * Code to convert input data into integer form
		 * and call method to compute mean and deviation 
		 * 
		 */
		if ("".equals(data)){
			data = "0";
		}
		String[] strData = data.split(",");
		int[] intData = new int[strData.length];
		for(int i = 0; i < strData.length; i++) {
			intData[i] = Integer.parseInt(strData[i]);
		}

		DataProcessor dataProcessorObject = new DataProcessor();
		DataBean dataBeanObject = new DataBean();
		dataBeanObject = dataProcessorObject.computeMeanDeviation(intData);


		/*
		 * Code to set session object and 
		 * store dataBeanObject in session object
		 */
		sessionMap.put("dataBeanObject", dataBeanObject); 


		/*
		 * Code to redirect user to correct page
		 * 
		 */
		if (dataBeanObject.getMean() >= 90)
		{
			return "WinnerAcknowledgement";
		}
		else
		{
			return "SimpleAcknowledgement";
		}
	}
}
