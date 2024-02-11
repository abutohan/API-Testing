package com.restaurant.api.repositories;

import com.restaurant.api.entities.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppetizerRepository extends JpaRepository<Appetizer, Long> {
}
