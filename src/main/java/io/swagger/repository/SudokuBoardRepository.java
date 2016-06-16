package io.swagger.repository;

import io.swagger.model.Board;

import java.util.HashMap;
import java.util.Map;

//TODO: Get a proper repository
public final class SudokuBoardRepository {

    private static Map<String, Board> sudokuBoards = new HashMap<String, Board>();
    private static final SudokuBoardRepository INSTANCE = new SudokuBoardRepository();

    private SudokuBoardRepository() {  }

    public static SudokuBoardRepository getInstance() {
        return INSTANCE;
    }

    public Map<String, Board> getSudokuBoards() {
        return sudokuBoards;
    }

}
