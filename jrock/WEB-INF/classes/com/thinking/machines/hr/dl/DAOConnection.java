package com.thinking.machines.hr.dl;
import java.sql.*;

public class DAOConnection
{
private DAOConnection(){};
public static Connection getConnection() throws DAOException
{
Connection connection=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tmdb","tmdbuser","tmdbuser");
return connection;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}


}