package xadrez;

/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
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

    //Será que faz verificação? ou se tem que botar try/catch?
    public void setCor(char cor) {
        this.cor = cor;
    }

}
