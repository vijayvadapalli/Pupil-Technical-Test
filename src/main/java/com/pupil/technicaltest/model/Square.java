package com.pupil.technicaltest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@ApiModel(description="All details about the a Square.")
@DiscriminatorColumn(name="entityType",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="SQUARE")
@Entity
public class Square extends Shape{

    @Column(name="xCoordinate")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal xCoordinate;

    @Digits(integer = 10, fraction = 2)
    @Column(name="yCoordinate")
    private BigDecimal  yCoordinate;

    @Digits(integer = 10, fraction = 2)
    @Column(name="length")
    private BigDecimal  length;

    public BigDecimal getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(BigDecimal xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public BigDecimal getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(BigDecimal yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + "Square{" +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", length=" + length +
                '}';
    }
}
