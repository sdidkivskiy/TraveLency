package org.TraveLency.service;


import org.TraveLency.model.Country;
import java.util.List;

public interface CountryService {


    List<Country> allCountry();

    Country add(Country country);

    void delete(Country country);

    Country edit(Country country);

    Country getById(Long id);
}
