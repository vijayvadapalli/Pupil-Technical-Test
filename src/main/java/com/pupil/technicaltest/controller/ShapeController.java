package com.pupil.technicaltest.controller;

import com.pupil.technicaltest.model.Shape;
import com.pupil.technicaltest.model.Square;
import com.pupil.technicaltest.service.ShapeService;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ShapeController {

    Logger logger = LogManager.getLogger(ShapeController.class);


    @Autowired
    private ShapeService shapeService;

    /**
     * Get all shapes
     *
     * @return Shapes
     */
    @GetMapping("/shapes")
    public List<Shape> retrieveAllShapes() {
        logger.trace("Getting all shapes");
        return shapeService.retrieveAllShapes();
    }
}
