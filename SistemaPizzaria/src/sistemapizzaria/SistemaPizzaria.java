package sistemapizzaria;

import Dao.DaoCliente;
import Dao.DaoPizza;
import Dao.DaoPedido;
import Dao.DaoDiaTrabalho;
import java.util.Scanner;

public class SistemaPizzaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //INICIALIZANDO DAO´S
        DaoPizza daoPizza = new DaoPizza();
        DaoPedido daoPedido = new DaoPedido();
        DaoDiaTrabalho daoDiaTrabalho = new DaoDiaTrabalho();
        DaoCliente daoCliente = new DaoCliente();
        
        //INSTANCIANDO PIZZAS
        Pizza calabresa = new Calabresa(1, "Calabresa", 35.5, "Calabresa, mussarela, cebola");
        Pizza caipira = new Caipira(2, "Caipira", 39.9, "Frango, milho, mussarela, catupiry");
        Pizza quatroQueijos = new QuatroQueijos(3, "Quatro Queijos", 37.5, "Mussarela, Catupiry, Parmesão, Gorgonzola");
        
        //INSTANCIANDO ENDERECO E CLIENTE
        Endereco ed1 = new Endereco("rua A", 10, "bairro B", "18367-230");
        Cliente c1 = new Cliente(1, "Maria Luiza", "15-993648596", ed1);
        Endereco ed2 = new Endereco("rua B", 100, "bairro C", "18367-230");
        Cliente c2 = new Cliente(2, "Talita", "15-993558596", ed2);
        
        //INSTANCIANDO PEDIDO
        Pedido p1 = new Pedido(1);
        p1.adicionarCliente(c1);
        p1.adicionarPizza(caipira);
        p1.adicionarPizza(calabresa);
        Pedido p2 = new Pedido(2);
        p2.adicionarCliente(c1);
        p2.adicionarPizza(quatroQueijos);
        p2.adicionarPizza(caipira);
        
        //INSTANCIANDO DIA TRABALHO
        DiaTrabalho d1 = new DiaTrabalho(1, "26/11/2024");
        d1.adicionarPedido(p1);
        DiaTrabalho d2 = new DiaTrabalho(2, "27/11/2024");
        d2.adicionarPedido(p2);
        
        //CADASTRANDO PIZZAS
        daoPizza.adicionarPizza(calabresa);
        daoPizza.adicionarPizza(caipira);
        daoPizza.adicionarPizza(quatroQueijos);
        
        //CADASTRANDO CLIENTES
        daoCliente.adicionarCliente(c1);
        daoCliente.adicionarCliente(c2);
        
        //CADASTRANDO PEDIDOS
        daoPedido.adicionarPedido(p1);
        daoPedido.adicionarPedido(p2);
        
        //CADASTRANDO DIA DE TRABALHO
        daoDiaTrabalho.adicionarDiaTrabalho(d1);
        daoDiaTrabalho.adicionarDiaTrabalho(d2);
        
        
        int opcao;
        
        //TESTANDO VALORES DE PIZZA, PEDIDO E DIA DE TRABALHO
        System.out.println(calabresa.getValor());
        System.out.println(p1.getValorPedido());
        System.out.println(d1.getFaturamento());
        
        do{
            
            System.out.println("\n=== Menu Pizzaria ===");
            System.out.println("\n1 - Relatorio por Cliente");
            System.out.println("\n2 - Relatorio por Dia de Trabalho");
            System.out.println("\n3 - Todas as Pizzas");
            System.out.println("\n4 - Todos os Pedidos");
            System.out.println("\n5 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao){
                case 1:{
                    System.out.println("\nInforme o ID do cliente: ");
                    int id = scanner.nextInt();
                    Cliente cliente = daoCliente.procurarPorId(id);
                    
                    if(cliente != null){
                        System.out.println(daoPedido.listAllPorCliente(id));
                    }
                    else
                        System.out.println("Cliente nao existe");
                    
                    break;
                }
                case 2:{
                    System.out.println("\nInforme o ID do dia: ");
                    int id = scanner.nextInt();
                    DiaTrabalho dia = daoDiaTrabalho.procurarPorId(id);
                    
                    if(dia != null){
                        System.out.println(daoDiaTrabalho.listAllPorDia(id));
                    }
                    else   
                        System.out.println("Dia informado nao existe");
                    break;
                }
                case 3:{
                    System.out.println("\n=== Pizzas ===");
                    System.out.println(daoPizza.listAll());
                    
                    break;
                }
                case 4:{
                    System.out.println("\n=== Pedidos ===");
                    System.out.println(daoPedido.listAll());
                    break;
                }
                case 5:{
                    System.out.println("\nSaindo...");
                    break;
                }
                default:{
                    System.out.println("\nOpcao invalida! Tente novamente");
                }
            }
            
        } while(opcao != 5);
    }
    
}
