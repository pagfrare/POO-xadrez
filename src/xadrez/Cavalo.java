package xadrez;

/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
 */
public class Cavalo extends Peca {
    @Override
    public String desenho() {
        if(cor == 'P')
            return "C";
        return "c";
    }
    
    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if(linhaO == linhaD && colunaO == colunaD)
           return false;
        return true;
    }
    
    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = "";
        return caminho;
    }
    
}
