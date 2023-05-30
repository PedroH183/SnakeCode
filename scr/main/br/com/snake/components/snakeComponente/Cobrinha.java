package scr.main.br.com.snake.components.snakeComponente;

import scr.main.br.com.snake.components.screen.TelaJogo;

public class Cobrinha {

    public int corpoCobra = 4; // Tamanho inicial da cobrinha
    public int blocosComidos;
    public static char direcao = 'D'; // C - Cima, B - Baixo, E - Esquerda, D - Direita
    public void andar() {
        for (int i = corpoCobra; i > 0; i--) {
            TelaJogo.eixoX[i] = TelaJogo.eixoX[i - 1];
            TelaJogo.eixoY[i] = TelaJogo.eixoY[i - 1];
        }
        switch ( direcao ) {
            case 'C' -> TelaJogo.eixoY[0] = TelaJogo.eixoY[0] - TelaJogo.TAMANHO_BLOCO;
            case 'B' -> TelaJogo.eixoY[0]  = TelaJogo.eixoY[0] + TelaJogo.TAMANHO_BLOCO;
            case 'E' -> TelaJogo.eixoX[0] = TelaJogo.eixoX[0] - TelaJogo.TAMANHO_BLOCO;
            case 'D' -> TelaJogo.eixoX[0] = TelaJogo.eixoX[0] + TelaJogo.TAMANHO_BLOCO;
            default -> {
            }
        }
    }
    public void alcancarBloco() {
        if (TelaJogo.eixoX[0] == TelaJogo.blocoX && TelaJogo.eixoY[0] == TelaJogo.blocoY) {
            corpoCobra++;
            blocosComidos++;
            TelaJogo.criarBloco();
        }
    }
}
