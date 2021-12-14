package com.example.gisbitexco.entity;

import com.example.gisbitexco.constants.TableConst.ColumnName;
import com.example.gisbitexco.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Face
 */
@Entity
@Table(name = TableName.FACE)
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
        name = TableName.FACE_NODE,
        joinColumns = @JoinColumn(name = ColumnName.FACE_ID),
        inverseJoinColumns = @JoinColumn(name = ColumnName.NODE_ID)
    )
    private List<Node> nodes = new ArrayList<>();
}
