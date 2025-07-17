package xadrez;

/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
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
        return true;
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
