import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudOperations {
	
	String jdbcUrl = Credentials.getJdbcUrl(); 
	String jdbcUser = Credentials.getJdbcUser(); 
	String jdbcPassword = Credentials.getJdbcPassword(); 
	
	public List<User> getAllUsers(String tableName) throws SQLException {
	    List<User> userList = new ArrayList<User>();
	    Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	    PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName);
	    ResultSet resultSet = statement.executeQuery();
	    while (resultSet.next()) {
	        String userName = resultSet.getString("name");
	        int userId = resultSet.getInt("client_id");
	        User user = new User(userName, userId);
	        userList.add(user);
	    }
	    
	    resultSet.close();
	    statement.close();
	    connection.close();
	    return userList;
	}

 	
 	public User getUserById(String tableName, int id) throws SQLException { 
 		User user = new User("", id);
		Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword); 
		PreparedStatement  statement = connection.prepareStatement("SELECT * from " + tableName + " WHERE client_id=?"); 
		statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
        	String userName = resultSet.getString("name");
        	int userId = resultSet.getInt("client_id"); 
        	user.setName(userName);
        	user.setId(userId); 
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        
		return user;
 	}
 	
 	
 	public void createUser(String tableName, User user) throws SQLException {
 	    Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
 	    PreparedStatement statement = connection.prepareStatement("INSERT INTO " + tableName + " (client_id, name) VALUES (?, ?)");
 	    
 	    statement.setInt(1, user.getId());
 	    statement.setString(2, user.getName());

 	    statement.executeUpdate();
 	    
 	    statement.close();
 	    connection.close();
 	}

 	
 	 public void deleteUserById(String tableName, int id) throws SQLException {
         Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
         PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE client_id = ?");
         statement.setInt(1, id);
         statement.executeUpdate();

         statement.close();
         connection.close();
     }
 	
 	public void updateUserById(String tableName, User user) throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        PreparedStatement statement = connection.prepareStatement("UPDATE " + tableName + " SET name = ? WHERE client_id = ?");
        statement.setString(1, user.getName());
        statement.setInt(2, user.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();
    }
}


