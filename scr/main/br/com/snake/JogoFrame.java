package scr.main.br.com.snake;

import javax.swing.*;

import scr.main.br.com.snake.components.screen.PropsTelas;
import scr.main.br.com.snake.components.screen.TelaJogo;

public class JogoFrame extends JFrame implements PropsTelas {
    public static void main(String[] args) {
        new JogoFrame(); // instanciando JFrame
    }

    JogoFrame(){
        /* Criando a janela do jogo */
        add(new TelaJogo());

        /* Atribuindo as config das telas */
        setTitle("Jogo da Cobrinha");
        setResizable(false);
        pack();
        setFocusable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

