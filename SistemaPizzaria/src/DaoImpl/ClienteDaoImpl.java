package DaoImpl;

import Dao.ClienteDao;
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
    public void atualizarCliente(String cpf, String nome, String telefone) {
        Cliente cliente = procurarClientePorCpf(cpf);
        
        if(cliente != null){
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
        }
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
            report.append("\nCliente de CPF: ").append(c.getCpf())
                .append("\nNome: ").append(c.getNome())
                .append("\nTelefone: ").append(c.getTelefone());
        }
        
        return report.toString();
    }
}
