package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-13T18:34:20.426Z")
public class Board {

    private String id = "";
    private boolean isComplete = false;
    private Set<Cell> cells = new HashSet<Cell>();

    public Board() {   }

    public Board(String id) {
        this.id = id;
    }

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("id")
    @NotNull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("isComplete")
    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("cells")
    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return Objects.equals(id, board.id) &&
                isComplete == board.isComplete &&
                Objects.equals(cells, board.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isComplete, cells);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Board {\n");

        sb.append("  id: ").append(id).append("\n");
        sb.append("  isComplete: ").append(isComplete).append("\n");
        sb.append("  cells: ").append(cells).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
