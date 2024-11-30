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
        
        System.out.println("\n\tAdicionar novo Cliente");
        
        while(resp == 1){
            System.out.print("\nInforme o CPF: ");
            cpf = scanner.nextLine();
            Cliente cliente = clienteDao.procurarClientePorCpf(cpf);

            if (cliente != null) {
                System.out.println("Erro: CPF ja cadastrado");
                System.out.print("\nO CPF inserido esta errado? Se sim, tente novamente por favor (1-sim/2-nao)");
                resp = parseInt(scanner.nextLine());
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
        String cpf = scanner.nextLine();
        Cliente cliente = clienteDao.procurarClientePorCpf(cpf);
        
        if(cliente != null){
            String nome, telefone;
            int resp;
            
            System.out.print("\nDeseja alterar o nome?");
            resp = parseInt(scanner.nextLine());
            if(resp == 1){
                System.out.print("\nInforme o nome: ");
                nome = scanner.nextLine();
            } else{
                nome = cliente.getNome();
            }
            
            System.out.print("\nDeseja alterar o telefone?");
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
}
