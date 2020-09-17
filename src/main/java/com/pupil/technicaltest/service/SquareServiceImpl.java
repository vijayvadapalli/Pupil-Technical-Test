package com.pupil.technicaltest.service;


import com.pupil.technicaltest.dao.SquareRepository;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;
import com.pupil.technicaltest.validator.SquareValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 */
@Service
public class SquareServiceImpl implements SquareService {

    Logger logger = LogManager.getLogger(SquareServiceImpl.class);

    @Autowired
    private SquareRepository squareRepository;

    @Override
    public List<Square> retrieveAllSquares() {
        return squareRepository.findByType(ShapeTypeEnum.SQUARE);
    }

    @Override
    @CacheEvict(value = "shapes", allEntries = true)
    public Square createSquare(Square square) {
        SquareValidator.isSquareValidWithNoOverlap(retrieveAllSquares(), square);
        return squareRepository.save(square);
    }
}
