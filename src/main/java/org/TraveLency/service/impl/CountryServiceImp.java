package org.TraveLency.service.impl;

import org.TraveLency.exceptions.MainException;
import org.TraveLency.model.Country;
import org.TraveLency.repository.CountryRepository;
import org.TraveLency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.TraveLency.constants.ErrorConstants.COUNTRY_BY_SUCH_ID_IS_NOT_FOUND;
@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> allCountry() {
        return countryRepository.findAll();
    }

    @Override
    public Country add(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public Country edit(Country country) {
        countryRepository.save(country);
        return country;
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new MainException(COUNTRY_BY_SUCH_ID_IS_NOT_FOUND, 404L));
    }

    @Override
    public Country getByCountryName(String name) {
        return countryRepository.findByName(name);
    }
}
