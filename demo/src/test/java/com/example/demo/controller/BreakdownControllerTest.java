package com.example.demo.controller;

import com.example.demo.exception.TestFailException;
import com.example.demo.model.LotCode;
import com.example.demo.model.WineComponent;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.LotCodeRepository;
import org.apache.commons.io.IOUtils;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BreakdownControllerTest {

    private final LotCodeRepository lotCodeRepository;
    private final ComponentRepository componentRepository;

    @Autowired
    public BreakdownControllerTest(LotCodeRepository lotCodeRepository, ComponentRepository componentRepository) {
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
    public void test01Post() throws IOException, InterruptedException{

        File file = new File("data_test/11YVCHAR001.json");
        String f = Files.readString(Path.of(file.getAbsolutePath()));

        HttpClient httpClient = HttpClient.newHttpClient();
        String url_psot = "http://localhost:8081/api/post";

        HttpRequest request_post = HttpRequest.newBuilder()
                .uri(URI.create(url_psot))
                .POST(HttpRequest.BodyPublishers.ofString(f))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response_post = httpClient.send(request_post, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, response_post.statusCode());
    }


    @Test
    public void test02Get() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        String url_get = "http://localhost:8081/api/search/11YVCHAR001";

        HttpRequest request_get = HttpRequest.newBuilder()
                .uri(URI.create(url_get))
                .GET()
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response_get = httpClient.send(request_get, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, response_get.statusCode());

    }


    @Test
    public void test03LotcodeTableUpdated() throws TestFailException {

        LotCode lc = lotCodeRepository.findById("11YVCHAR001")
                .orElseThrow(() -> new TestFailException("lot 11YVCHAR001 doesn't exist"));

        Assertions.assertTrue(lotCodeRepository.findById("11YVCHAR001").isPresent());
    }

    @Test
    public void test04OtherLotodeNotUpdated() {

        TestFailException exception_11YVCHAR002 = Assertions.assertThrows(TestFailException.class, ()->{
            LotCode lc2 = lotCodeRepository.findById("11YVCHAR002")
                    .orElseThrow(() -> new TestFailException("lot 11YVCHAR002 doesn't exist"));
        });

        Assertions.assertEquals("lot 11YVCHAR002 doesn't exist", exception_11YVCHAR002.getMessage());

    }

    @Test
    public void test05BothTablesUpdated() throws TestFailException {

        LotCode lc = lotCodeRepository.findById("11YVCHAR001")
                .orElseThrow(() -> new TestFailException("lot 11YVCHAR001 doesn't exist"));

        Assertions.assertEquals("11YVCHAR001", lc.getLotCode());
        Assertions.assertEquals(1000, lc.getVolume());
        Assertions.assertEquals("2011 Yarra Valley Chardonnay", lc.getDescription());
        Assertions.assertEquals("T25-01", lc.getTankCode());
        Assertions.assertEquals("Ready for bottling", lc.getProductState());
        Assertions.assertEquals("YV Wines Pty Ltd", lc.getOwnerName());



        List<WineComponent> wineComponents = componentRepository.findByLotcode("11YVCHAR001");
        Assertions.assertEquals(4, wineComponents.size());

        List<WineComponent> w = componentRepository.findByComponentYear("2011");
        Assertions.assertEquals(2, w.size());

    }

    @Test
    public void test06BusinessLogic() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        String url = "http://localhost:8081/api/breakdown/year-variety/11YVCHAR001";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        File file = new File("data_test/11YVCHAR001_breakdown.json");
        String f = Files.readString(Path.of(file.getAbsolutePath()));

        Assertions.assertEquals(f, response.body());

    }

    @Test
    public void test07DeleteWillUpdateBothTables() throws TestFailException {

        LotCode lc = lotCodeRepository.findById("11YVCHAR001")
                .orElseThrow(() -> new TestFailException("lot 11YVCHAR001 doesn't exist"));

        lotCodeRepository.delete(lc);

        Assertions.assertTrue(lotCodeRepository.findById("11YVCHAR001").isEmpty());
        Assertions.assertTrue(componentRepository.findByLotcode("11YVCHAR001").isEmpty());


    }


}