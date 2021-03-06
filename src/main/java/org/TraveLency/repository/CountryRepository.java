package org.TraveLency.repository;

import org.TraveLency.model.Country;
import org.TraveLency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName (String name);
}
