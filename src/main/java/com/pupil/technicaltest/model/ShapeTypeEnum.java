package com.pupil.technicaltest.model;

public enum ShapeTypeEnum {
    SQUARE("Square"),
    RECTANGLE("Rectangle"),
    CIRCLE("Circle");

    private String shapeType;

    private ShapeTypeEnum(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getShapeType() {
        return shapeType;
    }
}
