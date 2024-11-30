package Dao;

import sistemapizzaria.Cliente;

public interface ClienteDao {
    void adicionarCliente(Cliente cliente);
    Cliente procurarClientePorCpf(String cpf);
    void atualizarCliente(String cpf, String nome, String telefone);
    boolean deleteCliente(String cpf);
    String listAllClientes(); 
}
