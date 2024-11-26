package Dao;

import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.Pedido;
import sistemapizzaria.Pizza;

public class DaoPedido {
    List<Pedido> pedidos = new ArrayList();
    
    public void adicionarPedido(Pedido p){
        pedidos.add(p);
    }
    
    public Pedido procurarPorId(int id){
        for(Pedido p: pedidos){
            if(p.getId() == id)
                return p;
        }
        return null;
    }
    
    public void atualizarPedido(){
        
    }
    
    public boolean delete(Pedido p){
        Pedido p_aux = procurarPorId(p.getId());
        
        if(p_aux != null){
            pedidos.remove(p_aux);
            return true;
        }
        return false;
    }
    
    public String listAll(){
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
    
    public String listAllPorCliente(int id){
        StringBuilder report = new StringBuilder();
        
        List<Pedido> pedidosCliente = procurarPedidoPorClienteId(id);
        
        if (pedidosCliente.isEmpty()) {
            return "Nenhum pedido cadastrado.";
        }
        
        for(Pedido p: pedidosCliente){
            report.append("\nPedido de ID: ").append(p.getId())
                .append("\nPizzas: ");
                for(Pizza pizza: p.getPizzas()){
                    report.append(pizza.getNome()).append(" ; ");
                }
        }
        
        return report.toString();
    }
    
    public List<Pedido> procurarPedidoPorClienteId(int id){ //RELATÓRIO PEDIDO POR CLIENTE
        List<Pedido> pedidosPorCliente = new ArrayList(); 
        
        for(Pedido p: pedidos){
            if(p.getCliente().getId() == id)
                pedidosPorCliente.add(p);
        }
        return pedidosPorCliente;
    }
}
