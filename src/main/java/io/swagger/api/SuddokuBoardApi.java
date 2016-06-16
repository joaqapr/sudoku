package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Board;
import io.swagger.model.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(value = "/board", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/board", description = "the board API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-13T18:34:20.426Z")
public class SuddokuBoardApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuddokuBoardApi.class);


    @ApiOperation(value = "", notes = "Deletes a Cell", response = ApiResponseMessage.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cell deleted successfully", response = ApiResponseMessage.class),
            @ApiResponse(code = 400, message = "Bad Request. Not valid payload and/or ID", response = ApiResponseMessage.class),
            @ApiResponse(code = 404, message = "Cell or board not found", response = ApiResponseMessage.class)})
    @RequestMapping(value = "/{boardid}/cell",
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponseMessage> boardBoardidCellDelete(@ApiParam(value = "ID of the board", required = true) @PathVariable("boardid") String boardid,
            @ApiParam(value = "cell description") @RequestBody Cell cell) throws NotFoundException {
        // do some magic!
        return new ResponseEntity<ApiResponseMessage>(new ApiResponseMessage(4, "Cell updated or created OK") , HttpStatus.OK);
    }


    @ApiOperation(value = "", notes = "Updates a cell", response = ApiResponseMessage.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movement ok. Cell updated ok", response = ApiResponseMessage.class),
            @ApiResponse(code = 400, message = "Bad Request.", response = ApiResponseMessage.class),
            @ApiResponse(code = 403, message = "Not valid movement", response = ApiResponseMessage.class),
            @ApiResponse(code = 404, message = "Board or cell not found", response = ApiResponseMessage.class)})
    @RequestMapping(value = "/{boardid}/cell",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<ApiResponseMessage> boardBoardidCellPost(@ApiParam(value = "ID of the board", required = true) @PathVariable("boardid") String boardid,
            @ApiParam(value = "cell description") @RequestBody Cell cell)  throws NotFoundException {

        return new ResponseEntity<ApiResponseMessage>(new ApiResponseMessage(4, "Cell updated or created OK") , HttpStatus.OK);
    }


    @ApiOperation(value = "", notes = "Gets `board` objects. Path param of **boardid** determines the board you want to get by Id. ", response = Board.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = Board.class),
            @ApiResponse(code = 400, message = "Bad Request, not valid payload and/or ID", response = Board.class),
            @ApiResponse(code = 404, message = "Board Not Found", response = Board.class)})
    @RequestMapping(value = "/{boardid}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Board> boardBoardidGet(@ApiParam(value = "Board ID", required = true) @PathVariable("boardid") String boardid) {

        return new ResponseEntity<Board>(HttpStatus.OK);
    }


    @ApiOperation(value = "", notes = "Updates an existing `board` or creates a new one ", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok", response = ApiResponseMessage.class),
            @ApiResponse(code = 400, message = "Bad Request. Not valid payload", response = ApiResponseMessage.class)})
    @RequestMapping(value = "/",
            method = RequestMethod.POST)
    public ResponseEntity<ApiResponseMessage> boardBoardidPost(@RequestBody Board board)
            throws NotFoundException {

        return new ResponseEntity<ApiResponseMessage>(new ApiResponseMessage(4, "Board updated or created OK") , HttpStatus.OK);
    }

}
