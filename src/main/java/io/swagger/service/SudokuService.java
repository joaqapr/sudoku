package io.swagger.service;


import io.swagger.api.ApiException;
import io.swagger.model.Board;
import io.swagger.model.Cell;
import io.swagger.repository.SudokuBoardRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SudokuService {

    public static final int BLOCK_SIZE = 3;

    public void updateCell(Board board, Cell cell) throws ApiException {
        Iterator<Cell> iterator = board.getCells().iterator();
        Cell replaceCell = null;
        while (iterator.hasNext()) {
            Cell nextCell = iterator.next();
            //Check if the cell is already inserted
            if (nextCell.getRow() == cell.getRow() && nextCell.getValue() == cell.getValue()
                    && nextCell.getColumn() == cell.getColumn()) {
                replaceCell = nextCell;
            }
            if (nextCell.getRow() == cell.getRow() && nextCell.getValue() == cell.getValue())
                throw new ApiException(1, "Number already in the row");
            if (nextCell.getColumn() == cell.getColumn() && nextCell.getValue() == cell.getValue())
                throw new ApiException(1, "Number already in the column");
            if ((nextCell.getColumn() / BLOCK_SIZE) == (cell.getColumn() / BLOCK_SIZE)
                    && (nextCell.getRow() / BLOCK_SIZE) == (cell.getRow() / BLOCK_SIZE)
                    && nextCell.getValue() == cell.getValue())
                throw new ApiException(1, "Number already in the block");
        }
        //replace or insert a cell
        if (replaceCell != null) {
            board.getCells().remove(replaceCell);
            board.getCells().add(cell);
        } else {
            board.getCells().add(cell);
        }
        if (board.getCells().size() == 81)
            board.setIsComplete(true);
    }

    public Board findBoardById(String boardId) {
        Map<String, Board> sudokuBoards = SudokuBoardRepository.getInstance().getSudokuBoards();
        if (!sudokuBoards.containsKey(boardId))
            return null;
        return sudokuBoards.get(boardId);
    }

    public void createOrUpdateBoard(Board board) {
        Map<String, Board> sudokuBoards = SudokuBoardRepository.getInstance().getSudokuBoards();
        if (sudokuBoards.containsKey(board.getId()))
            sudokuBoards.remove(board.getId());
        sudokuBoards.put(board.getId(), board);
    }

    public void deletedCell(Board board, Cell cell) {
        if (board.getCells().contains(cell))
            board.getCells().remove(cell);
    }
}
