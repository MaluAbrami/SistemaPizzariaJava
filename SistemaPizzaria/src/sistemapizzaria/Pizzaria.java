package sistemapizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pizzaria {
    private List<DiaTrabalho> diasDeTrabalho;
    private double faturamentoDaPizzaria;

    public Pizzaria() {
        this.diasDeTrabalho = new ArrayList();
    }

    public List<DiaTrabalho> getDiasDeTrabalho() {
        return diasDeTrabalho;
    }

    public void setDiasDeTrabalho(List<DiaTrabalho> diasDeTrabalho) {
        this.diasDeTrabalho = diasDeTrabalho;
    }

    public double getFaturamentoTotal() {
        return faturamentoDaPizzaria;
    }

    public void setFaturamentoTotal(double faturamentoTotal) {
        this.faturamentoDaPizzaria = faturamentoTotal;
    }
    
    public void adicionarDiaTrabalho(DiaTrabalho d){
        diasDeTrabalho.add(d);
        faturamentoDaPizzaria += d.getFaturamento();
    }
    
}
