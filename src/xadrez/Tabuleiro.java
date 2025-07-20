package xadrez;

/**
 *
 * @author Felipe Ferreira Barros
 */
public class Tabuleiro {

    private int linha;
    private int coluna;
    private Casa[][] tabuleiro;

    //Inicializa o tabuleiro com as casas
    public Tabuleiro() {
        tabuleiro = new Casa[8][8];
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                char cor = ((linha + coluna) % 2 == 0) ? 'B' : 'P';
                tabuleiro[linha][coluna] = new Casa(cor, linha, (char)((coluna) + 'a'));
            }
        }
    }

    //Desenha o tabuleiro na tela
    public String desenho() {
        String resultado = "";
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                if (tabuleiro[linha][coluna].estaOcupada()) {
                    Peca p = tabuleiro[linha][coluna].getPeca();
                    p.desenho();
                    continue;
                }
                if (tabuleiro[linha][coluna].getCor() == 'P') {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
            resultado += "\n";
        }
        return resultado;
    }

    public boolean noLimite(int linha, char coluna) {
        return linha >= 1 && linha <= 8 && coluna >= 'a' && coluna <= 'h';
    }

}
