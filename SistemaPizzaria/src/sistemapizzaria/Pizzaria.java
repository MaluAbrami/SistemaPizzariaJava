package sistemapizzaria;

import java.util.List;

public class Pizzaria {
    private List<DiaTrabalho> diasDeTrabalho;
    private double faturamentoTotal;

    public Pizzaria(List<DiaTrabalho> diasDeTrabalho, double faturamentoTotal) {
        this.diasDeTrabalho = diasDeTrabalho;
        this.faturamentoTotal = faturamentoTotal;
    }

    public List<DiaTrabalho> getDiasDeTrabalho() {
        return diasDeTrabalho;
    }

    public void setDiasDeTrabalho(List<DiaTrabalho> diasDeTrabalho) {
        this.diasDeTrabalho = diasDeTrabalho;
    }

    public double getFaturamentoTotal() {
        return faturamentoTotal;
    }

    public void setFaturamentoTotal(double faturamentoTotal) {
        this.faturamentoTotal = faturamentoTotal;
    }
    
}
