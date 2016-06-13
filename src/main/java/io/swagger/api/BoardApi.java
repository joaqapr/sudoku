package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.Cell;
import io.swagger.model.Board;
import java.math.BigDecimal;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/board", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/board", description = "the board API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-13T18:34:20.426Z")
public class BoardApi {

  @ApiOperation(value = "", notes = "Deletes a Cell", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Cell deleted successfully", response = Void.class),
    @ApiResponse(code = 400, message = "Bad Request. Not valid payload and/or ID", response = Void.class),
    @ApiResponse(code = 404, message = "Cell or board not found", response = Void.class) })
  @RequestMapping(value = "/{boardid}/cell",
    
    consumes = { "application/json" },
    method = RequestMethod.DELETE)
  public ResponseEntity<Void> boardBoardidCellDelete(
@ApiParam(value = "ID of the board",required=true ) @PathVariable("boardid") String boardid

,
    

@ApiParam(value = "cell description"  ) @RequestBody Cell cell
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Void>(HttpStatus.OK);
  }


  @ApiOperation(value = "", notes = "Get all inserted cells in a board", response = Cell.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Array with all the cells on a board", response = Cell.class),
    @ApiResponse(code = 400, message = "Bad Request.", response = Cell.class),
    @ApiResponse(code = 404, message = "Board not found", response = Cell.class) })
  @RequestMapping(value = "/{boardid}/cell",
    
    
    method = RequestMethod.GET)
  public ResponseEntity<List<Cell>> boardBoardidCellGet(
@ApiParam(value = "ID of the board",required=true ) @PathVariable("boardid") String boardid

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<List<Cell>>(HttpStatus.OK);
  }


  @ApiOperation(value = "", notes = "Updates a cell", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Movement ok. Cell updated ok", response = Void.class),
    @ApiResponse(code = 400, message = "Bad Request.", response = Void.class),
    @ApiResponse(code = 404, message = "Board or cell not found", response = Void.class) })
  @RequestMapping(value = "/{boardid}/cell",
    
    consumes = { "application/json" },
    method = RequestMethod.POST)
  public ResponseEntity<Void> boardBoardidCellPost(
@ApiParam(value = "ID of the board",required=true ) @PathVariable("boardid") String boardid

,
    

@ApiParam(value = "cell description"  ) @RequestBody Cell cell
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Void>(HttpStatus.OK);
  }


  @ApiOperation(value = "", notes = "Gets `board` objects. Path param of **boardid** determines the board you want to get by Id. ", response = Board.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Successful response", response = Board.class),
    @ApiResponse(code = 400, message = "Bad Request, not valid payload and/or ID", response = Board.class),
    @ApiResponse(code = 404, message = "Board Not Found", response = Board.class) })
  @RequestMapping(value = "/{boardid}",
    produces = { "application/json" }, 
    
    method = RequestMethod.GET)
  public ResponseEntity<Board> boardBoardidGet(
@ApiParam(value = "Board ID",required=true ) @PathVariable("boardid") BigDecimal boardid

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Board>(HttpStatus.OK);
  }


  @ApiOperation(value = "", notes = "Updates an existing `board` or creates a new one ", response = Void.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "ok", response = Void.class) })
  @RequestMapping(value = "/{boardid}",
    
    
    method = RequestMethod.POST)
  public ResponseEntity<Void> boardBoardidPost(
@ApiParam(value = "Board ID",required=true ) @PathVariable("boardid") BigDecimal boardid

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Void>(HttpStatus.OK);
  }

}
