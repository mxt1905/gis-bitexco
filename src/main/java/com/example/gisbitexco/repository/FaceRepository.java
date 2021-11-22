package com.example.gisbitexco.repository;

import com.example.gisbitexco.entity.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FaceRepository
 */
@Repository
public interface FaceRepository extends JpaRepository<Face, Integer> {
}
