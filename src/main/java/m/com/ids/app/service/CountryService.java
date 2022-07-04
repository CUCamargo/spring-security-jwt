package m.com.ids.app.service;

import m.com.ids.app.model.Country;

import java.util.List;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getAllCountry();

    Country getById(long countryId);

    void deleteCountry(long id);
}
