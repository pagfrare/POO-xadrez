package xadrez;

/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
 */
//Devia ser Rainha com todo o devido Respeito
public class Dama extends Peca {

    public Dama(char cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if (cor == 'P') {
            return "D";
        }
        return "d";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (linhaO == linhaD && colunaO == colunaD) {
            return false;
        }

        if (linhaO == linhaD || colunaO == colunaD) {
            return true;
        } else {
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
        }

        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = "";
        int linha = linhaO;
        char coluna = colunaO;

        //Movimento na horizontal
        if (linhaO == linhaD) {
            if (colunaO < colunaD) {
                while (coluna <= colunaD) {
                    caminho += Integer.toString(linhaO) + coluna;
                    coluna++;
                }
            } else {
                while (coluna >= colunaD) {
                    caminho += Integer.toString(linhaO) + coluna;
                    coluna--;
                }
            }

        }
        //movimento na vertical
        if (colunaO == colunaD) {
            if (linhaO < linhaD) {
                while (linha <= linhaD) {
                    caminho += Integer.toString(linha) + colunaO;
                    linha++;
                }
            } else {
                while (linha >= linhaD) {
                    caminho += Integer.toString(linha) + colunaO;
                    linha--;
                }
            }

        }

        //movimento na diagonal
        if (colunaO < colunaD) {
            if (linhaO < linhaD) {
                while (linha <= linhaD) {
                    caminho += Integer.toString(linha) + coluna;
                    linha++;
                    coluna++;
                }
            } else {
                while (linha >= linhaD) {
                    caminho += Integer.toString(linha) + coluna;
                    linha--;
                    coluna++;
                }

            }

        } else {
            if (linhaO < linhaD) {
                while (linha <= linhaD) {
                    caminho += Integer.toString(linha) + coluna;
                    linha++;
                    coluna--;
                }
            } else {
                while (linha >= linhaD) {
                    caminho += Integer.toString(linha) + coluna;
                    linha--;
                    coluna--;
                }

            }

        }

        return caminho;
    }

}
