package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

public class Jogo {
    private String historico;
    private Tabuleiro tabuleiro;
    private Jogador[] jogadores = new Jogador[2];
    private Peca[] pecasP = new Peca[16];
    private Peca[] pecasB = new Peca[16];
    private int turno;
    private Jogada[] jogadas = new Jogada[100];
    public Jogo(){
        
    }
    public boolean jogar(){
    
    
    
    
        return true;
    }
    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD){
        //validação da jogada
         
        /* incluir verificação aqui e retornar falso caso inválido*/
         
        //realiza a jogada
        realizarJogada(linhaO,colunaO,linhaD,colunaD);
        //registro da jogada
        registrarJogada(linhaO,colunaO,linhaD,colunaD);
        return true;
    }
    public void realizarJogada(int linhaO, char colunaO, int linhaD, char colunaD){
        
    }
    public String registroJogo(){
        return historico; //Retorno uma String no formato "nome-cor\nnome-cor\njogada1\njogada2\n...jogadax\n
    }
    private void registrarJogada(int linhaO, char colunaO, int linhaD, char colunaD){
        historico = historico+"\n"+linhaO+colunaO+linhaD+colunaD; //Byte usado ao invés de int para economizar espaço
    }
}
