package DaoImpl;

import Dao.DiaTrabalhoDao;
import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pedido;

public class DiaTrabalhoDaoImpl implements DiaTrabalhoDao{
    private List<DiaTrabalho> diasDeTrabalho = new ArrayList();
    
    @Override
    public void adicionarDiaTrabalho(DiaTrabalho d){
        diasDeTrabalho.add(d);
    }
    
    @Override
    public DiaTrabalho procurarDiaTrabalhoPorId(int id){
        for(DiaTrabalho d: diasDeTrabalho){
            if(d.getId() == id)
                return d;
        }
        return null;
    }
    
    @Override
    public void atualizarDiaTrabalho(int id, List<Pedido> pedidos) {
        DiaTrabalho dia = procurarDiaTrabalhoPorId(id);
        
        for(Pedido p: pedidos){
            dia.adicionarPedido(p);
        }
    }
    
    @Override
    public boolean deleteDiaTrabalho(int id){
        DiaTrabalho d = procurarDiaTrabalhoPorId(id);
        
        if(d != null){
            diasDeTrabalho.remove(d);
            return true;
        }
        return false;
    }
    
    @Override
    public String listAllDiasTrabalho(){
    StringBuilder report = new StringBuilder();
    
    // Verifica se a lista está vazia
    if (diasDeTrabalho.isEmpty()) {
        return "Nenhum dia de trabalho cadastrado.";
    }
    
    for (DiaTrabalho d : diasDeTrabalho) {
        report.append("ID: ").append(d.getId())
              .append(", Data: ").append(d.getData())
              .append(", Pedidos: ").append(d.getPedidos().size())
              .append(", Faturamento: R$").append(d.getFaturamento())
              .append("\n");
    }
    
    // Retorna o relatório formatado
    return report.toString();
    }
    
    @Override
    public String listAllPedidosPorDiaTrabalho(int id){
        StringBuilder report = new StringBuilder();
        
        DiaTrabalho dia = procurarDiaTrabalhoPorId(id);

        if (dia == null) {
            return "Dia de trabalho nao existe.";
        }

        report.append("Dia de ID: ").append(dia.getId())
            .append("\nData: ").append(dia.getData())
            .append("\nQuantidade de Pedidos: ").append(dia.getPedidos().size())
            .append("\nPedidos: ").append("\n");
            for(Pedido p: dia.getPedidos()){
                report.append("Pedido ID: ").append(p.getId())
                      .append(", Cliente: ").append(p.getCliente().getNome());
            }
            report.append("\nFaturamento: ").append(dia.getFaturamento());

        return report.toString();
    }
    
    @Override
    public DiaTrabalho procurarDiaTrabalhoPorData(String data){
        if(diasDeTrabalho.isEmpty()){
            System.out.println("Nao existe nenhum dia de trabalho cadastrado");
        }
        
        for(DiaTrabalho dia: diasDeTrabalho){
            if(dia.getData().equals(data))
                return dia;
        }
        
        return null;
    }
    
    @Override 
    public Pedido verificarSePedidoJaExisteEmAlgumDia(int pedidoId){
        for(DiaTrabalho dia: diasDeTrabalho){
            for(Pedido p: dia.getPedidos()){
                if(p.getId() == pedidoId)
                    return p;
            }
        }

        return null;
    }
}
