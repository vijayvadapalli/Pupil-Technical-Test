package com.pupil.technicaltest.validator;

import com.pupil.technicaltest.exception.SquareInvalidException;
import com.pupil.technicaltest.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SquareValidator {

    static Logger logger = LogManager.getLogger(SquareValidator.class);

    public static boolean isSquareValidWithNoOverlap(List<Square> squares, Square square) throws SquareInvalidException {

        logger.trace("Coordinates of new shape x {} and y{}", square.getxCoordinate(), square.getyCoordinate());
        float xCoordinateMinValue = square.getxCoordinate().floatValue();
        float yCoordinateMinValue = square.getyCoordinate().floatValue();

        float xCoordinateMaxValue = square.getxCoordinate().add(square.getLength()).floatValue();
        float yCoordinateMaxValue = square.getxCoordinate().add(square.getLength()).floatValue();


        for (Square localSquare : squares) {
            float xCoordinateMinValueLocal = localSquare.getxCoordinate().floatValue();
            float yCoordinateMinValueLocal = localSquare.getyCoordinate().floatValue();
            logger.trace("Min value of shape x {} and y {}", xCoordinateMinValueLocal, yCoordinateMinValueLocal);

            float xCoordinateMaxValueLocal = localSquare.getxCoordinate().add(localSquare.getLength()).floatValue();
            float yCoordinateMaxValueLocal = localSquare.getyCoordinate().add(localSquare.getLength()).floatValue();
            logger.trace("Max value of shape x {} and y {}", xCoordinateMaxValueLocal, yCoordinateMaxValueLocal);


            if ((xCoordinateMinValue > xCoordinateMinValueLocal
                    && xCoordinateMinValue < xCoordinateMaxValueLocal)
                    || (yCoordinateMinValue > yCoordinateMinValueLocal
                    && yCoordinateMinValue < yCoordinateMaxValueLocal)) {
                logger.error("Partial Overlap detected for coordinates {} {}", square.getxCoordinate(), square.getyCoordinate() +
                        " as they are between {},{} and {},{}", xCoordinateMinValueLocal, yCoordinateMinValueLocal, xCoordinateMaxValueLocal, yCoordinateMaxValueLocal);

                throw new SquareInvalidException("Partial Overlap detected for coordinates " + square.getxCoordinate() + "," + square.getyCoordinate() +
                        " as they are between " + xCoordinateMinValueLocal + "," + yCoordinateMinValueLocal +
                        " and " + xCoordinateMaxValueLocal + "," + yCoordinateMaxValueLocal);
            } else if ((xCoordinateMaxValue > xCoordinateMinValueLocal
                    && xCoordinateMaxValue < xCoordinateMaxValueLocal)
                    || (yCoordinateMaxValue > yCoordinateMinValueLocal
                    && yCoordinateMaxValue < yCoordinateMaxValueLocal)) {
                logger.error("Partial Overlap detected for coordinates {} {}", square.getxCoordinate(), square.getyCoordinate() +
                        " as they are between {},{} and {},{}", xCoordinateMinValueLocal, yCoordinateMinValueLocal, xCoordinateMaxValueLocal, yCoordinateMaxValueLocal);

                throw new SquareInvalidException("Partial Overlap detected for coordinates " + square.getxCoordinate() + "," + square.getyCoordinate() +
                        " as they are between " + xCoordinateMinValueLocal + "," + yCoordinateMinValueLocal +
                        " and " + xCoordinateMaxValueLocal + "," + yCoordinateMaxValueLocal);
            } else if (square.getxCoordinate().floatValue() == xCoordinateMinValueLocal
                    && square.getyCoordinate().floatValue() == yCoordinateMinValueLocal
                    && square.getLength().floatValue() == localSquare.getLength().floatValue()) {
                logger.error("Complete Overlap detected for coordinates {} {}", square.getxCoordinate(), square.getyCoordinate() +
                        " as they are between {},{} and {},{}", xCoordinateMinValueLocal, yCoordinateMinValueLocal, xCoordinateMaxValueLocal, yCoordinateMaxValueLocal);

                throw new SquareInvalidException("Complete Overlap detected for coordinates " + square.getxCoordinate() + "," + square.getyCoordinate() +
                        " as they are between " + xCoordinateMinValueLocal + "," + yCoordinateMinValueLocal +
                        " and " + xCoordinateMaxValueLocal + "," + yCoordinateMaxValueLocal);
            }
        }

        return true;
    }
}
