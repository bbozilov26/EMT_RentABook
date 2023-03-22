package mk.ukim.finki.rentabook.web;

import mk.ukim.finki.rentabook.models.dto.CountryDTO;
import mk.ukim.finki.rentabook.models.metamodels.Country;
import mk.ukim.finki.rentabook.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getAll")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.addCountry(countryDTO)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        return countryService.editCountry(id, countryDTO)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(author -> {
                    countryService.deleteCountry(id);
                    return ResponseEntity.ok().body(author);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
