package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Gerenciador {
    public static void main(String[] args) {
        /* Teste do cavalo:
        Cavalo c = new Cavalo('P');
        Caminho:
        System.out.println(c.caminho(4, 'e', 6, 'f'));
        System.out.println(c.caminho(4, 'e', 6, 'd'));
        System.out.println(c.caminho(4, 'e', 2, 'f'));
        System.out.println(c.caminho(4, 'e', 2, 'd'));
        System.out.println(c.caminho(4, 'e', 5, 'g'));
        System.out.println(c.caminho(4, 'e', 5, 'c'));
        System.out.println(c.caminho(4, 'e', 3, 'g'));
        System.out.println(c.caminho(4, 'e', 3, 'c'));
        */
    }
    private static boolean criarSave(String nome, File save){
        for(int i = 1;i <= 10; i++){
            try{
                if(i == 1){ //tenta criar o arquivo com o nome pedido
                    save = new File(nome + ".txt");
                }else{ // se esse arquivo já existir, salva como nome(i)
                    save = new File(nome + "("+i+")"  + ".txt");
                }            
                if(save.createNewFile()){
                    return true;
                }
            }catch(IOException e){
                return false;
            }
        }
        return false;
    }
    private static boolean lerSave(String nome, File lerSave, Scanner leitor){
        try{
            lerSave = new File(nome + ".txt");
            leitor = new Scanner(lerSave);
            while(leitor.hasNextLine()){
                
            }
        }catch(FileNotFoundException e){
            return false;
        }
        return true;
    }
    private static double getDouble(Scanner ler){
        double temp = 0;
        boolean valido;
        do{
            try{
                valido = true;
                temp = ler.nextDouble();
                limparBuffer(ler);
            }catch(InputMismatchException e){
                valido = false;
                System.out.println("Digite um numero valido");
                limparBuffer(ler);
            }
        }while(!valido);
        return temp;
    }
    private static int getInt(Scanner ler){
        int temp = 0;
        boolean valido;
        do{
            try{
                valido = true;
                temp = ler.nextInt();
                limparBuffer(ler);
            }catch(InputMismatchException e){
                valido = false;
                System.out.println("Digite um numero valido");
                limparBuffer(ler);
            }
        }while(!valido);
        return temp;
    }
    private static void limparBuffer(Scanner ler){
        ler.nextLine(); //Sempre que usar um ler.next que não consome \n, limpar o buffer de 
                        //entrada impede leituras inesperadas. tambem serve pra limpar o buffer em caso de exception
    }
}
