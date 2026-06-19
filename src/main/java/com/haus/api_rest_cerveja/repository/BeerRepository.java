package com.haus.api_rest_cerveja.repository;

import com.haus.api_rest_cerveja.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
