package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro
 * Augusto(834765), João Henrique(822428))
 */
public class Tabuleiro {
    private Casa[][] tabuleiro;

    //Inicializa o tabuleiro com as casas
    public Tabuleiro(Peca[] pecaP, Peca[] pecaB) {
        //0-8 peoes; 9 - 10 torres; 11-12 cavalos; 13-14 bispos; 15 Dama; 16 rei;
        tabuleiro = new Casa[8][8];
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                char cor = ((linha + coluna) % 2 == 0) ? 'B' : 'P';
                tabuleiro[linha][coluna] = new Casa(cor, linha, (char) ((coluna) + 'a'));
            }
        }
        for (int i = 0; i < 8; i++) {
            tabuleiro[1][i].setOcupada(pecaP[i]);
            tabuleiro[6][i].setOcupada(pecaB[i]);
        }
        tabuleiro[0][0].setOcupada(pecaP[9]);
        tabuleiro[0][7].setOcupada(pecaP[10]);
        tabuleiro[7][0].setOcupada(pecaB[9]);
        tabuleiro[7][7].setOcupada(pecaB[10]);
        tabuleiro[0][1].setOcupada(pecaP[11]);
        tabuleiro[0][6].setOcupada(pecaP[12]);
        tabuleiro[7][1].setOcupada(pecaB[11]);
        tabuleiro[7][6].setOcupada(pecaB[12]);
        tabuleiro[0][2].setOcupada(pecaP[13]);
        tabuleiro[0][5].setOcupada(pecaP[14]);
        tabuleiro[7][2].setOcupada(pecaB[13]);
        tabuleiro[7][5].setOcupada(pecaB[14]);
        tabuleiro[0][3].setOcupada(pecaP[15]);
        tabuleiro[7][3].setOcupada(pecaB[15]);
        tabuleiro[0][4].setOcupada(pecaP[16]);
        tabuleiro[7][4].setOcupada(pecaB[16]);

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

    public Casa getCasa(int linha, char coluna) {
        int indiceLinha = linha - 1;
        int indiceColuna = coluna - 'a';

        if (noLimite(linha, coluna)) {
            return tabuleiro[indiceLinha][indiceColuna];
        }
        return null;
    }

    public boolean noLimite(int linha, char coluna) {
        return linha >= 1 && linha <= 8 && coluna >= 'a' && coluna <= 'h';
    }

}
