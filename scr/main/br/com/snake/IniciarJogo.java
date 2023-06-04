package scr.main.br.com.snake;

import javax.swing.*;
import scr.main.br.com.snake.components.screen.TelaJogo;

import java.io.IOException;

public class IniciarJogo extends JFrame {
    public static void main(String[] args) throws IOException {
        new IniciarJogo(); // instanciando JFrame
    }

    IniciarJogo() throws IOException {
        /* Criando a janela do jogo */
        add(new TelaJogo());

        /* Atribuindo as config das telas */
        setTitle("Jogo da Cobrinha");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setFocusable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

