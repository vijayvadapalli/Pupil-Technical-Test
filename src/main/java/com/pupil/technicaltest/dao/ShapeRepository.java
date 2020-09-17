package com.pupil.technicaltest.dao;

import com.pupil.technicaltest.model.Shape;
import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {
}
