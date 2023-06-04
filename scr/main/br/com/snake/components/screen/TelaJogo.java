package scr.main.br.com.snake.components.screen;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scr.main.br.com.snake.components.snakeComponente.Cobrinha;

public class TelaJogo extends JPanel implements ActionListener, PropsTelas{

    // coordenadas de geração
    public static int blocoX;
    public static int blocoY;

    // configs da cobrinha
    public static Cobrinha cobrinha = null;
    public static boolean estaRodando = false;

    public static Timer timer;
    static Random random;

    public TelaJogo(){
        // inicializando a cobrinha
        cobrinha = new Cobrinha(4,'D');

        // renderizando a tela
        random = new Random();
        setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA));
        setBackground(new Color(86,125,70));
        setFocusable(true);
        addKeyListener(new LeitorDeTeclasAdapter() );

        // iniciando o jogo
        iniciarJogo();
    }

    public void iniciarJogo() {
        criarBloco();
        estaRodando = true;
        timer = new Timer(INTERVALO_, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharTela(g);
    }

    public void desenharTela(Graphics g) {
        if(estaRodando){
            // gerando as maças
            g.setColor(new Color(164,53,2));
            g.fillOval(blocoX, blocoY, TAMANHO_BLOCO, TAMANHO_BLOCO);

            // personalizando a cobrinha
            for (int i = 0; i < cobrinha.corpoCobra; i++) {
                if( i % 2 == 1 ){
                    g.setColor(new Color(239,214,49));
                    g.fillRect(Cobrinha.eixoX[i],Cobrinha.eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
                    continue;
                }
                g.setColor(new Color(206,193,69));
                g.fillRect( Cobrinha.eixoX[i], Cobrinha.eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
            }

            // personalização da pontuação
            g.setColor(new Color(226, 201, 183));
            g.setFont(new Font(NOME_FONTE, Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Pontos: " + cobrinha.blocosComidos, (LARGURA_TELA - metrics.stringWidth("Pontos: " + cobrinha.blocosComidos)) / 2, g.getFont().getSize());
        }else{
            fimDeJogo(g);
        }
}

    public static void criarBloco() {
        blocoX = random.nextInt( LARGURA_TELA / TAMANHO_BLOCO ) * TAMANHO_BLOCO;
        blocoY = random.nextInt( ALTURA_TELA / TAMANHO_BLOCO  ) * TAMANHO_BLOCO;
    }

    public void fimDeJogo(Graphics g) {
        // O funcionamento se assemelha com o de states.
        g.setColor(new Color( 226, 201, 183));
        g.setFont(new Font(NOME_FONTE, Font.BOLD, 20));

        FontMetrics fontePontuacao = getFontMetrics(g.getFont());

        g.drawString("Pontos: " + cobrinha.blocosComidos, (LARGURA_TELA - fontePontuacao.stringWidth("Pontos: " + cobrinha.blocosComidos)) / 2, g.getFont().getSize());

        g.setColor(new Color(226, 201, 183));
        g.setFont(new Font(NOME_FONTE, Font.BOLD, 75));
        FontMetrics fonteFinal = getFontMetrics(g.getFont());
        g.drawString("\uD83D\uDE1D Fim do Jogo.", (LARGURA_TELA - fonteFinal.stringWidth("Fim do Jogo")) / 2, ALTURA_TELA / 2);
    }

    public void actionPerformed(ActionEvent e) {
        if (estaRodando) {
            cobrinha.andar();
            cobrinha.alcancarBloco();
            cobrinha.validarLimites();
        }
        repaint();
    }
}
