package chess;

import chess.board.Board;
import chess.gui.Table;

import java.io.IOException;

public class Chess {
    public static void main(String[] args) throws IOException {
        Board board = Board.createStandardBoard();
        System.out.println(board);
        Table table = new Table();
    }
}
