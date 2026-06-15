package com.example.api.rest.cerveja.repository;

import com.example.api.rest.cerveja.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
