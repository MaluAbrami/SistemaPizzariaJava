package sistemapizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pizzaria {
    private List<DiaTrabalho> diasDeTrabalho;

    public Pizzaria() {
        this.diasDeTrabalho = new ArrayList();
    }

    public List<DiaTrabalho> getDiasDeTrabalho() {
        return diasDeTrabalho;
    }

    public void setDiasDeTrabalho(List<DiaTrabalho> diasDeTrabalho) {
        this.diasDeTrabalho = diasDeTrabalho;
    }
    
    public void adicionarDiaTrabalho(DiaTrabalho d){
        diasDeTrabalho.add(d);
    }
    
}
