package org.TraveLency.repository;

import org.TraveLency.model.City;
import org.TraveLency.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);
}
