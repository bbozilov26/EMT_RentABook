package mk.ukim.finki.rentabook.service;

import mk.ukim.finki.rentabook.models.dto.CountryDTO;
import mk.ukim.finki.rentabook.models.metamodels.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    Country getCountryById(Long country);

    Country addCountry(CountryDTO country);

    Country editCountry(Long id, CountryDTO country);

    void deleteCountry(Long id);
}
