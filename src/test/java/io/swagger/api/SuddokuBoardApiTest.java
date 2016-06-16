package io.swagger.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SuddokuBoardApiTest {
    private MockMvc mvc;
    private String defaultJsonContext = "";

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SuddokuBoardApi()).build();
    }

    @Test
    public void getDefaultBoard() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/board/default").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(defaultJsonContext));
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