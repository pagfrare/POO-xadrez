package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador[] jogadores = new Jogador[2];
    private Peca[] pecasP = new Peca[16];
    private Peca[] pecasB = new Peca[16];
    private int turno;
    private Scanner ler;
    private int estado = 0; //0 normal, 1 xeque, 2 xequeMate
    private Jogada[] jogadas = new Jogada[1000]; //1000 é um limite muito superior a quantidade de jogadas medias de uma partida de xadrez
    public Jogo(Scanner l){
        for(int i = 0; i < 16; i++){
            if (i < 8){
                pecasP[i] = new Peao('P');
                pecasB[i] = new Peao('B');
            } else if (i < 10){
                pecasP[i] = new Torre('P');
                pecasB[i] = new Torre('B');
            }else if (i < 12){
                pecasP[i] = new Cavalo('P');
                pecasB[i] = new Cavalo('B');
            }else if (i < 14){
                pecasP[i] = new Bispo('P');
                pecasB[i] = new Bispo('B');
            } else if (i == 14){
                pecasP[i] = new Dama('P');
                pecasB[i] = new Dama('B');
            }else{
                pecasP[i] = new Rei('P');
                pecasB[i] = new Rei('B');
            }
        }  
        ler = l;
    }
    public boolean jogar(){
        String temp;
        boolean xeque = false;
        for(turno = 0; turno <10000; turno++){
            System.out.println(tabuleiro.desenho());
            boolean valido;
            do {
                temp = jogadores[turno % 2].informaJogada();

                //transforma a string em algo facimente usado
                int lo = Character.getNumericValue(temp.charAt(0));
                char co = temp.charAt(1);
                int ld = Character.getNumericValue(temp.charAt(2));
                char cd = temp.charAt(3);
                
                jogadas[turno] = new Jogada(lo, co, ld, cd, jogadores[turno % 2], tabuleiro);
                valido = jogadaValida(lo, co, ld, cd);
            } while (!valido);
            //muda o estado com base se for xeque ou mate
            if(jogadas[turno].ehXeque()){
                estado = 1;
            }else if(jogadas[turno].ehXequeMate()){
                estado = 2;
            }
                
            //decide o que fazer dependendo do estado e se continua em xeque(virou xeque mate sem defesa)    
            if(estado == 0){
                xeque = false;
            }else if (xeque = true){
                estado = 2;
                break;
            }else if(estado == 1){
                xeque = true;
            }else if(estado == 2){
                break;
            }
        }
        return true;
    }
    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD){
        //validação da jogada
         
        /* incluir verificação aqui e retornar falso caso inválido*/
         
        //realiza a jogada
        realizarJogada(linhaO,colunaO,linhaD,colunaD);
        return true;
    }
    public void realizarJogada(int linhaO, char colunaO, int linhaD, char colunaD){
        
    }
    public String registroJogo(){
        String temp;
        temp = jogadores[0].getNome() + " - Peca brancas" +"\n" + jogadores[1].getNome() + " - Pecas pretas";
        for(int i = 0; i < turno; i++){
            temp += "\n" + jogadas[i].getJogada();
        }
        return temp; //Retorno uma String no formato "nome-cor\nnome-cor\njogada1\njogada2\n...jogadax\n
    }
}
