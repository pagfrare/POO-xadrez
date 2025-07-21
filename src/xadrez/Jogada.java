package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro
 * Augusto(834765), João Henrique(822428))
 *
 */
public class Jogada {

    private int linhaO, linhaD;
    private char colunaO, colunaD;
    private Caminho caminho;
    private Jogador jogador;
    private Tabuleiro tabuleiro; //Pra jogada "conhecer" o tabuleiro

    public Jogada(int lo, char co, int ld, char cd, Jogador j, Tabuleiro t) {
        linhaO = lo;
        linhaD = ld;
        colunaO = co;
        colunaD = cd;
        jogador = j;
        tabuleiro = t;
        caminho = new Caminho(tabuleiro, tabuleiro.getCasa(lo, co).getPeca().caminho(linhaO, colunaO, linhaD, colunaD));
    }

    public boolean ehValida() {
        if (!tabuleiro.noLimite(linhaO, colunaO)) {
            return false;
        }
        if (!tabuleiro.noLimite(linhaD, colunaD)) {
            return false;
        }
        if (!caminho.casaInicial().estaOcupada()) {
            return false;
        }
        if (caminho.casaInicial().getPeca().getCor() != jogador.getCor()) {
            return false;
        }
        if (caminho.casaFinal().estaOcupada()) {
            if (caminho.casaFinal().getPeca().getCor() == jogador.getCor()) {
                return false;
            }
        }
        if (!tabuleiro.getCasa(linhaO, colunaO).getPeca().desenho().toLowerCase().equals("c")) {
            if (!caminho.estaLivre()) {
                return false;
            }
        }
        if (!tabuleiro.getCasa(linhaO, colunaO).getPeca().movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return false;
        }
        return true;
    }

    public boolean ehXeque() {
        Casa casaRei = null;
        char corRei = jogador.getCor();

        for (int i = 1; i <= 8; i++) {
            for (char j = 'a'; j <= 'h'; j++) {
                Casa casaAtual = tabuleiro.getCasa(i, j);
                if (casaAtual != null && casaAtual.estaOcupada()
                        && casaAtual.getPeca().getCor() == corRei
                        && casaAtual.getPeca().desenho().equalsIgnoreCase("r")) {
                    casaRei = casaAtual;
                    break;
                }
            }
            if (casaRei != null) {
                break;
            }
        }

        if (casaRei == null) {
            return false;
        }

        int linhaRei = casaRei.getLinha();
        char colunaRei = casaRei.getColuna();

        char corOponente = (corRei == 'B') ? 'P' : 'B';

        for (int i = 1; i <= 8; i++) {
            for (char j = 'a'; j <= 'h'; j++) {
                Casa casaOponente = tabuleiro.getCasa(i, j);
                if (casaOponente != null && casaOponente.estaOcupada()
                        && casaOponente.getPeca().getCor() == corOponente) {

                    Peca pecaOponente = casaOponente.getPeca();

                    if (pecaOponente.movimentoValido(casaOponente.getLinha(), casaOponente.getColuna(), linhaRei, colunaRei)) {
                        if (!pecaOponente.desenho().toLowerCase().equals("c")) {
                            Caminho caminhoAtaque = new Caminho(tabuleiro, pecaOponente.caminho(casaOponente.getLinha(), casaOponente.getColuna(), linhaRei, colunaRei));
                            if (!caminhoAtaque.estaLivre()) {
                                continue;
                            }
                        }
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean ehXequeMate() {
        if (!ehXeque()) {
            return false;
        }

        char corRei = jogador.getCor();

        Casa casaRei = null;
        for (int i = 1; i <= 8; i++) {
            for (char j = 'a'; j <= 'h'; j++) {
                Casa c = tabuleiro.getCasa(i, j);
                if (c != null && c.estaOcupada() && c.getPeca().getCor() == corRei && c.getPeca().desenho().equalsIgnoreCase("r")) {
                    casaRei = c;
                    break;
                }
            }
            if (casaRei != null) {
                break;
            }
        }

        if (casaRei == null) {
            return true;
        }

        int linhaRei = casaRei.getLinha();
        char colunaRei = casaRei.getColuna();
        Peca pecaRei = casaRei.getPeca();

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int novaLinhaRei = linhaRei + dr[i];
            char novaColunaRei = (char) (colunaRei + dc[i]);

            if (tabuleiro.noLimite(novaLinhaRei, novaColunaRei)) {
                Casa casaDestinoRei = tabuleiro.getCasa(novaLinhaRei, novaColunaRei);
                Peca pecaNaDestinoOriginal = casaDestinoRei.getPeca();

                if (pecaNaDestinoOriginal != null && pecaNaDestinoOriginal.getCor() == corRei) {
                    continue;
                }

                casaDestinoRei.setOcupada(pecaRei);
                casaRei.setOcupada(null);

                if (!this.ehXeque()) {
                    casaRei.setOcupada(pecaRei);
                    casaDestinoRei.setOcupada(pecaNaDestinoOriginal);
                    return false;
                }

                casaRei.setOcupada(pecaRei);
                casaDestinoRei.setOcupada(pecaNaDestinoOriginal);
            }
        }

        for (int lOrigem = 1; lOrigem <= 8; lOrigem++) {
            for (char cOrigem = 'a'; cOrigem <= 'h'; cOrigem++) {
                Casa casaOrigem = tabuleiro.getCasa(lOrigem, cOrigem);

                if (casaOrigem != null && casaOrigem.estaOcupada() && casaOrigem.getPeca().getCor() == corRei) {
                    Peca pecaAtual = casaOrigem.getPeca();

                    for (int lDestino = 1; lDestino <= 8; lDestino++) {
                        for (char cDestino = 'a'; cDestino <= 'h'; cDestino++) {

                            Jogada jogadaPotencial = new Jogada(lOrigem, cOrigem, lDestino, cDestino, this.jogador, tabuleiro);

                            if (jogadaPotencial.ehValida() && !pecaAtual.desenho().equalsIgnoreCase("r")) {
                                Casa casaDestino = tabuleiro.getCasa(lDestino, cDestino);
                                Peca pecaCapturada = casaDestino.getPeca();

                                casaDestino.setOcupada(pecaAtual);
                                casaOrigem.setOcupada(null);

                                if (!this.ehXeque()) {
                                    casaOrigem.setOcupada(pecaAtual);
                                    casaDestino.setOcupada(pecaCapturada);
                                    return false;
                                }

                                casaOrigem.setOcupada(pecaAtual);
                                casaDestino.setOcupada(pecaCapturada);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public String getJogada() {
        return linhaO + colunaO + linhaD + colunaD + "";
    }
}
