package scr.main.br.com.snake.components.screen;

import scr.main.br.com.snake.components.snakeComponente.Cobrinha;

import javax.swing.*;
import java.awt.*;

public class FimGame extends JPanel implements PropsTelas{
    public void fimDeJogo(Graphics g) {
        // O funcionamento se assemelha com o de states.
        g.setColor(new Color( 226, 201, 183));
        g.setFont(new Font(NOME_FONTE, Font.BOLD, 20));

        FontMetrics fontePontuacao = getFontMetrics(g.getFont());
        g.drawString("Pontos: " + TelaJogo.cobrinha.blocosComidos, (LARGURA_TELA - fontePontuacao.stringWidth("Pontos: " + TelaJogo.cobrinha.blocosComidos)) / 2, g.getFont().getSize());

        g.setColor(new Color(226, 201, 183));
        g.setFont(new Font(NOME_FONTE, Font.BOLD, 75));
        FontMetrics fonteFinal = getFontMetrics(g.getFont());
        g.drawString("\uD83D\uDE1D Fim do Jogo.", (LARGURA_TELA - fonteFinal.stringWidth("Fim do Jogo")) / 2, ALTURA_TELA / 2);

        /* Criando um botão para reiniciar o jogo */
        JButton restartButton = new JButton("Reiniciar");
        restartButton.setFont(new Font("Agave", Font.BOLD, 16));
        restartButton.setBackground(new Color( 104, 88, 84));
        restartButton.setForeground(Color.WHITE);
//        restartButton.addActionListener(e -> reiniciarJogo());
        restartButton.setBounds( (int) ((LARGURA_TELA - fonteFinal.stringWidth("Fim do Jogo")) / 1.3), (int) (ALTURA_TELA / 1.5), 150, 80);
        super.add(restartButton);
        restartButton.setVisible(true);
    }
}
