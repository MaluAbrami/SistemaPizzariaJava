package Services;

import Dao.PedidoDaoImpl;
import Dao.ClienteDaoImpl;
import Dao.PizzaDaoImpl;
import static java.lang.Integer.parseInt;
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
    
    public PedidoService(PedidoDaoImpl pedidoDao, Scanner scanner){
        this.pedidoDao = pedidoDao;
        this.scanner = scanner;
    }
    
    public void adicionarPedido(){
        String cpf;
        Cliente cliente;
        List<Pizza> pizzas = null;
        double valorPedido;
        int resp = 1, pizzaId;
        
        System.out.println("\n\tAdicionar novo Pedido");
        
        System.out.print("\nInforme o CPF do Cliente: ");
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
        } else{
            System.out.println("Erro: cliente com o cpf informado nao existe");
        }
    }
}
