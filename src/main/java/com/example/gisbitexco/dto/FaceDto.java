package com.example.gisbitexco.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private List<NodeDto> nodes = new ArrayList<>();
}
