package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

public class Jogada {
    private int linhaO,linhaD;
    private char colunaO, colunaD;
    private Caminho caminho;
    private Jogador jogador;
    public Jogada(){
    }
    public boolean ehValida(){
        if(linhaO <= 8)
        if(caminho.casaFinal().estaOcupada()){
            if(caminho.casaFinal().getPeca().getCor() == jogador.getCor()){
                return false;
            }
        }
        return true;
    }
    public boolean ehXeque(){
        return true;
    }
    public boolean ehXequeMate(){
        return true;
    }
}
