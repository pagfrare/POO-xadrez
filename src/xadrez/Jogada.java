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
    private Tabuleiro tabuleiro; //Pra jogada "conhecer" o tabuleiro
    public Jogada(int lo,char co,int ld,char cd, Jogador j, Tabuleiro t){
        linhaO = lo;
        linhaD = ld;
        colunaO = co;
        colunaD = cd;
        jogador = j;
        tabuleiro = t;
        caminho = new Caminho(tabuleiro,tabuleiro.getCasa(lo, co).getPeca().caminho(linhaO, colunaO, linhaD, colunaD));
    }
    public boolean ehValida(){
        if(!tabuleiro.noLimite(linhaO, colunaO)){
            return false;
        }
        if(!tabuleiro.noLimite(linhaD, colunaD)){
            return false;
        }
        if(!caminho.casaInicial().estaOcupada()){
            return false;
        }
        if(caminho.casaInicial().getPeca().getCor() != jogador.getCor()){
            return false;
        }
        if(caminho.casaFinal().estaOcupada()){
            if(caminho.casaFinal().getPeca().getCor() == jogador.getCor()){
                return false;
            }
        }
        if(!tabuleiro.getCasa(linhaO,colunaO).getPeca().desenho().toLowerCase().equals("c")){
            if(!caminho.estaLivre()){
                return false;
            }
        }
        if(!tabuleiro.getCasa(linhaO,colunaO).getPeca().movimentoValido(linhaO, colunaO, linhaD, colunaD)){
            return false;
        }
        return true;
    }
    public boolean ehXeque(){
        return true;
    }
    public boolean ehXequeMate(){
        return true;
    }
    public String getJogada(){
        return linhaO + colunaO + linhaD + colunaD + "";
    }
}
