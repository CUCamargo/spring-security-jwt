package m.com.ids.app.controller;

import m.com.ids.app.exception.Mensaje;
import m.com.ids.app.model.Country;
import m.com.ids.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class CountyController {
    @Autowired
    private CountryService productService; //Contiene los metodos del CRUD que va a poder utilizar nuestra apliacion

    @GetMapping("/listapaises")
    public ResponseEntity<?> getAllCountry() {
        List<Country> lista = productService.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin paises en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(productService.getAllCountry());
    }

    @GetMapping("/detallepais/{id}")
    public ResponseEntity<Country> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @PostMapping("/añadirpais")
    public ResponseEntity<Country> createProduct(@RequestBody Country employee) {
        return ResponseEntity.ok().body(this.productService.createCountry(employee));
    }

    @PutMapping("/actualizapais/{id}")
    public ResponseEntity<Country> updateProduct(@PathVariable long id, @RequestBody Country employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(this.productService.updateCountry(employee));
    }

    @DeleteMapping("/eliminapais/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
