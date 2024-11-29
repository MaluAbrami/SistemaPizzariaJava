package Dao;

import java.util.List;
import sistemapizzaria.Cliente;
import sistemapizzaria.Pedido;
import sistemapizzaria.Pizza;

public interface PedidoDao {
    void adicionarPedido(Pedido p);
    Pedido procurarPedidoPorId(int id);
    void atualizarPedido(int id, Cliente cliente, List<Pizza> pizzas);
    boolean deletePedido(int id);
    String listAllPedidos();
    List<Pedido> procurarPedidoPorClienteCpf(String cpf);
}
