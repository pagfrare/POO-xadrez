package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

public abstract class Peca {

    // B para branco e P para preto
    protected char cor;
    //false para não capturada e true para capturada
    protected boolean capturada;

    public Peca(char cor) {
        this.cor = cor;
        capturada = false;
    }

    protected abstract String desenho();

    protected abstract boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD);

    protected abstract String caminho(int linhaO, char colunaO, int linhaD, char colunaD);

    public char getCor(){
        return cor;
    }
    public boolean capturada(){
        return capturada;
    }

}
