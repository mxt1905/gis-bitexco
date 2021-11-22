package com.example.gisbitexco.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Face
 */
@Entity
@Getter
@Setter
public class Face {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer faceId;

    private String faceType;

    private String faceSymbolRenderer;

    private Integer faceData;

    private String faceInFile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "face_node",
        joinColumns = @JoinColumn(name = "face_id"),
        inverseJoinColumns = @JoinColumn(name = "node_id")
    )
    private Set<Node> nodes = new HashSet<>();
}
