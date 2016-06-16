package io.swagger.integration;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Board;
import io.swagger.model.Cell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Swagger2SpringBoot.class)
@WebIntegrationTest({"server.port=9000", "management.port=0"})
public class ITSudokuBackend {

    @Value("${local.server.port}")
    private int port;
    private static final Logger LOGGER = LoggerFactory.getLogger(ITSudokuBackend.class);
    private URL base;
    private RestTemplate template;
    private Board defaultBoard;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        template = new TestRestTemplate();
        template.getMessageConverters().add(new StringHttpMessageConverter());
        defaultBoard = new Board("default");
        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(1, 1, 7 ));
        cells.add(new Cell(1, 5, 4 ));
        cells.add(new Cell(1, 7, 5 ));
        cells.add(new Cell(1, 8, 3 ));
        cells.add(new Cell(2, 3, 5 ));
        cells.add(new Cell(2, 6, 8 ));
        cells.add(new Cell(2, 8, 1 ));
        cells.add(new Cell(3, 3, 8 ));
        cells.add(new Cell(3, 4, 5 ));
        cells.add(new Cell(3, 6, 9 ));
        cells.add(new Cell(3, 8, 4 ));
        cells.add(new Cell(4, 1, 5 ));
        cells.add(new Cell(4, 2, 3 ));
        cells.add(new Cell(4, 3, 9 ));
        cells.add(new Cell(4, 5, 6 ));
        cells.add(new Cell(4, 9, 1 ));
        cells.add(new Cell(5, 5, 1 ));
        cells.add(new Cell(5, 9, 5 ));
        cells.add(new Cell(6, 1, 8 ));
        cells.add(new Cell(6, 4, 7 ));
        cells.add(new Cell(6, 5, 2 ));
        cells.add(new Cell(6, 7, 9 ));
        cells.add(new Cell(7, 1, 9 ));
        cells.add(new Cell(7, 3, 7 ));
        cells.add(new Cell(7, 4, 4 ));
        cells.add(new Cell(8, 5, 5 ));
        cells.add(new Cell(8, 6, 7 ));
        cells.add(new Cell(9, 1, 6 ));
        cells.add(new Cell(9, 8, 5 ));
        defaultBoard.setCells(cells);
        template.postForEntity(base.toString() + "board/", defaultBoard, Board.class);
    }

    @Test
    public void testGetDefaultBoard_expect200() {
        ResponseEntity<Board> response = template.getForEntity(base.toString() + "board/default", Board.class);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void testGetBoard_expect404() {
        ResponseEntity<String> response = template.getForEntity(base.toString() + "board/notfound", String.class);
        LOGGER.info("Response " + response);
        assertTrue(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
    }

    @Test
    public void testBoardCellMovement_expect200() {
        Cell cell = new Cell(0,2,1);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "board/default/cell", cell, String.class);
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    public void testBoardCellWrongMovement_expect403() {
        Cell cell = new Cell(0,2,7); // Wrong value on the default board
        ResponseEntity<String> response = template.postForEntity(base.toString() + "board/default/cell", cell, String.class);
        assertTrue(response.getStatusCode().equals(HttpStatus.FORBIDDEN));
    }
    @Test
    public void testBoardCellMovement_expect200FinishGame() {
        Set<Cell> cells = new HashSet<>();
        cells.add(new Cell(0, 0, 7 ));
        cells.add(new Cell(0, 1, 9 ));
        cells.add(new Cell(0, 2, 2 ));
        cells.add(new Cell(0, 3, 1 ));
        cells.add(new Cell(0, 4, 4 ));
        cells.add(new Cell(0, 5, 6 ));
        cells.add(new Cell(0, 6, 5 ));
        cells.add(new Cell(0, 7, 3 ));
        cells.add(new Cell(0, 8, 8 ));
        cells.add(new Cell(1, 0, 4 ));
        cells.add(new Cell(1, 1, 6 ));
        cells.add(new Cell(1, 2, 5 ));
        cells.add(new Cell(1, 3, 2 ));
        cells.add(new Cell(1, 4, 3 ));
        cells.add(new Cell(1, 5, 8 ));
        cells.add(new Cell(1, 6, 7 ));
        cells.add(new Cell(1, 7, 1 ));
        cells.add(new Cell(1, 8, 9 ));
        cells.add(new Cell(2, 0, 3 ));
        cells.add(new Cell(2, 1, 1 ));
        cells.add(new Cell(2, 2, 8 ));
        cells.add(new Cell(2, 3, 5 ));
        cells.add(new Cell(2, 4, 7 ));
        cells.add(new Cell(2, 5, 9 ));
        cells.add(new Cell(2, 6, 6 ));
        cells.add(new Cell(2, 7, 4 ));
        cells.add(new Cell(2, 8, 2 ));
        cells.add(new Cell(3, 0, 5 ));
        cells.add(new Cell(3, 1, 3 ));
        cells.add(new Cell(3, 2, 9 ));
        cells.add(new Cell(3, 3, 8 ));
        cells.add(new Cell(3, 4, 6 ));
        cells.add(new Cell(3, 5, 4 ));
        cells.add(new Cell(3, 6, 2 ));
        cells.add(new Cell(3, 7, 7 ));
        cells.add(new Cell(3, 8, 1 ));
        cells.add(new Cell(4, 0, 2 ));
        cells.add(new Cell(4, 1, 7 ));
        cells.add(new Cell(4, 2, 6 ));
        cells.add(new Cell(4, 3, 9 ));
        cells.add(new Cell(4, 4, 1 ));
        cells.add(new Cell(4, 5, 3 ));
        cells.add(new Cell(4, 6, 4 ));
        cells.add(new Cell(4, 7, 8 ));
        cells.add(new Cell(4, 8, 5 ));
        cells.add(new Cell(5, 0, 8 ));
        cells.add(new Cell(5, 1, 4 ));
        cells.add(new Cell(5, 2, 1 ));
        cells.add(new Cell(5, 3, 7 ));
        cells.add(new Cell(5, 4, 2 ));
        cells.add(new Cell(5, 5, 5 ));
        cells.add(new Cell(5, 6, 9 ));
        cells.add(new Cell(5, 7, 6 ));
        cells.add(new Cell(5, 8, 3 ));
        cells.add(new Cell(6, 0, 9 ));
        cells.add(new Cell(6, 1, 5 ));
        cells.add(new Cell(6, 2, 7 ));
        cells.add(new Cell(6, 3, 4 ));
        cells.add(new Cell(6, 4, 8 ));
        cells.add(new Cell(6, 5, 1 ));
        cells.add(new Cell(6, 6, 3 ));
        cells.add(new Cell(6, 7, 2 ));
        cells.add(new Cell(6, 8, 6 ));
        cells.add(new Cell(7, 0, 1 ));
        cells.add(new Cell(7, 1, 2 ));
        cells.add(new Cell(7, 2, 3 ));
        cells.add(new Cell(7, 3, 6 ));
        cells.add(new Cell(7, 4, 5 ));
        cells.add(new Cell(7, 5, 7 ));
        cells.add(new Cell(7, 6, 8 ));
        cells.add(new Cell(7, 7, 9 ));
        cells.add(new Cell(7, 8, 4 ));
        cells.add(new Cell(8, 0, 6 ));
        cells.add(new Cell(8, 1, 8 ));
        cells.add(new Cell(8, 2, 4 ));
        cells.add(new Cell(8, 3, 3 ));
        cells.add(new Cell(8, 4, 9 ));
        cells.add(new Cell(8, 5, 2 ));
        cells.add(new Cell(8, 6, 1 ));
        cells.add(new Cell(8, 7, 5 ));
        Board defaultFinishedBoard = new Board("defaultFinished");
        defaultFinishedBoard.setCells(cells);
        template.postForEntity(base.toString() + "board/", defaultFinishedBoard, Board.class);
        Cell cell = new Cell(8, 8, 7);
        ResponseEntity<Cell> response = template.postForEntity(base.toString() + "board/defaultFinished/cell", cell, Cell.class);
        LOGGER.info("Response Update Cell: " + response);
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        ResponseEntity<Board> responseBoard = template.getForEntity(base.toString() + "board/defaultFinished", Board.class);
        LOGGER.info("Response Get Board: " + responseBoard);
        assertTrue(responseBoard.getBody().getIsComplete());
    }
}