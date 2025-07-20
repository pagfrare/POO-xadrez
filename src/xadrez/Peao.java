package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

public class Peao extends Peca {

    public Peao(char cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if (cor == 'P') {
            return "P";
        }
        return "p";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (linhaO == linhaD && colunaO == colunaD) {
            return false;
        }

        int diferencaColuna = colunaO - colunaD;
        int diferencaLinha = linhaO - linhaD;

        if (cor == 'B' && diferencaLinha < 0) {
            return false;
        }
        if (cor == 'P' && diferencaLinha > 0) {
            return false;
        }

        if (diferencaLinha < 0) {
            diferencaLinha = -diferencaLinha;
        }
        if (diferencaColuna < 0) {
            diferencaColuna = -diferencaColuna;
        }

        if (diferencaColuna > 1) {
            return false;
        }

        if (diferencaLinha > 2) {
            return false;
        }

        if (diferencaLinha == 2) {
            if (cor == 'B' && linhaO == 2 && diferencaColuna == 0) {
                return true;
            }
            if (cor == 'P' && linhaO == 7 && diferencaColuna == 0) {
                return true;
            }
        }

        if (diferencaLinha == 1) {
            return true;
        }

        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = "";
        
        if(cor == 'P') {
            if (colunaO == colunaD) {
            for (int i = linhaO; i >= linhaD; i--) {
                caminho += Integer.toString(i) + colunaO;
            }
        } else {
            caminho += Integer.toString(linhaO) + colunaO + Integer.toString(linhaD) + colunaD;
        }
        } else {
            if (colunaO == colunaD) {
            for (int i = linhaO; i <= linhaD; i++) {
                caminho += Integer.toString(i) + colunaO;
            }
        } else {
            caminho += Integer.toString(linhaO) + colunaO + Integer.toString(linhaD) + colunaD;
        }
        }

        

        return caminho;
    }

}
