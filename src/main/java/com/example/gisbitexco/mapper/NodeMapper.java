package com.example.gisbitexco.mapper;

import com.example.gisbitexco.dto.NodeDto;
import com.example.gisbitexco.entity.Node;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * NodeMapper
 */
@Component
public interface NodeMapper {

    NodeDto toDto(Node node);

    List<NodeDto> toDtoList(List<Node> nodes);

    Set<NodeDto> toDtoSet(Set<Node> nodes);

}
