package com.example.gisbitexco.service.impl;

import com.example.gisbitexco.dto.NodeDto;
import com.example.gisbitexco.mapper.NodeMapper;
import com.example.gisbitexco.repository.NodeRepository;
import com.example.gisbitexco.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NodeServiceImpl
 */
@Service
@RequiredArgsConstructor
public class NodeServiceImpl implements NodeService {

    private final NodeRepository nodeRepository;
    private final NodeMapper nodeMapper;

    @Override
    public List<NodeDto> searchNodes() {
        return nodeMapper.toDtoList(nodeRepository.findAll());
    }
}
