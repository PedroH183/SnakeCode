package scr.main.br.com.snake.components.screen;

import scr.main.br.com.snake.components.snakeComponente.Cobrinha;

import java.awt.*;
import javax.swing.*; 

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogo extends JPanel implements ActionListener{

    // configs da tela
    private static final int LARGURA_TELA = 1024;
    private static final int ALTURA_TELA = 512;
    public static final int TAMANHO_BLOCO = 50;
    private static final int UNIDADES = LARGURA_TELA * ALTURA_TELA / (TAMANHO_BLOCO * TAMANHO_BLOCO);

    private static final int INTERVALO = 180; // Velocidade da cobrinha inicial
    private static final String NOME_FONTE = "Agave";

    public static final int[] eixoX = new int[UNIDADES];
    public static final int[] eixoY = new int[UNIDADES];

    public static int blocoX; // identificador do bloco
    public static int blocoY;

    // configs da cobrinha
    private final Cobrinha cobrinha;
    private boolean estaRodando = false;

    Timer timer;
    static Random random;

    public TelaJogo() {

        // inicializando a cobrinha
        this.cobrinha = new Cobrinha();

        // renderizando a tela
        random = new Random();
        setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(new LeitorDeTeclasAdapter() );

        // iniciando o jogo
        iniciarJogo();
    }

    public void iniciarJogo() {
        criarBloco();
        estaRodando = true;
        timer = new Timer(INTERVALO, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharTela(g);
    }

    public void desenharTela(Graphics g) {

        if (estaRodando) {
            g.setColor(Color.red);
            g.fillOval(blocoX, blocoY, TAMANHO_BLOCO, TAMANHO_BLOCO);

            for (int i = 0; i < cobrinha.corpoCobra; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(eixoX[0], eixoY[0], TAMANHO_BLOCO, TAMANHO_BLOCO);
                    /* colocar a cobrinha para ficar listrada e colocar cor nas bordas de colisão */
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(eixoX[i], eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
                }
            }
            g.setColor(new Color(45,45,45));
            g.setFont(new Font(NOME_FONTE, Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Pontos: " + cobrinha.blocosComidos, (LARGURA_TELA - metrics.stringWidth("Pontos: " + cobrinha.blocosComidos)) / 2, g.getFont().getSize());
        } else {
            fimDeJogo(g);
        }
    }

    public static void criarBloco() {
        blocoX = random.nextInt(LARGURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
        blocoY = random.nextInt(ALTURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
    }

    public void fimDeJogo(Graphics g) {
        // O funcionamento se assemelha com o de states.
        g.setColor(new Color(45,45,45));
        g.setFont(new Font(NOME_FONTE, Font.BOLD, 20));

        FontMetrics fontePontuacao = getFontMetrics(g.getFont());

        g.drawString("Pontos: " + cobrinha.blocosComidos, (LARGURA_TELA - fontePontuacao.stringWidth("Pontos: " + cobrinha.blocosComidos)) / 2, g.getFont().getSize());

        g.setColor(new Color(45,45,45));
        g.setFont(new Font(NOME_FONTE, Font.BOLD, 75));
        FontMetrics fonteFinal = getFontMetrics(g.getFont());
        g.drawString("\uD83D\uDE1D Fim do Jogo.", (LARGURA_TELA - fonteFinal.stringWidth("Fim do Jogo")) / 2, ALTURA_TELA / 2);

    }

    public void actionPerformed(ActionEvent e) {
        if (estaRodando) {
            cobrinha.andar();
            cobrinha.alcancarBloco();
            validarLimites();
        }
        repaint();
    }

    private void validarLimites() {
        //A cabeça bateu no corpo?
        for (int i = cobrinha.corpoCobra; i > 0; i--) {
            if ( eixoX[0] == eixoX[i] && eixoY[0] == eixoY[i] ) {
                estaRodando = false;
                break;
            }
        }
        //A cabeça tocou uma das bordas Direita ou esquerda?
        if ( eixoX[0] < 0 || eixoX[0] > LARGURA_TELA ) {
            estaRodando = false;
        }
        //A cabeça tocou o piso ou o teto?
        if ( eixoY[0] < 0 || eixoY[0] > ALTURA_TELA ) {
            estaRodando = false;
        }
        if ( !estaRodando ) {
            timer.stop();
        }
    }
}
