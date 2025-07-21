package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro
 * Augusto(834765), João Henrique(822428))
 *
 */
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;

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
        Scanner ler = new Scanner(System.in);
        File save = null;
        int op;
        Jogo jogo = new Jogo(ler);
        while (true) {
            System.out.println("o que deseja fazer?");
            System.out.println("1 - novo jogo\n2 - carregar jogo\n3 - encerrar programa");
            op = getInt(ler);
            int temp;
            switch (op) {
                default:
                    System.out.println("insira uma função valida");
                    break;
                case 1:
                    jogo.criarJogador();
                    jogo.jogar();
                    System.out.println("Deseja salvar o jogo?\n1 - sim\n2- nao");
                    temp = getInt(ler);
                    if (temp == 2) {
                        break;
                    }
                    System.out.println("digite o nome do save");
                    save = criarSave(ler.nextLine(), save);
                    if (save == null) {
                        System.out.println("Erro ao criar o save");
                        break;
                    }
                    salvar(save, jogo.registroJogo());
                    break;
                case 2:
                    System.out.println("digite o nome do save");
                    lerSave(ler.nextLine(), save, jogo);
                    jogo.jogar();
                    System.out.println("Deseja salvar o jogo?\n1 - sim\n2- nao");
                    temp = getInt(ler);
                    if (temp == 2) {
                        break;
                    }
                    System.out.println("digite o nome do save");
                    save = criarSave(ler.nextLine(), save);
                    if (save == null) {
                        System.out.println("Erro ao criar o save");
                        break;
                    }
                    salvar(save, jogo.registroJogo());
                    break;
                case 3:
                    return;
            }
        }

    }

    private static File criarSave(String nome, File save) {
        for (int i = 1; i <= 10; i++) {
            try {
                if (i == 1) { //tenta criar o arquivo com o nome pedido
                    save = new File(nome + ".txt");
                } else { // se esse arquivo já existir, salva como nome(i)
                    save = new File(nome + "(" + i + ")" + ".txt");
                }
                if (save.createNewFile()) {
                    System.out.println("save criado com sucesso");
                    return save;
                }
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o save file");
                return null;
            }
        }
        return null;
    }

    private static boolean lerSave(String nome, File lerSave, Jogo jogo) {
        try {
            lerSave = new File(nome + ".txt");
            Scanner leitor = new Scanner(lerSave);
            jogo.criarJogador(leitor.nextLine().replace(" - Peca brancas", ""), leitor.nextLine().replace(" - Pecas pretas", ""));
            String temp;
            while (leitor.hasNextLine()) {
                temp = leitor.nextLine();
                jogo.realizarJogada(Character.getNumericValue(temp.charAt(0)), temp.charAt(1), Character.getNumericValue(temp.charAt(2)), temp.charAt(3));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nao ha um save com esse nome");
            return false;
        }
        return true;
    }

    private static void salvar(File save, String dados) {
        try {
            FileWriter salvar = new FileWriter(save.getName());
            salvar.write(dados);
            salvar.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar");
        }
    }

    private static int getInt(Scanner ler) {
        int temp = 0;
        boolean valido;
        do {
            try {
                valido = true;
                temp = ler.nextInt();
                limparBuffer(ler);
            } catch (InputMismatchException e) {
                valido = false;
                System.out.println("Digite um numero valido");
                limparBuffer(ler);
            }
        } while (!valido);
        return temp;
    }

    private static void limparBuffer(Scanner ler) {
        ler.nextLine(); //Sempre que usar um ler.next que não consome \n, limpar o buffer de 
        //entrada impede leituras inesperadas. tambem serve pra limpar o buffer em caso de exception
    }

    private void teste() {
        System.out.println("== INÍCIO DOS TESTES ==");

        // Teste: Casa
        System.out.println("\n[TESTE] Casa:");
        Casa casa1 = new Casa('b', 1, 'a');
        System.out.println("Cor esperada: b | Obtida: " + casa1.getCor());
        System.out.println("Linha esperada: 1 | Obtida: " + casa1.getLinha());
        System.out.println("Coluna esperada: a | Obtida: " + casa1.getColuna());
        System.out.println("Está ocupada? (esperado: false) | Obtido: " + casa1.estaOcupada());

        // Teste: Tabuleiro
        System.out.println("\n[TESTE] Tabuleiro:");
        Peca[] pecasPretas = new Peca[16];
        Peca[] pecasBrancas = new Peca[16];

        for (int i = 0; i < 8; i++) {
            pecasPretas[i] = new Peao('P');
            pecasBrancas[i] = new Peao('B');
        }
        pecasPretas[8] = new Torre('P');
        pecasPretas[9] = new Torre('P');
        pecasBrancas[8] = new Torre('B');
        pecasBrancas[9] = new Torre('B');
        pecasPretas[10] = new Cavalo('P');
        pecasPretas[11] = new Cavalo('P');
        pecasBrancas[10] = new Cavalo('B');
        pecasBrancas[11] = new Cavalo('B');
        pecasPretas[12] = new Bispo('P');
        pecasPretas[13] = new Bispo('P');
        pecasBrancas[12] = new Bispo('B');
        pecasBrancas[13] = new Bispo('B');
        pecasPretas[14] = new Dama('P');
        pecasPretas[15] = new Rei('P');
        pecasBrancas[14] = new Dama('B');
        pecasBrancas[15] = new Rei('B');

        Tabuleiro tab = new Tabuleiro(pecasPretas, pecasBrancas);
        System.out.println(tab.desenho());
        System.out.println("Está no limite (1,a)? " + tab.noLimite(1, 'a'));
        System.out.println("Está no limite (9,z)? " + tab.noLimite(9, 'z'));

        // Teste: Jogador
        System.out.println("\n[TESTE] Classe Jogador");

        Scanner scannerTeste = new Scanner("1a2a\n");
        Peca[] pecas = new Peca[16];
        for (int i = 0; i < 16; i++) {
            pecas[i] = new Peao('B');
        }
        Jogador jogador = new Jogador("Ana", 'B', pecas, scannerTeste);

        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Cor: " + jogador.getCor());
        System.out.println("Jogada informada: " + jogador.informaJogada());

        pecas[0].capturar();
        pecas[3].capturar();

        System.out.println("Peças capturadas: " + jogador.pecasCapturadas());

        System.out.println("== FIM DOS TESTES DE JOGADOR ==");

        // Teste: Peão
        System.out.println("\n[TESTE] Peão:");
        Peao peaoBranco = new Peao('B');
        System.out.println("Desenho: " + peaoBranco.desenho());
        System.out.println("Movimento válido (2a → 3a): "
                + peaoBranco.movimentoValido(2, 'a', 3, 'a'));
        System.out.println("Caminho: " + peaoBranco.caminho(2, 'a', 3, 'a'));

        // Teste: Torre
        System.out.println("\n[TESTE] Torre:");
        Torre torre = new Torre('P');
        System.out.println("Desenho: " + torre.desenho());
        System.out.println("Movimento válido (1a → 1h): "
                + torre.movimentoValido(1, 'a', 1, 'h'));
        System.out.println("Caminho: " + torre.caminho(1, 'a', 1, 'h'));

        // Teste: Bispo
        System.out.println("\n[TESTE] Bispo:");
        Bispo bispo = new Bispo('P');
        System.out.println("Desenho: " + bispo.desenho());
        System.out.println("Movimento válido (1c → 3e): "
                + bispo.movimentoValido(1, 'c', 3, 'e'));
        System.out.println("Caminho: " + bispo.caminho(1, 'c', 3, 'e'));

        // Teste: Cavalo
        System.out.println("\n[TESTE] Cavalo:");
        Cavalo cavalo = new Cavalo('B');
        System.out.println("Desenho: " + cavalo.desenho());
        System.out.println("Movimento válido (4b → 5d): "
                + cavalo.movimentoValido(4, 'b', 5, 'd'));
        System.out.println("Caminho: " + cavalo.caminho(4, 'b', 5, 'd'));

        // Teste: Dama
        System.out.println("\n[TESTE] Dama:");
        Dama dama = new Dama('P');
        System.out.println("Desenho: " + dama.desenho());
        System.out.println("Movimento válido (1d → 4g): "
                + dama.movimentoValido(1, 'd', 4, 'g'));
        System.out.println("Caminho: " + dama.caminho(1, 'd', 4, 'g'));

        // Teste: Rei
        System.out.println("\n[TESTE] Rei:");
        Rei rei = new Rei('B');
        System.out.println("Desenho: " + rei.desenho());
        System.out.println("Movimento válido (5e → 6e): "
                + rei.movimentoValido(5, 'e', 6, 'e'));
        System.out.println("Caminho: " + rei.caminho(5, 'e', 6, 'e'));

        // Teste: Jogada
        System.out.println("\n[TESTE] Jogada:");
        Jogada jogada = new Jogada(2, 'a', 3, 'a', jogador, tab);
        System.out.println("Jogada válida? " + jogada.ehValida());
        System.out.println("É xeque? " + jogada.ehXeque());
        System.out.println("É xeque-mate? " + jogada.ehXequeMate());

        // Teste: Caminho
        System.out.println("\n[TESTE] Caminho:");
        Caminho caminho = new Caminho(tab, "1d2d3d3e");
        System.out.println("Casa Inicial: " + caminho.casaInicial());
        System.out.println("Casa Final: " + caminho.casaFinal());
        System.out.println("Está livre? " + caminho.estaLivre());

        //Teste: Jogo
        System.out.println("\n[TESTE] Jogo:");
        Scanner sc = new Scanner(System.in);
        Jogo jogo = new Jogo(sc);
        jogo.criarJogador("Branco", "Preto");

        System.out.println("Teste 1 - Jogada fora do tabuleiro:");
        jogo.realizarJogada(0, 'a', 3, 'a');
        System.out.println("Esperado: false | Obtido: " + jogo.jogadaValida(0, 'a', 3, 'a'));

        System.out.println("Teste 2 - Jogador branco tenta mover peça preta:");
        jogo.realizarJogada(7, 'a', 6, 'a');
        System.out.println("Esperado: false | Obtido: " + jogo.jogadaValida(7, 'a', 6, 'a'));

        System.out.println("Teste 3 - Jogador branco move peão de 2a para 3a:");
        jogo.realizarJogada(2, 'a', 3, 'a');
        System.out.println("Esperado: true | Obtido: " + jogo.jogadaValida(2, 'a', 3, 'a'));
        if (jogo.jogadaValida(2, 'a', 3, 'a')) {
            jogo.realizarJogada(2, 'a', 3, 'a');
            //System.out.println("Tabuleiro após jogada:");
            //System.out.println(jogo.tabuleiro.desenho());
        }

        System.out.println("Histórico do jogo:");
        System.out.println(jogo.registroJogo());
    }
}
