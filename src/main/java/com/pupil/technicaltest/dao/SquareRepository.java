package com.pupil.technicaltest.dao;

import com.pupil.technicaltest.model.ShapeTypeEnum;
import com.pupil.technicaltest.model.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquareRepository extends JpaRepository<Square, Long> {

    List<Square> findByType(ShapeTypeEnum type);
}
