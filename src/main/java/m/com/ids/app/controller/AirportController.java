package m.com.ids.app.controller;

import m.com.ids.app.exception.Mensaje;
import m.com.ids.app.model.Airport;
import m.com.ids.app.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class AirportController {
    @Autowired
    private AirportService airportService; //Contiene los metodos del CRUD que va a poder utilizar nuestra apliacion

    @GetMapping("/listaairport")
    public ResponseEntity<?> getAllAiport() {
        List<Airport> lista = airportService.getAllAirport();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin aeropuertos en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.getAllAirport());
    }

    @GetMapping("/detalleairport/{id}")
    public ResponseEntity<Airport> getAiportById(@PathVariable long id) {
        return ResponseEntity.ok().body(airportService.getById(id));
    }

    @PostMapping("/añadirairport")
    public ResponseEntity<Airport> createAiport(@RequestBody Airport employee) {
        return ResponseEntity.ok().body(this.airportService.createAirport(employee));
    }

    @PutMapping("/actualizaairport/{id}")
    public ResponseEntity<Airport> updateAiport(@PathVariable long id, @RequestBody Airport employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(this.airportService.updateAirport(employee));
    }

    @DeleteMapping("/eliminaairport/{id}")
    public HttpStatus deleteAiport(@PathVariable long id) {
        this.airportService.deleteAirport(id);
        return HttpStatus.OK;
    }
}
