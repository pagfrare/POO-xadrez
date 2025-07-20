package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

public class Caminho {
    private Tabuleiro tabuleiro;
    private String caminho;
    
    
    public Caminho(Tabuleiro tabuleiro, String caminho) {
        this.tabuleiro = tabuleiro;
        this.caminho = caminho;
    }
    
    
    public boolean estaLivre() {
        int tamanho = caminho.length(); 
        int linha;
        char coluna;
        for(int i = 2; i < tamanho-2; i = i + 2) {
            linha = Character.getNumericValue(caminho.charAt(i));
            coluna = caminho.charAt(i + 1);
            Casa c = tabuleiro.getCasa(linha, coluna);
            if(c.getOcupada() != null) {
                return false;
            }
        }
        return true;
    }
    
    public Casa casaInicial() {
        int linha = Character.getNumericValue(caminho.charAt(0));
        char coluna = caminho.charAt(1);
        
        return(tabuleiro.getCasa(linha, coluna));
    }
    
    public Casa casaFinal() {
        int linha = Character.getNumericValue(caminho.charAt(caminho.length() - 1));
        char coluna = caminho.charAt(caminho.length());
        
        return(tabuleiro.getCasa(linha, coluna));
    }
    
}
