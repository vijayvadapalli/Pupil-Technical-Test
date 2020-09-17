package com.pupil.technicaltest.util;

import com.pupil.technicaltest.model.ShapeTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ShapeConvertor implements AttributeConverter<ShapeTypeEnum, String> {
    @Override
    public String convertToDatabaseColumn(ShapeTypeEnum shapeType) {
        if (shapeType == null){
            return null;
        }

        return shapeType.getShapeType();
    }

    @Override
    public ShapeTypeEnum convertToEntityAttribute(String shapeType) {
        if (shapeType == null){
            return null;
        }

        return Stream.of(ShapeTypeEnum.values())
                .filter(c -> c.getShapeType().equals(shapeType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
