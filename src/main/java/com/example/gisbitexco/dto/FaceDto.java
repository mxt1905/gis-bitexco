package com.example.gisbitexco.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * FaceDto
 */
@Getter
@Setter
public class FaceDto {

    private Integer faceId;
    private String faceType;
    private String faceSymbolRenderer;
    private Integer faceData;
    private String faceInFile;
    private Set<NodeDto> nodes = new HashSet<>();
}
