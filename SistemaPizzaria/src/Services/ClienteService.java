package Services;

import DaoImpl.ClienteDaoImpl;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import sistemapizzaria.Cliente;

public class ClienteService {
    private ClienteDaoImpl clienteDao;
    private Scanner scanner;
    
    public ClienteService(ClienteDaoImpl clienteDao, Scanner scanner){
        this.clienteDao = clienteDao;
        this.scanner = scanner;
    }
    
    public void adicionarCliente(){
        String cpf, nome, telefone;
        int resp = 1;
        Cliente cliente;
        
        System.out.println("\n\tAdicionar novo Cliente");
        
        while(resp == 1){
            System.out.print("\nInforme o CPF: ");
            scanner.nextLine();
            cpf = scanner.nextLine();
            cliente = clienteDao.procurarClientePorCpf(cpf);

            if (cliente != null) {
                System.out.println("Erro: CPF ja cadastrado");
                System.out.print("\nO CPF inserido esta errado? Se sim, tente novamente por favor (1-sim/2-nao)");
                resp = parseInt(scanner.nextLine());
                break;
            } else {
                System.out.print("\nNome Completo: ");
                nome = scanner.nextLine();
                
                System.out.print("\nTelefone: ");
                telefone = scanner.nextLine();
                
                Cliente novoCliente = new Cliente(cpf, nome, telefone);
                clienteDao.adicionarCliente(novoCliente);
                
                resp = 2; //Para encerrar o while
            }
        }
    }
    
    public void atualizarCliente(){
        System.out.println("\n\tAtualizar Cliente");
        
        System.out.print("\nInforme o CPF do Cliente que deseja atualizar: ");
        scanner.nextLine();
        String cpf = scanner.nextLine();
        Cliente cliente = clienteDao.procurarClientePorCpf(cpf);
        
        if(cliente != null){
            String nome, telefone;
            int resp;
            
            System.out.print("\nDeseja alterar o nome? (1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            if(resp == 1){
                System.out.print("\nInforme o nome: ");
                nome = scanner.nextLine();
            } else{
                nome = cliente.getNome();
            }
            
            System.out.print("\nDeseja alterar o telefone? (1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            if(resp == 1){
                System.out.print("\nInforme o telefone: ");
                telefone = scanner.nextLine();
            } else{
                telefone = cliente.getTelefone();
            }
            
            clienteDao.atualizarCliente(cpf, nome, telefone);
            System.out.println("Cliente atualizado com sucesso!");
        } else{
            System.out.println("Erro: nao foi possivel atualizar o cliente");
        }
    }
    
    public void deletarCliente(){
        System.out.println("\n\tDeletando um Cliente");
        
        System.out.print("\nInforme o CPF do Cliente que deseja deletar: ");
        scanner.nextLine();
        String cpf = scanner.nextLine();
        boolean resp = clienteDao.deleteCliente(cpf);
        
        if(resp){
            System.out.println("Cliente deletado com sucesso!");
        } else{
            System.out.println("Erro: nao foi possivel deletar o cliente");
        }
    }
    
    public void listarClientes(){
        System.out.println("\n\tLista de Clientes");
        System.out.println(clienteDao.listAllClientes());
    }
}
