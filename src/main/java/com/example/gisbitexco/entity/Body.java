package com.example.gisbitexco.entity;

import com.example.gisbitexco.constants.TableConst.ColumnName;
import com.example.gisbitexco.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Body
 */
@Entity
@Table(name = TableName.BODY)
@Getter
@Setter
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bodyId;

    private String bodyName;

    private String bodyColor;

    private String bodyDesc;

    private float bodyHeight;

    private int bodyStorey;

    private String bodyAddress;

    @OneToOne
    @JoinColumn(name = ColumnName.FIELD_ID)
    private Field field;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TableName.BODY_FACE,
        joinColumns = @JoinColumn(name = ColumnName.BODY_ID),
        inverseJoinColumns = @JoinColumn(name = ColumnName.FACE_ID))
    private Set<Face> faces = new HashSet<>();
}
