package com.pupil.technicaltest.springbootinitialload;


import com.pupil.technicaltest.ShapeApplication;
import com.pupil.technicaltest.dao.ShapeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShapeApplication.class)
@Sql("/shape.sql")
public class SpringBootInitialLoadIntegrationTest {

    @Autowired
    private ShapeRepository shapeRepository;

    @Test
    @Sql(scripts = {"/import_shapes.sql"})
    public void testLoadDataForTestCase() {
        assertEquals(6, shapeRepository.findAll()
                .size());
    }
}
