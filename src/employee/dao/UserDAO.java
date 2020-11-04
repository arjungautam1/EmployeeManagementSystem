package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import employee.model.Employee;

//This class is used for CRUD database operations for the table users in the database. 
public class UserDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/employee?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "(name,email,country) VALUES "
            + "(?,?,?);";
    private static final String SELECT_ALL_EMPLOYEE = "SELELT * FROM employee";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE id=?;";
    private static final String UPDATE_EMPLOYEES_SQL = "UPDATE employee set name=?, email=? , country =? where id=?;";

    // Common method for jdbc connection
    protected Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    // Insert Employee
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Update Employee
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;

    }
}
