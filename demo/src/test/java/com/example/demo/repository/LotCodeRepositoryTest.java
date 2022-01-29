package com.example.demo.repository;

import com.example.demo.model.LotCode;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LotCodeRepositoryTest {


    private final LotCodeRepository lotCodeRepository;
    private final ComponentRepository componentRepository;

    @Autowired
    public LotCodeRepositoryTest(LotCodeRepository lotCodeRepository, ComponentRepository componentRepository) {
        this.lotCodeRepository = lotCodeRepository;
        this.componentRepository = componentRepository;
    }

    @BeforeAll
    public static void init() {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:mem:testdb", "sa","" )
                .mixed(true)
                .locations("filesystem:src/test/resources/db/migration")
                .load();

        flyway.migrate();
    }

    @Test
    public void save_test(){
        lotCodeRepository.saveAndFlush(new LotCode("lotcode_test", 1000, "a", "b", "c", "d"));
        LotCode l = lotCodeRepository.findById("lotcode_test").orElseThrow();
        Assertions.assertEquals("lotcode_test", l.getLotCode());

        lotCodeRepository.delete(l);
        Assertions.assertEquals(true, lotCodeRepository.findById("lotcode_test").isEmpty());

    }
}
