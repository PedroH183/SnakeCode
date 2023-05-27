package scr.main.br.com.snake.components.screen;

import scr.main.br.com.snake.components.Cobrinha;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LeitorDeTeclasAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                if (Cobrinha.direcao != 'D') {
                    Cobrinha.direcao = 'E';
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (Cobrinha.direcao != 'E') {
                    Cobrinha.direcao = 'D';
                }
            }
            case KeyEvent.VK_UP -> {
                if (Cobrinha.direcao != 'B') {
                    Cobrinha.direcao = 'C';
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (Cobrinha.direcao != 'C') {
                    Cobrinha.direcao = 'B';
                }
            }
            default -> {
            }
        }
    }
}