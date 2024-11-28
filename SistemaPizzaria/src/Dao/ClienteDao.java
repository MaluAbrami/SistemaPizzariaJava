package Dao;

import sistemapizzaria.Cliente;

public interface ClienteDao {
    void adicionarCliente(Cliente cliente);
    Cliente procurarClientePorId(int id);
    void atualizarCliente(Cliente cliente);
    boolean deleteCliente(int id);
    String listAllClientes(); 
}
