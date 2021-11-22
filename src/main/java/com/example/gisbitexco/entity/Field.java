package com.example.gisbitexco.entity;

import com.example.gisbitexco.constants.TableConst.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Field
 */
@Entity
@Table(name = TableName.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fieldId;

    private String fieldName;
}
