package xadrez;
/**
 *
 * @author G1 (Felipe(834688), Felipe(834732), Pedro(834765))
 *
 */
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
}
