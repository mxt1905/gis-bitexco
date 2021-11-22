package com.example.gisbitexco.entity;

import com.example.gisbitexco.constants.TableConst.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Node
 */
@Entity
@Table(name = TableName.NODE)
@Getter
@Setter
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nodeId;

    private Double x;

    private Double y;

    private Double z;
}
