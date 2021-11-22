package com.example.gisbitexco.service;

import com.example.gisbitexco.dto.NodeDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NodeService
 */
@Service
public interface NodeService {

    public List<NodeDto> searchNodes();
}
