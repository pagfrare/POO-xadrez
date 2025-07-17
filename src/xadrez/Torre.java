package xadrez;

/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
 */
public class Torre extends Peca {

    public Torre(char cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if (cor == 'P') {
            return "T";
        }
        return "t";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (linhaO == linhaD && colunaO == colunaD) {
            return false;
        }
        if (linhaO != linhaD && colunaO != colunaD) {
            return false;
        }
        return true;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = "";
        int linha = linhaO;
        char coluna = colunaO;
        if (linhaO == linhaD) {
            if (colunaO < colunaD) {
                while (coluna <= colunaD) {
                    caminho += Integer.toString(linha) + coluna;
                    coluna++;
                }
            } else {
                while (coluna >= colunaD) {
                    caminho += Integer.toString(linha) + coluna;
                    coluna--;
                }
            }

        } else {
            if (linhaO < linhaD) {
                while (linha <= linhaD) {
                    caminho += Integer.toString(linha) + coluna;
                    linha++;
                }
            } else {
                while (linha >= linhaD) {
                    caminho += Integer.toString(linha) + coluna;
                    linha--;
                }

            }
        }
        return caminho;
    }

}
