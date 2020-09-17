package com.pupil.technicaltest.integration;

import com.pupil.technicaltest.dao.SquareRepository;
import com.pupil.technicaltest.exception.SquareInvalidException;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;
import com.pupil.technicaltest.validator.SquareValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SquareIntegrationTest {

    @Autowired
    private SquareRepository squareRepository;

    @Test
    public void whenValidSquareIsSaved_thenCorrectNumberOfSquaresAreRetured() {
        Square square = new Square();
        square.setName("Sample Square");
        square.setType(ShapeTypeEnum.SQUARE);
        square.setGeometryDescription("Sample Desc");
        square.setxCoordinate(new BigDecimal(10.0));
        square.setyCoordinate(new BigDecimal(10.0));
        square.setLength(new BigDecimal(2.0));
        squareRepository.save(square);

        List<Square> squares = squareRepository.findByType(ShapeTypeEnum.SQUARE);

        // 1 additional user is saved in the CommandLineRunner bean
        assertEquals(4, squares.size());
    }


    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square is added/validated at 0,0 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsExactlyOverLapped_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at 0.00 and 0.00'", "Square has equal sides(Only length) and is axis-aligned", 0.00, 0.00);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square is added/validated at 1.5,2 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsPartiallyOverLapped_OnXAxis_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at 1.50 and 2.00'", "Sample square with partial x-axis overlapping", 1.50, 2.00);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }


    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square is added/validated at 2,1.90 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsPartiallyOverLapped_OnYAxis_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at 2.00 and 1.90'", "Sample square with partial y-axis overlapping", 2.00, 1.90);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square of length 2.0 is added/validated at -1.90,-1.80 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsOverlappedOnBottomLeft_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at -1.80 and -1.90'", "Sample square with partial overlapping on bottom left", -1.90, -1.80);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square of length 2.0 is added/validated at -1.90,1.80 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsOverlappedOnTopLeft_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at -1.80 and 1.90'", "Sample square with partial overlapping on bottom left", -1.90, 1.80);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square of length 2.0 is added/validated at 1.90,-1.80 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsOverlappedOnTopRight_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at 1.80 and -1.90'", "Sample square with partial overlapping on bottom left", 1.90, -1.80);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square of length 2.0 is added/validated at 1.90,1.80 coordinates SquareInvalidException
     */
    @Test(expected = SquareInvalidException.class)
    public void whenSquareIsOverlappedOnBottomRight_thenInvalidSquareExceptionThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at 1.80 and 1.90'", "Sample square with partial overlapping on bottom left", 1.90, 1.80);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    /**
     * Given a square at 0,0 coordinates with length of 2
     * when another square of length 2.0 is added/validated at -2.00,-2.00 coordinates SquareInvalidException
     */
    @Test
    public void whenSquareIsAddedOnBottomLeft_thenNoInvalidSquareExceptionIsThrown() {

        List<Square> squares = (List<Square>) squareRepository.findAll();
        Square square = getSquare("Square at -2.00 and -2.00'", "Sample square on bottom left", -2.00, -2.00);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);

        square = getSquare("Square at -2.00 and 10.00'", "Sample square on bottom left", -2.00, 10.00);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);

        square = getSquare("Square at 10.00 and -2.00'", "Sample square on bottom left", 10.00, -2.00);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);

        square = getSquare("Square at 10.00 and 10.00'", "Sample square on bottom left", 10.00, 10.00);
        SquareValidator.isSquareValidWithNoOverlap(squares, square);
    }

    private Square getSquare(String s, String s2, double v, double v2) {
        Square square = new Square();
        square.setName(s);
        square.setType(ShapeTypeEnum.SQUARE);
        square.setGeometryDescription(s2);
        square.setxCoordinate(new BigDecimal(v));
        square.setyCoordinate(new BigDecimal(v2));
        square.setLength(new BigDecimal(2.0));
        return square;
    }

}