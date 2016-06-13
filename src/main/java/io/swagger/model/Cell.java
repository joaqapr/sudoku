package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-13T18:34:20.426Z")
public class Cell {

    private Integer row = null;
    private Integer column = null;
    private Integer value = null;

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("row")
    @Max(9)
    @Min(0)
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("column")
    @Max(9)
    @Min(0)
    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("value")
    @Max(9)
    @Min(0)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return Objects.equals(row, cell.row) &&
                Objects.equals(column, cell.column) &&
                Objects.equals(value, cell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cell {\n");

        sb.append("  row: ").append(row).append("\n");
        sb.append("  column: ").append(column).append("\n");
        sb.append("  value: ").append(value).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}