package mk.ukim.finki.rentabook.service;

import mk.ukim.finki.rentabook.models.dto.CountryDTO;
import mk.ukim.finki.rentabook.models.metamodels.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAllCountries();

    Optional<Country> getCountryById(Long country);

    Optional<Country> addCountry(CountryDTO countryDTO);

    Optional<Country> editCountry(Long id, CountryDTO countryDTO);

    void deleteCountry(Long id);
}
