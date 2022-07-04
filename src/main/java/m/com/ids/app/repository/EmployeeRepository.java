package m.com.ids.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m.com.ids.app.model.Employee;

//Notación para indicar que es un repositorio
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}