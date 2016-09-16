package domain;

import java.util.Arrays;
import java.util.List;

public class EmployeeDAO {
	
	private Employee emp1 = new Employee("Mike", null, 5000, false);
	private Employee emp2 = new Employee("Steve", null, 4500, false);
	private Employee emp3 = new Employee("John", null, 7000, false);
	private Employee emp4 = new Employee("Pat", null, 6000, false);
	private Employee emp5 = new Employee("Joe", null, 8000, false);

	private List<Employee> employees;

	public List<Employee> generateEmployees(){
		
		employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
		
		return employees;
	}
	
	public void addEmployee(Employee emp){
		employees.add(emp);
	}
	
}
