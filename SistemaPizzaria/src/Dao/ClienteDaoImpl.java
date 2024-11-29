package Dao;

import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.Cliente;

public class ClienteDaoImpl implements ClienteDao{
    List<Cliente> clientes = new ArrayList();
    
    @Override
    public void adicionarCliente(Cliente c){
        clientes.add(c);
    }
    
    @Override
    public Cliente procurarClientePorCpf(String cpf){
        for(Cliente c: clientes){
            if(c.getCpf().equals(cpf))
                return c;
        }
        return null;
    }
    
    @Override
    public void atualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public boolean deleteCliente(String cpf){
        Cliente c = procurarClientePorCpf(cpf);
        
        if(c != null){
            clientes.remove(c);
            return true;
        }
        return false;
    }
    
    @Override
    public String listAllClientes(){
        StringBuilder report = new StringBuilder();
        
        if (clientes.isEmpty()) {
            return "Nenhum cliente cadastrado.";
        }
        
        for(Cliente c: clientes){
            report.append("\nCliente de ID: ").append(c.getCpf())
                .append("\nNome: ").append(c.getNome())
                .append("\nTelefone: ").append(c.getTelefone());
        }
        
        return report.toString();
    }
}
