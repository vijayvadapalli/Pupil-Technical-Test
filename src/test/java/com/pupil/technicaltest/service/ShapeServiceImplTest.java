package com.pupil.technicaltest.service;

import com.pupil.technicaltest.dao.ShapeRepository;
import com.pupil.technicaltest.model.Shape;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShapeServiceImplTest {

    @InjectMocks
    private ShapeServiceImpl shapeService;

    @Mock
    private ShapeRepository shapeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAllShape_test() {
        List<Shape> squares = getShapes();

        when(shapeRepository.findAll()).thenReturn(squares);
        List<Shape> shapesReturned = shapeService.retrieveAllShapes();
        assertEquals(3, shapesReturned.size());
        verify(shapeRepository, times(1)).findAll();
        assert (shapesReturned.get(0).getId() == 1);
        assert (shapesReturned.get(0).getType().equals(ShapeTypeEnum.SQUARE));
        assert (shapesReturned.get(0).getName().equals("Shape at 0.00 and 0.00"));
        assert (shapesReturned.get(0).getGeometryDescription().equals(""));
    }

    private List<Shape> getShapes() {
        List<Shape> square = new ArrayList<Shape>();
        square.add(setUpShapeData(1, ShapeTypeEnum.SQUARE, "Shape at 0.00 and 0.00", ""));
        square.add(setUpShapeData(2, ShapeTypeEnum.SQUARE, "Shape at 2.00 and 2.00", ""));
        square.add(setUpShapeData(3, ShapeTypeEnum.SQUARE, "Shape at 4.00 and 4.00", ""));

        return square;
    }

    private Shape setUpShapeData(long id, ShapeTypeEnum type, String name, String geometrydescription) {

        // given Shape
        Shape square = new Shape();
        square.setId(id);
        square.setType(type);
        square.setName(name);
        square.setGeometryDescription(geometrydescription);

        return square;
    }
}