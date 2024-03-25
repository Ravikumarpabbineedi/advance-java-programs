package jdbcApp2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	public int save(Employee emp) {
		//Declare the resources
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		
		try { 
			//get the connection
			connection=DBConnection.creatConnection();
			//create the preparedstatement object
			preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			//read the data from emp object and set to parameter
			preparedStatement.setInt(1,emp.getEmpId());
			preparedStatement.setString(2,emp.getEmpName());
			preparedStatement.setDouble(3,emp.getEmpSalary());
			count=preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(connection!=null)
				connection.close();
			if(preparedStatement!=null)
				preparedStatement.close();}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public Employee findById(int empId) {
		Employee employee=null;
		try(Connection connection=DBConnection.creatConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where empId=?");
			)
		{
			preparedStatement.setInt(1,empId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
			}
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return employee;
	}
	public int update(String empName) {
		int count=0;
		try( Connection connection=DBConnection.creatConnection();
			 PreparedStatement preparedStatement=connection.prepareStatement("update emp set empSalary=empSalary+5000 where empName=?");
			){
				preparedStatement.setString(1,empName);
				count=preparedStatement.executeUpdate();		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int deleteById(int empId) {
		int count=0;
		try(Connection connection=DBConnection.creatConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete emp where empId=?");
			){
			preparedStatement.setInt(1,empId);
			count=preparedStatement.executeUpdate();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return count;
	}
	public int deleteBySalary(double empSalary) {
		int count=0;
		try(Connection connection=DBConnection.creatConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete emp where empSalary>=?");
			){
			preparedStatement.setDouble(1,empSalary);
			count=preparedStatement.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return count;
	}
	
	public List<Employee> findAll(){
		List<Employee> emps=new ArrayList<>();
		try(Connection connection=DBConnection.creatConnection();
			Statement statement=connection.createStatement();
			)
		{
			ResultSet resultSet=statement.executeQuery("select * from emp");
			
			while(resultSet.next()) {
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				emps.add(employee);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}
	public int updateSalary(double cuurenrSlary,double incSalary) {
		int count=0;
		try( Connection connection=DBConnection.creatConnection();
			 PreparedStatement preparedStatement=connection.prepareStatement("update emp set empSalary=empSalary+? where empSalary>?");
			){
				preparedStatement.setDouble(1,incSalary);
				preparedStatement.setDouble(2,cuurenrSlary);
				count=preparedStatement.executeUpdate();		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
