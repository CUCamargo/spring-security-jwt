package m.com.ids.app.controller;

import m.com.ids.app.exception.Mensaje;
import m.com.ids.app.model.Language;
import m.com.ids.app.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class LanguageController {
    @Autowired
    private LanguageService productService; //Contiene los metodos del CRUD que va a poder utilizar nuestra apliacion

    @GetMapping("/listalenguajes")
    public ResponseEntity<?> getAllEmployee() {
        List<Language> lista = productService.getAllLanguage();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin lenguajes en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(productService.getAllLanguage());
    }

    @GetMapping("/detallelenguajes/{id}")
    public ResponseEntity<Language> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @PostMapping("/añadirlenguajes")
    public ResponseEntity<Language> createProduct(@RequestBody Language employee) {
        return ResponseEntity.ok().body(this.productService.createLanguage(employee));
    }

    @PutMapping("/actualizalenguajes/{id}")
    public ResponseEntity<Language> updateProduct(@PathVariable long id, @RequestBody Language employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(this.productService.updateLanguage(employee));
    }

    @DeleteMapping("/eliminalenguajes/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteLanguage(id);
        return HttpStatus.OK;
    }
}
