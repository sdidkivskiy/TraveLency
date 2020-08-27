package org.TraveLency.service.impl;

import org.TraveLency.exceptions.MainException;
import org.TraveLency.model.City;
import org.TraveLency.repository.CityRepository;
import org.TraveLency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static org.TraveLency.constants.ErrorConstants.CITY_BY_SUCH_ID_IS_NOT_FOUND;
@Service
public class CityServiceImp implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    @Override
    public List<City> allCity() {
        return cityRepository.findAll();
    }

    @Transactional
    @Override
    public City add(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Transactional
    @Override
    public City edit(City city) {
        cityRepository.save(city);
        return city;
    }

    @Transactional
    @Override
    public City getById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new MainException(CITY_BY_SUCH_ID_IS_NOT_FOUND, 404L));
    }

    @Override
    public City getByCityName(String name) {
        return cityRepository.findByName(name);
    }
}
