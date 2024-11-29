package DaoImpl;

import Dao.PedidoDao;
import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.Pedido;
import sistemapizzaria.Pizza;

public class PedidoDaoImpl implements PedidoDao{
    List<Pedido> pedidos = new ArrayList();
    
    @Override
    public void adicionarPedido(Pedido p){
        pedidos.add(p);
    }
    
    @Override
    public Pedido procurarPedidoPorId(int id){
        for(Pedido p: pedidos){
            if(p.getId() == id)
                return p;
        }
        return null;
    }
    
    @Override
    public void atualizarPedido(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public boolean deletePedido(int id){
        Pedido p = procurarPedidoPorId(id);
        
        if(p != null){
            pedidos.remove(p);
            return true;
        }
        return false;
    }
    
    @Override
    public String listAllPedidos(){
        StringBuilder report = new StringBuilder();
        
        if (pedidos.isEmpty()) {
            return "Nenhum pedido cadastrado.";
        }
        
        for(Pedido p: pedidos){
            report.append("\nPedido de ID: ").append(p.getId()).append("\n")
                .append("Cliente: ").append(p.getCliente().getNome())
                .append("\nPizzas: ");
                for(Pizza pizza: p.getPizzas()){
                    report.append(pizza.getNome()).append(" ; ");
                }
        }
        
        return report.toString();
    }
    
    @Override
    public List<Pedido> procurarPedidoPorClienteCpf(String cpf){ //RELATÓRIO PEDIDO POR CLIENTE
        List<Pedido> pedidosPorCliente = new ArrayList(); 
        
        for(Pedido p: pedidos){
            if(p.getCliente().getCpf().equals(cpf))
                pedidosPorCliente.add(p);
        }
        return pedidosPorCliente;
    }
    
    @Override
    public String listAllPedidosPorCliente(String cpf){
        StringBuilder report = new StringBuilder();
        
        List<Pedido> pedidosCliente = procurarPedidoPorClienteCpf(cpf);
        
        if (pedidosCliente.isEmpty()) {
            return "Nenhum pedido cadastrado.";
        }
        
        for(Pedido p: pedidosCliente){
            report.append("\nID do pedido: ").append(p.getId())
                  .append("Valor do Pedido: ").append(p.getValorPedido())
                .append("\nPizzas do pedido: ");
                for(Pizza pizza: p.getPizzas()){
                    report.append(pizza.getNome()).append(" ; ");
                }
        }
        
        return report.toString();
    }
}
