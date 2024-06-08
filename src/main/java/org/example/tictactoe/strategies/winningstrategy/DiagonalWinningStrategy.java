package org.example.tictactoe.strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagnalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getSymbol();

        Map<Character, Integer> leftDiagonal = new HashMap<>();
        Map<Character, Integer> rightDiagonal = new HashMap<>();

        // check is cell if part of left diagonal
        if (row == col) {
            // check if the symbol is coming for the first time
            if (!leftDiagonal.containsKey(symbol)) {
                leftDiagonal.put(symbol, 0);
            }
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
        }
        // check count of current symbol is same as size of board
        if (board.getBoard().size() == leftDiagonal.get(symbol)) {
            return true;
        }


        // check if the cell of the right diagonal
        if ((row + col) == board.getDimension()) {
            // check if the symbol is coming for the first time
            if (!rightDiagonal.containsKey(symbol)) {
                rightDiagonal.put(symbol, 0);
            }
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);
        }

        // check count of current symbol is same as size of board
        return board.getBoard().size() == rightDiagonal.get(symbol);
    }
}
