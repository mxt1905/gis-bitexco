package com.example.gisbitexco.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Body
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @JoinColumn(name = "field_id")
    private Field field;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "body_face",
        joinColumns = @JoinColumn(name = "body_id"),
        inverseJoinColumns = @JoinColumn(name = "face_id"))
    private Set<Face> faces = new HashSet<>();
}
