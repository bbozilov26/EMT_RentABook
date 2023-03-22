package mk.ukim.finki.rentabook.service.impl;

import mk.ukim.finki.rentabook.exceptions.CountryDoesNotExistException;
import mk.ukim.finki.rentabook.models.dto.CountryDTO;
import mk.ukim.finki.rentabook.models.metamodels.Country;
import mk.ukim.finki.rentabook.repository.CountryRepository;
import mk.ukim.finki.rentabook.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Country> getCountryById(Long country) {
        return countryRepository.findById(country);
    }

    @Override
    public Optional<Country> addCountry(CountryDTO countryDTO) {
        Country newCountry = new Country();

        return Optional.of(saveCountry(countryDTO, newCountry));
    }

    @Override
    public Optional<Country> editCountry(Long id, CountryDTO countryDTO) {
        Country country = countryRepository.findById(id).orElseThrow(CountryDoesNotExistException::new);

        return Optional.of(saveCountry(countryDTO, country));
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    private Country saveCountry(CountryDTO countryDTO, Country country){
        country.setName(countryDTO.getName());
        country.setContinent(countryDTO.getContinent());

        return countryRepository.save(country);
    }
}
