package Dao;

import java.util.List;
import sistemapizzaria.Pedido;

public interface PedidoDao {
    void adicionarPedido(Pedido p);
    Pedido procurarPedidoPorId(int id);
    void atualizarPedido(Pedido p);
    boolean deletePedido(int id);
    String listAllPedidos();
    List<Pedido> procurarPedidoPorClienteCpf(String cpf);
    String listAllPedidosPorCliente(String cpf);
}
