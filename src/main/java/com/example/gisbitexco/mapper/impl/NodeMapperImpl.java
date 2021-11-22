package com.example.gisbitexco.mapper.impl;

import com.example.gisbitexco.dto.NodeDto;
import com.example.gisbitexco.entity.Node;
import com.example.gisbitexco.mapper.NodeMapper;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * NodeMapperImpl
 */
@Component
public class NodeMapperImpl implements NodeMapper {

    @Override
    public NodeDto toDto(Node node) {
        if (Objects.isNull(node))
            return null;
        NodeDto response = new NodeDto();
        response.setNodeId(node.getNodeId())
            .setX(node.getX())
            .setY(node.getY())
            .setZ(node.getZ());
        return response;
    }

    @Override
    public List<NodeDto> toDtoList(List<Node> nodes) {
        if (Objects.isNull(nodes) || nodes.isEmpty())
            return Collections.emptyList();
        List<NodeDto> response = new ArrayList<>();
        nodes.forEach(node -> response.add(this.toDto(node)));
        return response;
    }

    @Override
    public Set<NodeDto> toDtoSet(Set<Node> nodes) {
        if (Objects.isNull(nodes) || nodes.isEmpty())
            return Collections.emptySet();
        Set<NodeDto> response = new HashSet<>();
        nodes.forEach(node -> response.add(this.toDto(node)));
        return response;
    }
}
