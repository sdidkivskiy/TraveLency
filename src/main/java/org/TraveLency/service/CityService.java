package org.TraveLency.service;

import org.TraveLency.model.City;

import java.util.List;

public interface CityService {

    List<City> allCity();

    City add(City city);

    void delete(City city);

    City edit(City city);

    City getById(Long id);

    City getByCityName(String city);

}
