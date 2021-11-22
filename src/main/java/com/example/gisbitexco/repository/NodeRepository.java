package com.example.gisbitexco.repository;

import com.example.gisbitexco.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * NodeRepository
 */
@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {
}
