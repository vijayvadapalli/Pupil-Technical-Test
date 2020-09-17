package com.pupil.technicaltest.service;

import com.pupil.technicaltest.model.Shape;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;

import java.util.List;


public interface SquareService {

    List<Square> retrieveAllSquares();

    Square createSquare(Square square);
}
