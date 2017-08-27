package com.gmu.rmohod.databasemodel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gmu.rmohod.bean.StudentBean;

/**
 * Model class to perform database operations on Student database
 * 
 * @author Rasika
 *
 */
public class StudentDAO {
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private Connection con = null;
	private Statement statement = null;
	
	/**
	 * Method to save survey form data submitted by student
	 * 
	 * @param studentId
	 * @param name
	 * @param email
	 * @param telephoneNumber
	 * @param streetAddress
	 * @param zipcode
	 * @param city
	 * @param state
	 * @param graduationMonth
	 * @param graduationYear
	 * @param recommendGMU
	 * @param hearAboutGMU
	 * @param likeAboutGMU
	 * @param comments
	 * @param dateOfSurvey
	 * @param data
	 */
	public void saveStudentSurveyForm(String studentId,String name, String email, String telephoneNumber, String streetAddress,
			String zipcode, String city, String state, String graduationMonth, String graduationYear, String recommendGMU, 
			String hearAboutGMU,String likeAboutGMU, String comments, String dateOfSurvey, String data)
	{
		System.out.println("Into saveStudentSurveyForm.");
		try{
			con = dbConnection.getDBConnetion();
			
			// build insert query string
			String insertTableSQL = "INSERT INTO STUDENTINFO"
					+ "(STUDENTID, NAME, EMAIL, TELEPHONENUMBER, STREETADDRESS,"
					+ "ZIPCODE, CITY, STATE, GRADUATIONMONTH, GRADUATIONYEAR,"
					+ "RECOMMENDGMU, HEARABOUTGMU, LIKEABOUTGMU, COMMENTS, DATEOFSURVEY, DATA)"
					+ "VALUES"
					+ "('"+studentId+"','"+name+"','"+email+"','"+telephoneNumber+"','"+streetAddress+"','"+zipcode+"',"
					+ "'"+city+"','"+state+"','"+graduationMonth+"','"+graduationYear+"','"+recommendGMU+"','"+hearAboutGMU+"',"
					+ "'"+likeAboutGMU+"','"+comments+"','"+dateOfSurvey+"','"+data+"')";
			
			statement = con.createStatement();
			
			// execute insert SQL statement
			statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into DBUSER table!");
			
			// close the connection
			con.close();
		}
		catch(Exception e){
			//
		}
	}
	
	/**
	 * Method to retrieve the survey form data of a specific student
	 * 
	 * @param studentId
	 * @return StudentBean object which has complete student survey form data
	 */
	public StudentBean retrieveStudentSurveyForm(String studentId)
	{
		System.out.println("Into retrieveStudentSurveyForm.");
		try{
			con = dbConnection.getDBConnetion();
			
			//build retrieve query string
			String SelectTableSQL = "SELECT * FROM STUDENTINFO WHERE STUDENTID = '"+studentId+"'";
			  
			statement = con.createStatement();  

			// execute select SQL statement  
			ResultSet rs=statement.executeQuery(SelectTableSQL);
			
			//store the retrieved result in StudentBean Object
			StudentBean studentbean = new StudentBean();
			while(rs.next()) {
				studentbean.setStudentId(rs.getString(1));
				studentbean.setName(rs.getString(2));
				studentbean.setEmail(rs.getString(3));
				studentbean.setTelephoneNumber(rs.getString(4));
				
				studentbean.setStreetAddress(rs.getString(5));
				studentbean.setZipcode(rs.getString(6));
				studentbean.setCity(rs.getString(7));
				studentbean.setState(rs.getString(8));
				
				studentbean.setGraduationMonth(rs.getString(9));
				studentbean.setGraduationYear(rs.getString(10));
				studentbean.setRecommendGMU(rs.getString(11));
				studentbean.setHearAboutGMU(rs.getString(12));
				studentbean.setLikeAboutGMU(rs.getString(13));
				
				studentbean.setComments(rs.getString(14));
				studentbean.setDateOfSurvey(rs.getString(15));
				
				studentbean.setData(rs.getString(16));
			}
			
			// close the connection
			con.close();
			
			return studentbean;
		}
		catch(Exception e){
			//
		}
		return null;
	}

	/**
	 * Method to get all the student IDs saved in database
	 * 
	 * @return ArrayList which contains all the student IDs available in database
	 */
	public ArrayList<String> getAllStudentIds()
	{
		ArrayList<String> studentsIds =  new ArrayList<String>();
		int i=0;
		
		System.out.println("Into getAllStudentIds.");
		try{
			con = dbConnection.getDBConnetion();
			
			//build retrieve query string
			String SelectTableSQL = "SELECT STUDENTID FROM STUDENTINFO";
			  
			statement = con.createStatement();  

			// execute select SQL statement  
			ResultSet rs=statement.executeQuery(SelectTableSQL);
			
			System.out.println("Student ids retrieved are:");
			
			//store the retrieved student Ids
			while(rs.next()) {
				studentsIds.add(rs.getString(1));
				System.out.println(studentsIds.get(i));
				i++;
			}  
			
			// close the connection
			con.close();
			
			return studentsIds;
		}
		catch(Exception e){
			//
		}
		return studentsIds;
	}
}
