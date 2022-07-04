package m.com.ids.app.controller;

import m.com.ids.app.exception.Mensaje;
import m.com.ids.app.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class CountyController {
    @Autowired
    private CountyController countyController; //Contiene los metodos del CRUD que va a poder utilizar nuestra apliacion

    @GetMapping("/listapaises")
    public ResponseEntity<?> getAllCountry() {
        List<Country> lista = countyController.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countyController.getAllCountry());
    }

    @GetMapping("/detallepais/{id}")
    public ResponseEntity<Country> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(countyController.getById(id));
    }

    @PostMapping("/añadirpais")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok().body(this.countyController.createCountry(country));
    }

    @PutMapping("/actualizapais/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country) {
        country.setId(id);
        return ResponseEntity.ok().body(this.countyController.updateCountry(country));
    }

    @DeleteMapping("/eliminapais/{id}")
    public HttpStatus deleteCountry(@PathVariable long id) {
        this.countyController.deleteCountry(id);
        return HttpStatus.OK;
    }
}
