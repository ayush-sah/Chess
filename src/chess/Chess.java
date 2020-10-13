package chess;

import chess.board.Board;
import chess.gui.LoginForm;
import chess.gui.Table;

import java.io.IOException;

public class Chess {
    public static void main(String[] args) throws IOException {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
