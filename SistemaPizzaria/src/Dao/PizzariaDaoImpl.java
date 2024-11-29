package Dao;

import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pedido;
import sistemapizzaria.Pizzaria;

public class PizzariaDaoImpl implements PizzariaDao{
    private List<DiaTrabalho> diasTrabalhados = new ArrayList(); 

    @Override
    public void adicionarPizzaria(Pizzaria p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizarPizzaria(Pizzaria p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adicionarDiaTrabalho(DiaTrabalho d) {
        diasTrabalhados.add(d);
    }
    
    @Override
    public String obterRelatorioDiasTrabalhados() {
        StringBuilder report = new StringBuilder();
        double faturamentoTotal = 0;
        
        if(diasTrabalhados.isEmpty())
            System.out.println("Nao existe nenhum dia de trabalho");
        
        for(DiaTrabalho d: diasTrabalhados){
            report.append("\nID do dia: ").append(d.getId())
                    .append("\nData: ").append(d.getData())
                    .append("\n\tPedidos do dia:");
                    for(Pedido p: d.getPedidos()){
                        report.append("\n\nID do pedido: ").append(p.getId())
                                .append("\nDono do Pedido: ").append(p.getCliente().getNome())
                                .append("\nValor do Pedido: ").append(p.getValorPedido());
                        faturamentoTotal += p.getValorPedido();
                    }
                    report.append("\n\tFaturamento total da Pizzaria: ").append(faturamentoTotal);
                    
        }
        
        return report.toString();
    }
    
}
