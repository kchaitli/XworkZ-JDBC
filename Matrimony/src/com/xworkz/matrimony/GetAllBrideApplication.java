//package com.xworkz.matrimony;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.xworkz.matrimony.dto.BrideDTO;
//
//public class GetAllBrideApplication {
//
//	public static void main(String[] args) {
//		Connection connection =null;
//		//establishing connection
//		try {
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "3VC16ec@17");
//			System.out.println("connected with DB");
//			//step 3 create statement
//			Statement stmt=connection.createStatement();
//			//query
//			
//			List<BrideDTO> brides = new ArrayList<BrideDTO>();
//			ResultSet resultSet = stmt.executeQuery("select * from Matrimony.bride");
//			while(resultSet.next()) {
//				BrideDTO bride = new BrideDTO();
//				bride.setId(resultSet.getInt(1));
//				bride.setName(resultSet.getString(2));
//				bride.setAge(resultSet.getInt(3));
//				bride.setHeight(resultSet.getDouble(4));
//				bride.setWeight(resultSet.getDouble(5));
//				bride.setQualification(resultSet.getString(6));
//				bride.setExpectation(resultSet.getString(7));
//				bride.setPhoneNumber(resultSet.getString(8));
//				bride.setSalary(resultSet.getDouble(9));
//				bride.setOccupation(resultSet.getString(10));
//				bride.setAddress(resultSet.getString(11));
//				brides.add(bride);
//			}
//			brides.forEach(b->System.out.println(b));
//			
//		} catch (SQLException e) {
//			System.out.println("failed connection");
//			e.printStackTrace();
////		}
//	}
//
//}
