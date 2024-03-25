package jdbcApp2;

import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDao();
		/*int res1=employeeDao.save(new Employee(1001,"Ravi",12500));
		System.out.println("Data Inserted successfully..."+res1);
		
		int res2=employeeDao.save(new Employee(1002,"suchetan",55000));
		System.out.println("Data Inserted Successfully..."+res2);
		
		int res3=employeeDao.save(new Employee(1003,"Rakesh",58000));
		System.out.println("Data Inserted Successfully..."+res3);*/
		
	/*	Employee emp=employeeDao.findById(1001);
		Employee emp1=employeeDao.findById(1002);
		System.out.println(emp);
		System.out.println(emp1);*/
		
		/*int result=employeeDao.update("Ravi");
		System.out.println(result);*/
		
		/*int result1=employeeDao.deleteById(1003);
			System.out.println("Record deleted Successfully..."+result1);*/
		
		/*int deleteCount=employeeDao.deleteBySalary(2500.44);
			System.out.println("deleted"+deleteCount);*/
		
		List<Employee> e=employeeDao.findAll();
			e.forEach(p->System.out.println(p));
		
		/*int updatedRows=employeeDao.updateSalary(25000,15000);
			System.out.println("salary incremented for "+updatedRows+" members");*/
	}
}
