package com.pupil.technicaltest.service;


import com.pupil.technicaltest.dao.ShapeRepository;
import com.pupil.technicaltest.dao.SquareRepository;
import com.pupil.technicaltest.model.Shape;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;
import com.pupil.technicaltest.validator.SquareValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 *
 */
@Service
public class ShapeServiceImpl implements ShapeService {

    Logger logger = LogManager.getLogger(ShapeServiceImpl.class);

    @Autowired
    private ShapeRepository shapeRepository;

    @Override
    @Cacheable("shapes")
    public List<Shape> retrieveAllShapes() {
        return shapeRepository.findAll();
    }
}
