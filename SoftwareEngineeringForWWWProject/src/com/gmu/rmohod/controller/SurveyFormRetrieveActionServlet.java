package com.gmu.rmohod.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.gmu.rmohod.bean.StudentBean;
import com.gmu.rmohod.databasemodel.StudentDAO;

/**
 * This class is Action class to retrieve form data from database
 * 
 * @author Rasika
 *
 */

public class SurveyFormRetrieveActionServlet implements SessionAware{

	/*
	 * Get the selected Student Id
	 */
	private String studentId;

	//Getters and Setters
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	//Code to create  Http Session
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String execute()
	{
		System.out.println("Into ActionServlet SurveyFormRetrieve.");
		System.out.println("studentId"+studentId);

		/*
		 * Code to retrieve student survey form of selected student
		 * 
		 */
		StudentDAO studentdbObject = new StudentDAO();
		StudentBean studentBeanObject = new StudentBean();
		studentBeanObject = studentdbObject.retrieveStudentSurveyForm(studentId);

		/*
		 * Code to create session object and 
		 * store StudentBeanObject in session object
		 */
		sessionMap.put("studentBeanObject", studentBeanObject);


		/*
		 * Code to redirect user to correct page
		 * 
		 */
		if (studentBeanObject != null)
		{
			return "Student";
		}
		else
		{
			return "NoSuchStudent";
		}
	}
}
