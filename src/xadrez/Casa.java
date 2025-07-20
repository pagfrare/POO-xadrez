package xadrez;

/**
 *
 * @author Felipe Ferreira Barros
 */
public class Casa {
    private char cor;
    private int linha;
    private char coluna;
    private Peca ocupada;
    
    public Casa(char cor, int linha, char coluna) {
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
    
    public char getColuna() {
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
