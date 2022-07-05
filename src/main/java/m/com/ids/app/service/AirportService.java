package m.com.ids.app.service;

import m.com.ids.app.model.Airport;

import java.util.List;

public interface AirportService {
    Airport createAirport(Airport airport);
    Airport updateAirport(Airport airport);
    List<Airport> getAllAirport();

    Airport getById(long airportId);

    void deleteAirport(long id);
}
