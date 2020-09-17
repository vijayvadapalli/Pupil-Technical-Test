package com.pupil.technicaltest.service;

import com.pupil.technicaltest.dao.SquareRepository;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SquareServiceImplTest {

    @InjectMocks
    private SquareServiceImpl squareService;

    @Mock
    private SquareRepository squareRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAllSquare_test() {
        List<Square> squares = getSquares();

        when(squareRepository.findByType(ShapeTypeEnum.SQUARE)).thenReturn(squares);
        List<Square> shapesReturned = squareService.retrieveAllSquares();
        assertEquals(3, shapesReturned.size());
        verify(squareRepository, times(1)).findByType(ShapeTypeEnum.SQUARE);
        assert (shapesReturned.get(0).getId() == 1);
        assert (shapesReturned.get(0).getType().equals(ShapeTypeEnum.SQUARE));
        assert (shapesReturned.get(0).getName().equals("Square at 0.00 and 0.00"));
        assert (shapesReturned.get(0).getGeometryDescription().equals(""));
        assert (shapesReturned.get(0).getxCoordinate().equals(new BigDecimal(0.00)));
        assert (shapesReturned.get(0).getyCoordinate().equals(new BigDecimal(0.00)));
        assert (shapesReturned.get(0).getLength().equals(new BigDecimal(2.00)));
    }

    private List<Square> getSquares() {
        List<Square> square = new ArrayList<Square>();
        square.add(setUpSquareData(1, ShapeTypeEnum.SQUARE, "Square at 0.00 and 0.00", "", new BigDecimal(0.00), new BigDecimal(0.00), new BigDecimal(2.00)));
        square.add(setUpSquareData(2, ShapeTypeEnum.SQUARE, "Square at 2.00 and 2.00", "", new BigDecimal(2.00), new BigDecimal(2.00), new BigDecimal(2.00)));
        square.add(setUpSquareData(3, ShapeTypeEnum.SQUARE, "Square at 4.00 and 4.00", "", new BigDecimal(4.00), new BigDecimal(4.00), new BigDecimal(2.00)));

        return square;
    }

    private Square setUpSquareData(long id, ShapeTypeEnum type, String name, String geometrydescription,
                                 BigDecimal xCoordinates, BigDecimal yCoordinates, BigDecimal length) {

        // given Square
        Square square = new Square();
        square.setId(id);
        square.setType(type);
        square.setName(name);
        square.setGeometryDescription(geometrydescription);
        square.setxCoordinate(xCoordinates);
        square.setyCoordinate(yCoordinates);
        square.setLength(length);

        return square;
    }
}