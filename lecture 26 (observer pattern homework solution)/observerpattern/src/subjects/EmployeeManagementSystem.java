package subjects;

import java.util.ArrayList;
import java.util.List;

import observers.IObserver;
import domain.Employee;
import domain.EmployeeDAO;

/**
 * This is the subject that should be able to notify the list of observers that
 * care for employee changes.
 * 
 * @author Screencasts
 * 
 */
public class EmployeeManagementSystem implements ISubject<Employee> {

	private List<IObserver> observers;
	private List<Employee> employees;
	private EmployeeDAO employeeDAO;

	public EmployeeManagementSystem() {
		observers = new ArrayList<>();
		employeeDAO = new EmployeeDAO();
		employees = employeeDAO.generateEmployees();
	}

	public void modifyEmployeeName(int id, String newName) {
	    for (Employee employee : employees) {
	        if (employee.employeeID == id) {
	            employee.setName(newName);
                notifyObservers(employee, "Employee Name Changed");
            }
        }
	}

	public void hireNewEmployee(Employee emp) {
		notifyObservers(emp, "New Hire");
	}
	
	@Override
	public void registerObserver(IObserver addMe) {
		// the observers added to this list are interested in getting notified.
		observers.add(addMe);
	}

	@Override
	public void removeObserver(IObserver removeMe) {
		observers.remove(removeMe);
	}

    @Override
    public void notifyObservers(Employee employee, String message) {
        for (IObserver department : observers) {
            department.callMe(employee, message);
        }
    }
}
