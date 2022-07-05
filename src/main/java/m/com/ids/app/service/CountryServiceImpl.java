package m.com.ids.app.service;

import m.com.ids.app.exception.ResourceNotFoundException;
import m.com.ids.app.model.Country;
import m.com.ids.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country employee) {
        return countryRepository.save(employee);
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> productDb = this.countryRepository.findById(country.getId());

        if (productDb.isPresent()) {
            Country countryUpdate = productDb.get();
            countryUpdate.setId(country.getId());
            countryUpdate.setCode(country.getCode());
            countryUpdate.setName(country.getName());
            countryRepository.save(countryUpdate);
            return countryUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + country.getId());
        }
    }

    @Override
    public List<Country> getAllCountry() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getById(long productId) {

        Optional<Country> productDb = this.countryRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteCountry(long productId) {
        Optional<Country> productDb = this.countryRepository.findById(productId);

        if (productDb.isPresent()) {
            this.countryRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }
}
