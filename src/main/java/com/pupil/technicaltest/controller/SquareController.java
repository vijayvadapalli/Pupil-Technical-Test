package com.pupil.technicaltest.controller;

import com.pupil.technicaltest.model.Shape;
import com.pupil.technicaltest.model.Square;
import com.pupil.technicaltest.service.ShapeService;
import com.pupil.technicaltest.service.SquareService;
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
public class SquareController {

    Logger logger = LogManager.getLogger(SquareController.class);


    @Autowired
    private SquareService squareService;

    /**
     * Create a Square
     *
     * @param square
     * @return Square Enitity Object
     */
    @PostMapping(path = "/square", consumes = "application/json")
    public ResponseEntity<Object> createSquare(@NotNull @RequestBody Square square) {
        Square savedSquare = squareService.createSquare(square);

        logger.info("Created square with Id" + savedSquare.getId());
        // retrieve HATEOAS link
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/shapes").buildAndExpand()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
