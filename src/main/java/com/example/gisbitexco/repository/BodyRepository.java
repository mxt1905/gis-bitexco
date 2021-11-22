package com.example.gisbitexco.repository;

import com.example.gisbitexco.entity.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BodyRepository
 */
@Repository
public interface BodyRepository extends JpaRepository<Body, Integer> {
}
