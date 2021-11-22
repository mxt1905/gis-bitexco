package com.example.gisbitexco.repository;

import com.example.gisbitexco.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FieldRepository
 */
@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {
}
