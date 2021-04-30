package employee.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import employee.model.Employee;

//This class is used for CRUD database operations for the table users in the database. 
public class EmployeeDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/emp_management_sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "(name,email,country,role) VALUES "
            + "(?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id ,name,email,country,role FROM employee WHERE id=?";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE id=?;";
    private static final String UPDATE_EMPLOYEES_SQL = "UPDATE employee set name=?, email=? , country =?,role=? where id=?;";
   
    
    public EmployeeDAO() {
    	
    }
    // Common method for jdbc connection
    protected Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
    	System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());
            preparedStatement.setString(4, employee.getRole());
            
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Select Employee
    public Employee selectEmployee(int id) {
        Employee employee = null;

        //Establishing connection
        try (Connection connection = getConnection();

             //Create statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            //Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String role=rs.getString("role");
                employee = new Employee(id, name, email, country,role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    //Select all employees
    public List<Employee> selectAllEmployees() {
    	
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String role=rs.getString("role");
                employees.add(new Employee(id, name, email, country,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    //Delete employees
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
        ) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    //Update Employee
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());
            preparedStatement.setString(4, employee.getRole());
            preparedStatement.setInt(5, employee.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;

        }
        return rowUpdated;

    }
}
