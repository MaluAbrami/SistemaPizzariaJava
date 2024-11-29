package Dao;

import sistemapizzaria.Cliente;

public interface ClienteDao {
    void adicionarCliente(Cliente cliente);
    Cliente procurarClientePorCpf(String cpf);
    void atualizarCliente(Cliente cliente);
    boolean deleteCliente(String cpf);
    String listAllClientes(); 
}
