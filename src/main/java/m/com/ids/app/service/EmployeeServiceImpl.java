package m.com.ids.app.service;

import java.util.List;
import java.util.Optional;

import m.com.ids.app.exception.ResourceNotFoundException;
import m.com.ids.app.model.Employee;
import m.com.ids.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Notación para indicar que es un servicio
@Transactional //define que un conjunto de instrucciones que se ejecutan en bloque asegura y valida el metodo termine correctamente antes de ejecutar algun otro metodo
public class EmployeeServiceImpl implements EmployeeService {

	//Inyección de dependecias (crea una instancia cuando lo requiera)
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> productDb = this.employeeRepository.findById(employee.getId());

		if (productDb.isPresent()) {
			Employee employeeUpdate = productDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setSurname(employee.getSurname());
			employeeUpdate.setFirstname(employee.getFirstname());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getById(long productId) {

		Optional<Employee> productDb = this.employeeRepository.findById(productId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}
	}

	@Override
	public void deleteEmployee(long productId) {
		Optional<Employee> productDb = this.employeeRepository.findById(productId);

		if (productDb.isPresent()) {
			this.employeeRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}

	}
}
