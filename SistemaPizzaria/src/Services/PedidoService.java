package Services;

import Dao.DiaTrabalhoDao;
import DaoImpl.PedidoDaoImpl;
import DaoImpl.ClienteDaoImpl;
import DaoImpl.PizzaDaoImpl;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sistemapizzaria.Cliente;
import sistemapizzaria.Pedido;
import sistemapizzaria.Pizza;

public class PedidoService {
    private ClienteDaoImpl clienteDao;
    private PizzaDaoImpl pizzaDao;
    private PedidoDaoImpl pedidoDao;
    private Scanner scanner;
    
    public PedidoService(PedidoDaoImpl pedidoDao, ClienteDaoImpl clienteDao, PizzaDaoImpl pizzaDao, Scanner scanner){
        this.pedidoDao = pedidoDao;
        this.clienteDao = clienteDao;
        this.pizzaDao = pizzaDao;
        this.scanner = scanner;
    }
    
    public void adicionarPedido(){
        String cpf;
        Cliente cliente;
        int resp = 1;
        
        System.out.println("\n\tAdicionar novo Pedido");
        
        System.out.print("\nInforme o CPF do Cliente: ");
        scanner.nextLine();
        cpf = scanner.nextLine();
        cliente = clienteDao.procurarClientePorCpf(cpf);
        if(cliente != null){
            Pedido novoPedido = new Pedido(); //Cria pedido
            novoPedido.adicionarCliente(cliente); //Adiciona o cliente 
            
            while(resp == 1){
                System.out.print("\nInforme o ID da pizza que deseja: ");
                Pizza pizza = pizzaDao.procurarPizzaPorId(parseInt(scanner.nextLine()));
                if(pizza != null){
                    novoPedido.adicionarPizza(pizza); //Adiciona Pizza
                    pizza.setQuantidade(pizza.getQuantidade() - 1); //Diminui 1 na quantidade de pizzas
                    System.out.println("Pizza de " + pizza.getNome() + " adicionada ao Pedido!");
                    System.out.print("\nQuer adicionar mais alguma pizza ao pedido? (1-sim/2-nao)");
                    resp = parseInt(scanner.nextLine());
                } else{
                    System.out.println("Erro: Nenhuma pizza cadastrada com o id informado!");
                    System.out.println("Pressione 'Enter' e confira as pizzas cadastradas");
                    scanner.nextLine();
                    System.out.println(pizzaDao.listAllPizzas());
                    System.out.println("Tente novamente por favor");
                }
            }
            
            pedidoDao.adicionarPedido(novoPedido); //Adiciona o novo pedido
            System.out.println("Pedido adicionado com sucesso!");
        } else{
            System.out.println("Erro: cliente com o cpf informado nao existe");
        }
    }
    
    public void atualizarPedido() {
        System.out.println("\n\rAtualizar Pedido");
        
        System.out.println("Id do Pedido que deseja atualizar: ");
        scanner.nextLine();
        int id = scanner.nextInt();
        scanner.nextLine();
        Pedido p = pedidoDao.procurarPedidoPorId(id);
        
        if (p != null) {
            String cpf;
            Cliente cliente;
            List<Pizza> pizzas = new ArrayList();
            int resp;
            
            System.out.print("Alterar cliente dono do Pedido?(1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            if (resp == 1) {
                System.out.print("\nInforme o CPF do Cliente: ");
                cpf = scanner.nextLine();
                cliente = clienteDao.procurarClientePorCpf(cpf);
                if(cliente != null)
                    System.out.println("Cliente atualizado com sucesso!");
                else
                    System.out.println("Erro: nao foi possivel atualizar o cliente do pedido");
            } else{
                cliente = null;
            }

            System.out.print("Alterar pizzas do pedido? (1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            if (resp == 1) {
                while (resp == 1) {
                    System.out.print("\nInforme o ID da pizza que deseja: ");
                    Pizza pizza = pizzaDao.procurarPizzaPorId(parseInt(scanner.nextLine()));
                    if (pizza != null) {
                        pizzas.add(pizza);
                        System.out.println("Pizza de " + pizza.getNome() + " adicionada ao Pedido!");
                        System.out.print("\nQuer adicionar mais alguma pizza ao pedido? (1-sim/2-nao)");
                        resp = parseInt(scanner.nextLine());
                    } else {
                        System.out.println("Erro: Nenhuma pizza cadastrada com o id informado!");
                        System.out.println("Pressione 'Enter' e confira as pizzas cadastradas");
                        scanner.nextLine();
                        System.out.println(pizzaDao.listAllPizzas());
                        System.out.println("Tente novamente por favor");
                    }
                }
            } else {
                pizzas = null;
            }
            
            pedidoDao.atualizarPedido(p.getId(), cliente, pizzas);
            System.out.println("Pedido atualizado com sucesso!");
        } else {
            System.out.println("Erro: nao foi possivel atualizar o pedido");
        }
    }
    
    public void deletarPedido(){
        System.out.println("\n\tDeletando um Pedido");
        
        System.out.println("Informe o id do pedido que deseja deletar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean resp = pedidoDao.deletePedido(id);
        
        if(resp){
            System.out.println("Pedido deletado com sucesso!");
        } else{
            System.out.println("Erro: nao foi possivel deletar o pedido!");
        }
    }
    
    public void listarPedidos(){
        System.out.println("\n\tLista de Pedidos");
        System.out.println(pedidoDao.listAllPedidos());
    }
    
    public void listarPedidosPorCliente(){
        System.out.println("\n\tLista dos Pedidos do Cliente");
        
        System.out.print("\nInforme o CPF do cliente: ");
        scanner.nextLine();
        String cpf = scanner.nextLine();
        Cliente cliente = clienteDao.procurarClientePorCpf(cpf);
        
        if(cliente != null)
            System.out.println(pedidoDao.listAllPedidosPorCliente(cpf));
        else 
            System.out.println("Erro: cliente de CPF informado nao existe");
    }
}
