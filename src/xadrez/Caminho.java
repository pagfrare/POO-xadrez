package xadrez;

/**
 *
 * @author G1 (Felipe Ferreira(834688), Felipe da Rocha(834732), Pedro Augusto(834765), João Henrique(822428))
 *
 */

import java.util.ArrayList;

public class Caminho {
    private ArrayList<Casa> sequencia;
    
    
    public Caminho(ArrayList<Casa> sequencia) {
        this.sequencia = sequencia;
    }
    
    
    public boolean estaLivre() {
        if(sequencia == null || sequencia.size() <= 2) {
            return true;
        }
        
        for(int i = 1;i<sequencia.size() - 1; i++) {
            Casa casa = sequencia.get(i);
            if(casa.getOcupada() != null) {
                return false;
            }
        }
        return true;
    }
    
    public Casa casaInicial() {
        if(sequencia != null && !sequencia.isEmpty()) {
            return sequencia.get(0);
        }
        return null;
    }
    
    public Casa casaFinal() {
        if(sequencia!=null&&!sequencia.isEmpty()) {
            return sequencia.get(sequencia.size() - 1);
        }
        return null;
    }
    
    public ArrayList<Casa> getSequencia(){
        return sequencia;
    }
    
    public void setSequencia(ArrayList<Casa> sequencia) {
        this.sequencia = sequencia;
    }
    
}
