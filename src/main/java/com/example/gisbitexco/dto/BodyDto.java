package com.example.gisbitexco.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * BodyDto
 */
@Getter
@Setter
public class BodyDto {

    private Integer bodyId;
    private String bodyName;
    private String bodyColor;
    private String bodyDesc;
    private Float bodyHeight;
    private Integer bodyStorey;
    private String bodyAddress;
    private FieldDto field;
    private List<FaceDto> faces;
}
