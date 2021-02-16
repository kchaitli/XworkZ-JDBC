//package com.xworkz.matrimony;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.xworkz.matrimony.dto.BrideDTO;
//
//public class GetBrideApplication {
//	public static void main(String[] args) {
//		
////		try {
////			//load and Register Driver
////			//Class.forName("com.mysql.jdbc.Driver");
////			System.out.println("driver loaded successfully");
////		} catch (ClassNotFoundException e) {
////			e.printStackTrace();
////			
////		}//loading is done automatically by spi so we aren't doing it
//		// step2 establish connection use get connection method
//		Connection connection = null;
//		try {
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "3VC16ec@17");
//			System.out.println("connected with Data base");
//			// step3 Create Statement
//			Statement stmt=connection.createStatement();
//			//to send query
//			ResultSet resultSet=stmt.executeQuery("select * from Matrimony.bride where id=1");
//			//to move to next position use while to loop through multiple records
//			//creating bride obj
//			BrideDTO bride = new BrideDTO();
//			resultSet.next();
//			//if multiple records use while
//				//inside result set we use get int method to get certain id
//				bride.setId(resultSet.getInt(1));
//				bride.setName(resultSet.getString(2));
//				bride.setAge(resultSet.getInt(3));
//				bride.setHeight(resultSet.getDouble(4));
//				bride.setWeight(resultSet.getDouble(5));
//				bride.setQualification(resultSet.getNString(6));
//				bride.setExpectation(resultSet.getNString(7));
//				bride.setPhoneNumber(resultSet.getString(8));
//				bride.setSalary(resultSet.getDouble(9));
//				bride.setOccupation(resultSet.getString(10));
//				bride.setAddress(resultSet.getNString(11));
//			
//			//print bride
//			System.out.println(bride);
//		} catch (SQLException e) {
//			//how to use try with resource(Explore)
//			System.out.println("failed to connect to data base");
//			e.printStackTrace();
//			//we can use e.printStackTrace inorder to understand what exception we have
//		}
//		finally {
//			try {
//				connection.close();
//				System.out.println("connection closed");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//	}
//}
