package xadrez;

/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
 */
public class Rei extends Peca {
    @Override
    public String desenho() {
        if(cor == 'P')
            return "R";
        return "r";
    }
    
    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
       if(linhaO == linhaD && colunaO == colunaD)
           return false;
        int linha = linhaO - linhaD;
        int coluna = colunaO - colunaD;
        if(coluna < 0)
            coluna = -coluna;
        if (linha < 0)
            linha = -linha;
        
        if(linha <= 1 && coluna <= 1)
            return true;
        
        return false;
    }
 
    
    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        String caminho = Integer.toString(linhaO) + colunaO + Integer.toString(linhaD) + colunaD;
        return caminho;
    }
    
}
