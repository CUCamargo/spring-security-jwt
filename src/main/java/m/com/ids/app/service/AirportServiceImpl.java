package m.com.ids.app.service;

import m.com.ids.app.exception.ResourceNotFoundException;
import m.com.ids.app.model.Airport;
import m.com.ids.app.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService{
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport country) {
        Optional<Airport> productDb = this.airportRepository.findById(country.getId());

        if (productDb.isPresent()) {
            Airport airportUpdate = productDb.get();
            airportUpdate.setId(country.getId());
            airportUpdate.setName(country.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + country.getId());
        }
    }

    @Override
    public List<Airport> getAllAirport() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getById(long productId) {

        Optional<Airport> productDb = this.airportRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteAirport(long productId) {
        Optional<Airport> productDb = this.airportRepository.findById(productId);

        if (productDb.isPresent()) {
            this.airportRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }
}
