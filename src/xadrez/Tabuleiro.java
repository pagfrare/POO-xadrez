package xadrez;

/**
 *
 * @author Felipe Ferreira Barros
 */
public class Tabuleiro {
    private int linha;
    private int coluna;
    private Casa[][] tabuleiro;
    
    
    //Inicializa o tabuleiro com as casas
    public Tabuleiro(){
        tabuleiro = new Casa[8][8];
        for(int linha = 0; linha < 8; linha++) {
            for(int coluna = 0; coluna < 8; coluna++) {
                char cor = ((linha+coluna) % 2 == 0) ? 'B' : 'P';
                tabuleiro[linha][coluna] = new Casa(cor, linha, coluna);
            }
        }
    }
    
    
    //Desenha o tabuleiro na tela
    public String desenho() {
        String resultado = "";
        for(int linha = 0; linha < 8; linha++) {
            resultado += "|";
            for(int coluna = 0; coluna < 8; coluna++) {
                resultado += tabuleiro[linha][coluna].getCor() + "|";
            }
            resultado += "\n";
        }
        return resultado;
    }
    
    public boolean noLimite(int linha, int coluna) {
        
    }
    
    
    
    
    
    
    
}
