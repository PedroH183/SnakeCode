package scr.main.br.com.snake;

import javax.swing.*;
import scr.main.br.com.snake.components.screen.TelaJogo;

public class IniciarJogo extends JFrame {
    public static void main(String[] args) {
        new IniciarJogo(); // instanciando JFrame
    }

    IniciarJogo(){
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

