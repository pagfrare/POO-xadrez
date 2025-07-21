package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */
import java.util.Scanner;
public class Jogador {
    private final String nome;
    private final char cor;
    private Peca[] pecas = new Peca[16];
    private Scanner ler;
    
    public Jogador(String nome, char cor, Peca[] p, Scanner l){
        ler = l;
        this.nome = nome;
        this.cor = cor;
        for(int i = 0; i < 16; i++){
            pecas = p;
        }
    }
    public String informaJogada(){
        String temp;
        System.out.println("Digite sua jogada no formato (1a2b) ou \"parar\" para encerrar o jogo");
        temp = ler.nextLine();
        return temp;
    }
    public String pecasCapturadas(){
        String temp = null;
        for(int i = 0; i < 16; i++){
            if(pecas[i].getCapturada()){
             temp = temp + pecas[i].desenho() + " ";   
            }
        }
        if(temp == null){
            temp = "nenhuma peca foi capturada";
        }
        return temp;
    }
    public String getNome(){
        return nome;
    }
    public char getCor(){
        return cor;
    }
}
