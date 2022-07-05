package m.com.ids.app.controller;

import java.util.List;

import m.com.ids.app.exception.Mensaje;
import m.com.ids.app.model.Employee;
import m.com.ids.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Notación para indicar que es un controlador de tipo Rest y que puede interceptar peticiones al servidor.
@RequestMapping("/servicios")//Notación para mapear los endpoint (las urls de nueestra API) es decir /products/nombredelServicio
public class EmployeeController {

	//Inyección de dependencias
	@Autowired
	private EmployeeService productService; //Contiene los metodos del CRUD que va a poder utilizar nuestra apliacion

	@GetMapping("/listaempleados")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> lista = productService.getAllEmployee();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(productService.getAllEmployee());
	}

	@GetMapping("/detalleempleado/{id}")
	public ResponseEntity<Employee> getProductById(@PathVariable long id) {
		return ResponseEntity.ok().body(productService.getById(id));
	}

	@PostMapping("/añadirempleado")
	public ResponseEntity<Employee> createProduct(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.productService.createEmployee(employee));
	}

	@PutMapping("/actualizaempleado/{id}")
	public ResponseEntity<Employee> updateProduct(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.productService.updateEmployee(employee));
	}

	@DeleteMapping("/eliminaempleado/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		this.productService.deleteEmployee(id);
		return HttpStatus.OK;
	}
}