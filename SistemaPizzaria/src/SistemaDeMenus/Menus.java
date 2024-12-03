package SistemaDeMenus;

import Services.PizzaService;
import Services.ClienteService;
import Services.DiaTrabalhoService;
import Services.PedidoService;
import Services.PizzariaService;
import java.util.Scanner;

public class Menus {
    private PizzaService pizzaService;
    private PedidoService pedidoService;
    private ClienteService clienteService;
    private DiaTrabalhoService diaTrabalhoService;
    private PizzariaService pizzariaService;
    private Scanner scanner;

    public Menus(PizzaService pizzaService, PedidoService pedidoService, ClienteService clienteService, DiaTrabalhoService diaTrabalhoService, PizzariaService pizzariaService, Scanner scanner) {
        this.pizzaService = pizzaService;
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.diaTrabalhoService = diaTrabalhoService;
        this.pizzariaService = pizzariaService;
        this.scanner = scanner;
    }
    
//SECAO PRINCIPAL
    public void menuPrincipal() {
        int op;

        do {
            op = mostrarMenuPrincipal(scanner);
            switch (op) {
                case 1:
                    menuPizzas();
                    break;
                case 2:
                    menuPedidos();
                    break;
                case 3:
                    menuClientes();
                    break;
                case 4:
                    menuDiasTrabalho();
                    break;
                case 5:
                    System.out.println("\tRelatorio dos Dias de Trabalho da Pizzaria");
                    pizzariaService.obterRelatorioDiasTrabalhados();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (op != 6);

        scanner.close();
    }

    private int mostrarMenuPrincipal(Scanner scanner) {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gerenciar Pizzas");
        System.out.println("2. Gerenciar Pedidos");
        System.out.println("3. Gerenciar Clientes");
        System.out.println("4. Gerenciar Dia de Trabalho");
        System.out.println("5.Gerar Relatorio de Todos os Dias de Trabalho");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    
//SECAO DAS PIZZAS
    private void menuPizzas() {
        int op;
        do {
            System.out.println("\n--- Gerenciar Pizzas ---");
            System.out.println("1. Adicionar Pizza");
            System.out.println("2. Atualizar Pizza");
            System.out.println("3. Excluir Pizza");
            System.out.println("4. Listar Pizzas");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    pizzaService.adicionarPizza();
                    break;
                case 2:
                    pizzaService.atualizarPizza();
                    break;
                case 3:
                    pizzaService.deletarPizza();
                    break;
                case 4:
                    pizzaService.listarPizzas();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (op != 5);
    }
    
//SECAO DOS PEDIDOS
    private void menuPedidos() {
        int op;
        do {
            System.out.println("\n--- Gerenciar Pedidos ---");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Atualizar Pedido");
            System.out.println("3. Excluir Pedido");
            System.out.println("4. Listar Pedidos por Cliente");
            System.out.println("5. Listar Todos os Pedidos Cadastrados");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    pedidoService.adicionarPedido();
                    break;
                case 2:
                    pedidoService.atualizarPedido();
                    break;
                case 3:
                    pedidoService.deletarPedido();
                    break;
                case 4:
                    pedidoService.listarPedidosPorCliente();
                    break;
                case 5:
                    pedidoService.listarPedidos();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (op != 6);
    }

    
//SECAO DOS CLIENTES    
    private void menuClientes() {
        int op;
        do {
            System.out.println("\n--- Gerenciar Clientes ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Atualizar Dados do Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    clienteService.adicionarCliente();
                    break;
                case 2:
                    clienteService.atualizarCliente();
                    break;
                case 3:
                    clienteService.deletarCliente();
                    break;
                case 4:
                    clienteService.listarClientes();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (op != 5);
    }

    
//SECAO DOS DIAS DE TRABALHO    
    private void menuDiasTrabalho() {
        int op;
        do {
            System.out.println("\n--- Gerenciar Dia de Trabalho ---");
            System.out.println("1. Adicionar um Dia de Trabalho");
            System.out.println("2. Atualizar um Dia de Trabalho");
            System.out.println("3. Excluir Dia de Tranalho");
            System.out.println("4. Listar Todos os Dias de Trabalho");
            System.out.println("5. Listar Todos os Pedidos Por Dia de Trabalho");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    diaTrabalhoService.adicionarDiaTrabalho();
                    break;
                case 2:
                    diaTrabalhoService.atualizarDiaTrabalho();
                    break;
                case 3:
                    diaTrabalhoService.deletarDiaTrabalho();
                    break;
                case 4:
                    diaTrabalhoService.listarDiasTrabalho();
                    break;
                case 5:
                    diaTrabalhoService.listarPedidosPorDiaTrabalho();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (op != 6);
    }
}