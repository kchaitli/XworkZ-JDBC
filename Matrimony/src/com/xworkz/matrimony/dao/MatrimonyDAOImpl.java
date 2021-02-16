package com.xworkz.matrimony.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;
import static com.xworkz.matrimony.constants.Constants.*;

public class MatrimonyDAOImpl implements MatrimonyDAO {

	@Override
	public BrideDTO getById(int id) {
		BrideDTO bride = new BrideDTO();
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connected to db");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride where id=1;");
			resultSet.next();
			bride.setId(resultSet.getInt(1));
			bride.setName(resultSet.getString(2));
			bride.setAge(resultSet.getInt(3));
			bride.setHeight(resultSet.getDouble(4));
			bride.setWeight(resultSet.getDouble(5));
			bride.setQualification(resultSet.getString(6));
			bride.setExpectation(resultSet.getString(7));
			bride.setPhoneNumber(resultSet.getString(8));
			bride.setSalary(resultSet.getDouble(9));
			bride.setOccupation(resultSet.getString(10));
			bride.setAddress(resultSet.getString(11));

		} catch (SQLException e) {
			System.out.println("failed to connect");
			e.printStackTrace();
		}
		return bride;
	}

	@Override
	public int createBride(BrideDTO bride) {
		int result = 0;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			PreparedStatement stmt = connection
					.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, bride.getId());
			stmt.setString(2, bride.getName());
			stmt.setInt(3, bride.getAge());
			stmt.setDouble(4, bride.getHeight());
			stmt.setDouble(5, bride.getWeight());
			stmt.setString(6, bride.getQualification());
			stmt.setString(7, bride.getExpectation());
			stmt.setString(8, bride.getPhoneNumber());
			stmt.setDouble(9, bride.getSalary());
			stmt.setString(10, bride.getOccupation());
			stmt.setString(11, bride.getAddress());
			result = stmt.executeUpdate();// one time compilation many times update or execute

		} catch (SQLException e) {
			System.out.println("failed to connect to db");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public BrideDTO getAll() {
		BrideDTO bride = new BrideDTO();
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			System.out.println("Connected to Data Base");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from matrimony.bride");
			while (resultSet.next()) {
				bride.setId(resultSet.getInt(1));
				bride.setName(resultSet.getNString(2));
				bride.setAge(resultSet.getInt(3));
				bride.setHeight(resultSet.getDouble(4));
				bride.setWeight(resultSet.getDouble(5));
				bride.setQualification(resultSet.getString(6));
				bride.setExpectation(resultSet.getString(7));
				bride.setPhoneNumber(resultSet.getString(8));
				bride.setSalary(resultSet.getDouble(9));
				bride.setOccupation(resultSet.getString(10));
				System.out.println(bride);
			}
		} catch (SQLException e) {
			System.out.println("not connected to DB");
			e.printStackTrace();
		}
		return bride;
	}

	@Override
	public int updatePhoneNumById(String phoneNum, int id) {
		int result = 0;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			PreparedStatement stmt = connection
					.prepareStatement("update matrimony.bride set phone_number=(?) where id=(?)");
			stmt.setString(1, phoneNum);
			stmt.setInt(2, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("failed to connect DB");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteBrideById(int id) {
		int result = 0;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			PreparedStatement stmt = connection.prepareStatement("delete from matrimony.bride where id=(?)");
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("connection failed to db");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int[] insertBride(List<BrideDTO> brides) {
		int[] results = new int[brides.size()];
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			Statement stmt = con.createStatement();
			for (BrideDTO dto : brides) {
				//we will use string.format method
				String query = String.format(INSERT_QUERY, 
						dto.getId(),
						dto.getName(),
						dto.getAge(),
						dto.getHeight(),
						dto.getWeight(),
						dto.getQualification(),
						dto.getExpectation(),
						dto.getPhoneNumber(),
						dto.getSalary(),
						dto.getOccupation(),
						dto.getAddress());
				//single db call for multiple queries
				stmt.addBatch(query);
			}
			results=stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int[] insertBrideUsingPreparedstmt(List<BrideDTO> brides) {
		try (Connection con=DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)){
			PreparedStatement preparedStmt = con.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?)");
			//preparedStmt.setInt(parameterIndex, x);
			//prepared statement can contain multiple dml statements which are same it can't contain multiple different dml statements
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int[] updateBrides(List<BrideDTO> brides) {
		int[] results = new int[brides.size()];
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)){
			PreparedStatement pstmt= con.prepareStatement(UPDATE_QUERY);
			 for (BrideDTO dto : brides) {
				pstmt.setString(1, dto.getQualification());
				pstmt.setDouble(2, dto.getSalary());
				pstmt.setInt(3, dto.getId());
				
				//adding into batch
				pstmt.addBatch();
			}
			 results=pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int[] deleteBridesUsingPreparedstmt(List<Integer> ids) {
		int[] results =new int[ids.size()];
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)){
			PreparedStatement pstmt= con.prepareStatement(DELETE_QUERY);
			for (Integer id: ids) {
				pstmt.setInt(1, id);
				
				pstmt.addBatch();
			}
			results = pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
