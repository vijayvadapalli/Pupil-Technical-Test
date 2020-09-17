package com.pupil.technicaltest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


/**
 *  All details related to a shape. Model is not normalised, so as to use it directly in nosql databases like mongo,
 *  as this model seems to fit to use in it.
 */
@ApiModel(description="All details about the a Geometry.")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="entityType",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="ABSTRACT-SHAPE")
@Entity
public class Shape {

    @Id
    @GeneratedValue
    @Column(name="shape_Id")
    private long id;

    private ShapeTypeEnum type;

    @Size(min=4, message="Type should have atleast 4 characters")
    @ApiModelProperty(notes="Type should have atleast 4 characters")
    @Column(unique = true)
    private String name;

    @Size(min=5, message="Type should have atleast 5 characters")
    @ApiModelProperty(notes="Type should have atleast 5 characters")
    private String geometryDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShapeTypeEnum getType() {
        return type;
    }

    public void setType(ShapeTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeometryDescription() {
        return geometryDescription;
    }

    public void setGeometryDescription(String geometryDescription) {
        this.geometryDescription = geometryDescription;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", type='" + type.getShapeType() + '\'' +
                ", name='" + name + '\'' +
                ", geometryDescription='" + geometryDescription + '\'' +
                '}';
    }
}
