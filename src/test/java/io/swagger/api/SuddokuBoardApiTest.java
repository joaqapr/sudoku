package io.swagger.api;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Board;
import io.swagger.service.SudokuService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Swagger2SpringBoot.class)
@WebAppConfiguration
public class SuddokuBoardApiTest {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SudokuService sudokuService;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Board board = new Board("default");
        sudokuService.createOrUpdateBoard(board);
    }

    @Test
    public void getDefaultBoard() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/board/default").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void postCellDefaultBoard() throws Exception {
        String jsonCell = "{\n" +
                "    \"row\": 1,\n" +
                "    \"column\": 1,\n" +
                "    \"value\": 1\n" +
                "}";
        mvc.perform(MockMvcRequestBuilders.post("/board/default/cell").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(jsonCell))
                .andExpect(status().isOk());
    }
}