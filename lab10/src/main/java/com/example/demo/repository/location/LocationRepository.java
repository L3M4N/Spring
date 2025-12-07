package com.example.demo.repository.location;

import com.example.demo.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {

    Page<Location> findByCountry(@Param("country") String country, Pageable pageable);

    Optional<Location> findByCity(@Param("city") String city);
}