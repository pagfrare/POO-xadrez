package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro
 * Augusto(834765), João Henrique(822428))
 */
public class Bispo extends Peca {

    public Bispo(char cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if (cor == 'P') {
            return "B";
        }
        return "b";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (linhaO == linhaD && colunaO == colunaD) {
            return false;
        }

        int diferencaLinha;
        int diferencaColuna;

        if (colunaO > colunaD) {
            diferencaColuna = colunaO - colunaD;
        } else {
            diferencaColuna = colunaD - colunaO;
        }
        if (linhaO > linhaD) {
            diferencaLinha = linhaO - linhaD;
        } else {
            diferencaLinha = linhaD - linhaO;
        }

        if (diferencaLinha == diferencaColuna) {
            return true;
        }

        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = "";
        int linha = linhaO;
        char coluna = colunaO;
        if (linhaO < linhaD) {
            if (colunaO < colunaD) {
                while (linha <= linhaD) {
                    caminho += Integer.toString(linha);
                    caminho += coluna;
                    linha++;
                    coluna++;
                }
            } else {
                while (linha <= linhaD) {
                    caminho += Integer.toString(linha);
                    caminho += coluna;
                    linha++;
                    coluna--;
                }
            }

        } else {
            if (colunaO < colunaD) {
                while (linha >= linhaD) {
                    caminho += Integer.toString(linha);
                    caminho += coluna;
                    linha--;
                    coluna++;
                }
            } else {
                while (linha >= linhaD) {
                    caminho += Integer.toString(linha);
                    caminho += coluna;
                    linha--;
                    coluna--;
                }
            }

        }

        return caminho;

    }
}
