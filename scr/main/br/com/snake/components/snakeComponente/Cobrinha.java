package scr.main.br.com.snake.components.snakeComponente;

import scr.main.br.com.snake.components.screen.TelaJogo;

public class Cobrinha {

    public int corpoCobra; // Tamanho inicial da cobrinha
    public int blocosComidos;
    public static char direcao; // C - Cima, B - Baixo, E - Esquerda, D - Direita

    public static final int[] eixoX = new int[TelaJogo.UNIDADES]; // blocos da cobrinha
    public static final int[] eixoY = new int[TelaJogo.UNIDADES]; // blocos da cobrinha

    public Cobrinha( int TAM_INIT, char ORIENTACAO ){
        direcao = ORIENTACAO;
        this.corpoCobra = TAM_INIT;
    }

    public void andar() {
        for (int i = corpoCobra; i > 0; i--) {
            eixoX[i] = eixoX[i - 1];
            eixoY[i] = eixoY[i - 1];
        }
        switch ( direcao ) {
            case 'C' -> eixoY[0] = eixoY[0] - TelaJogo.TAMANHO_BLOCO;
            case 'B' -> eixoY[0] = eixoY[0] + TelaJogo.TAMANHO_BLOCO;
            case 'E' -> eixoX[0] = eixoX[0] - TelaJogo.TAMANHO_BLOCO;
            case 'D' -> eixoX[0] = eixoX[0] + TelaJogo.TAMANHO_BLOCO;
            default -> {}
        }
    }
    public void alcancarBloco() {
        if ( eixoX[0] == TelaJogo.blocoX && eixoY[0] == TelaJogo.blocoY ) {
            corpoCobra++;
            blocosComidos++;
            TelaJogo.criarBloco();
        }
    }
    public void validarLimites() {
        //A cabeça bateu no corpo?
        for ( int i = this.corpoCobra; i > 0; i-- ) {
            if ( eixoX[0] == eixoX[i] && eixoY[0] == eixoY[i] ) {
                TelaJogo.estaRodando = false;
                break;
            }
        }
        //A cabeça tocou uma das bordas Direita ou esquerda?
        if ( eixoX[0] < 0  || eixoX[0] > TelaJogo.LARGURA_TELA ) {
            TelaJogo.estaRodando = false;
        }
        //A cabeça tocou o piso ou o teto?
        if ( eixoY[0] < 0 || eixoY[0] > TelaJogo.ALTURA_TELA ) {
            TelaJogo.estaRodando = false;
        }
        // interrompe a renderização da tela.
        if ( !TelaJogo.estaRodando ) {
            TelaJogo.timer.stop();
        }
    }
}
