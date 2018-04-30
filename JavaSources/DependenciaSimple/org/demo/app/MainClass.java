package org.demo.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass{

	public static void main(String [] arguments){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demo_database", "root", "toorAPI");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from cliente");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("Cliente:" + resultSet.getInt("id"));
				System.out.println("\tNombre:"+ resultSet.getString("nombre"));
				System.out.println("\tEdad" + resultSet.getInt("edad"));
			}
			resultSet.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Something went wrong");
			ex.printStackTrace();
		}
	}

}
