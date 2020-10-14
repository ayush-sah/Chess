package chess.gui;

import chess.board.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginForm extends JFrame{
    private JPanel panel1;
    private JTextField txtf_username;
    private JPasswordField txtf_password;
    private JButton resetButton;
    private JButton playGameButton;
    private JPanel rootPanel;

    public LoginForm() {
        add(rootPanel);
        setTitle("Login to Play Chess");
        setSize(400, 400);

        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chess?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                    String sql = "Select * from login where username = ? and password = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, txtf_username.getText());
                    pst.setString(2, txtf_password.getText());
                    ResultSet rst = pst.executeQuery();
                    if(rst.next()){
                        Board board = Board.createStandardBoard();
                        System.out.println(board);
                        Table table = new Table();
                        System.out.println(table);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
                        txtf_username.setText("");
                        txtf_password.setText("");
                    }
                    con.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
    }
}
