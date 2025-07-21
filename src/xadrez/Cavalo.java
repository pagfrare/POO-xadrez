package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro
 * Augusto(834765), João Henrique(822428))
 */
public class Cavalo extends Peca {

    public Cavalo(char cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if (cor == 'P') {
            return "C";
        }
        return "c";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (linhaO == linhaD && colunaO == colunaD) {
            return false;
        }
        int diferencaLinha = linhaO - linhaD;
        int diferencaColuna = colunaO - colunaD;
        if (diferencaLinha < 0) {
            diferencaLinha = -diferencaLinha;
        }
        if (diferencaColuna < 0) {
            diferencaColuna = -diferencaColuna;
        }

        if (diferencaLinha == 2 && diferencaColuna == 1) {
            return true;
        }
        if (diferencaLinha == 1 && diferencaColuna == 2) {
            return true;
        }

        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = "";
        if (linhaO < linhaD) {
            if (colunaO < colunaD) {
                if (linhaO - linhaD == -2) {
                    for (int i = linhaO; i <= linhaD; i++) {
                        caminho += Integer.toString(i) + colunaO;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                } else {
                    for (char i = colunaO; i <= colunaD; i++) {
                        caminho += Integer.toString(linhaO) + i;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                }
            } else {
                if (linhaO - linhaD == -2) {
                    for (int i = linhaO; i <= linhaD; i++) {
                        caminho += Integer.toString(i) + colunaO;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                } else {
                    for (char i = colunaO; i >= colunaD; i--) {
                        caminho += Integer.toString(linhaO) + i;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                }
            }
        } else {
            if (colunaO < colunaD) {
                if (linhaO - linhaD == 2) {
                    for (int i = linhaO; i >= linhaD; i--) {
                        caminho += Integer.toString(i) + colunaO;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                } else {
                    for (char i = colunaO; i <= colunaD; i++) {
                        caminho += Integer.toString(linhaO) + i;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                }
            } else {
                if (linhaO - linhaD == 2) {
                    for (int i = linhaO; i >= linhaD; i--) {
                        caminho += Integer.toString(i) + colunaO;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                } else {
                    for (char i = colunaO; i >= colunaD; i--) {
                        caminho += Integer.toString(linhaO) + i;
                    }
                    caminho += Integer.toString(linhaD) + colunaD;
                }
            }
        }
        return caminho;
    }
}
