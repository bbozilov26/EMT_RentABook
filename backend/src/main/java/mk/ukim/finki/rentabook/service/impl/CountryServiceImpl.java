package mk.ukim.finki.rentabook.service.impl;

import mk.ukim.finki.rentabook.exceptions.CountryDoesNotExistException;
import mk.ukim.finki.rentabook.models.dto.CountryDTO;
import mk.ukim.finki.rentabook.models.metamodels.Country;
import mk.ukim.finki.rentabook.repository.CountryRepository;
import mk.ukim.finki.rentabook.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long country) {
        return countryRepository.findById(country).orElseThrow(CountryDoesNotExistException::new);
    }

    @Override
    public Country addCountry(CountryDTO country) {
        Country newCountry = new Country();
        newCountry.setName(country.getName());

        return countryRepository.save(newCountry);
    }

    @Override
    public Country editCountry(Long id, CountryDTO country) {
        Country newCountry = countryRepository.findById(id).orElseThrow(CountryDoesNotExistException::new);
        newCountry.setName(country.getName());

        return countryRepository.save(newCountry);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
