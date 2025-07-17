package xadrez;

/**
 *
 * @author Felipe Ferreira Barros
 */
public class Casa {
    private char cor;
    private int linha;
    private int coluna;
    private Peca ocupada;
    
    public Casa(char cor, int linha, int coluna) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.ocupada = null;
    }
    
    public char getCor(){
        return cor;
    }
    
    public int getLinha() {
        return linha;
    }
    
    public int getColuna() {
        return coluna;
    }

    public Peca getPeca() {
        return ocupada;
    }
    
    public boolean estaOcupada(){
        return this.ocupada!=null;
    }
    
    public void setOcupada(Peca peca){
        this.ocupada = peca;
    }
    
    public Peca getOcupada(){
        return this.ocupada;
    }
}
