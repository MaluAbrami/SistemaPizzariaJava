package DaoImpl;

import Dao.PizzariaDao;
import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pedido;
import sistemapizzaria.Pizzaria;

public class PizzariaDaoImpl implements PizzariaDao{
    private Pizzaria pizzaria;
    private List<DiaTrabalho> diasTrabalhados = new ArrayList(); 

    @Override
    public void adicionarPizzaria(Pizzaria p) {
        pizzaria = p;
    }

    @Override
    public void atualizarPizzaria(DiaTrabalho d) {
        for (DiaTrabalho dia : diasTrabalhados) {
            if (dia.getId() == d.getId()) {
                diasTrabalhados.remove(dia);
                adicionarDiaTrabalho(d);
            }
        }
    }

    @Override
    public void adicionarDiaTrabalho(DiaTrabalho d) {
        diasTrabalhados.add(d);
    }
    
    @Override
    public void deletarDiaTrabalho(DiaTrabalho d) {
        diasTrabalhados.remove(d);
    }
    
    @Override
    public String obterRelatorioDiasTrabalhados() {
        StringBuilder report = new StringBuilder();
        double faturamentoTotal = 0;
        
        if(diasTrabalhados.isEmpty())
            System.out.println("Nao existe nenhum dia de trabalho");
        
        for(DiaTrabalho d: diasTrabalhados){
            report.append("\n\nID do dia: ").append(d.getId())
                    .append("; Data: ").append(d.getData())
                    .append("\n\tPedidos do dia:");
                    for(Pedido p: d.getPedidos()){
                        report.append("\nID do pedido: ").append(p.getId())
                                .append("; Dono do Pedido: ").append(p.getCliente().getNome())
                                .append("; Valor do Pedido: ").append(p.getValorPedido());
                        faturamentoTotal += p.getValorPedido();
                    }          
        }
        report.append("\nFaturamento total da Pizzaria: ").append(faturamentoTotal);
        
        return report.toString();
    }
}
