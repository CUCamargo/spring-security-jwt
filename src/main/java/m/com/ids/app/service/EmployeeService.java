package m.com.ids.app.service;

import java.util.List;

import m.com.ids.app.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	List<Employee> getAllEmployee();

	Employee getById(long productId);

	void deleteEmployee(long id);
}
