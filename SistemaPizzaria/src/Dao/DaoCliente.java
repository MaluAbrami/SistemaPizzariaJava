package Dao;

import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.Cliente;

public class DaoCliente {
    List<Cliente> clientes = new ArrayList();
    
    public void adicionarCliente(Cliente c){
        clientes.add(c);
    }
    
    public Cliente procurarPorId(int id){
        for(Cliente c: clientes){
            if(c.getId() == id)
                return c;
        }
        return null;
    }
    
    public void atualizarCliente(){
        
    }
    
    public boolean delete(Cliente c){
        Cliente c_aux = procurarPorId(c.getId());
        
        if(c_aux != null){
            clientes.remove(c_aux);
            return true;
        }
        return false;
    }
    
    public String listAll(){
        StringBuilder report = new StringBuilder();
        
        if (clientes.isEmpty()) {
            return "Nenhum cliente cadastrado.";
        }
        
        for(Cliente c: clientes){
            report.append("\nCliente de ID: ").append(c.getId())
                .append("\nNome: ").append(c.getNome())
                .append("\nTelefone: ").append(c.getTelefone())
                .append("\nEndereco: ")
                .append("\nRua: ").append(c.getEnderecos().getRua())
                .append("\nBairro: ").append(c.getEnderecos().getBairro())
                .append("\nNumero: ").append(c.getEnderecos().getNumero())
                .append("\nCep: ").append(c.getEnderecos().getCep());
        }
        
        return report.toString();
    }
}
