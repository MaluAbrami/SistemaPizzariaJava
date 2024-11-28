package SistemaDeMenus;

import Dao.ClienteDaoImpl;
import Dao.DiaTrabalhoDaoImpl;
import Dao.PedidoDaoImpl;
import Dao.PizzaDaoImpl;
import java.util.Scanner;

public class Menus {
    private PizzaDaoImpl pizzaDao;
    private PedidoDaoImpl pedidoDao;
    private ClienteDaoImpl clienteDao;
    private DiaTrabalhoDaoImpl diaTrabalhoDao;
    
    Scanner scanner = new Scanner(System.in);

    public Menus(PizzaDaoImpl pizzaDao, PedidoDaoImpl pedidoDao, ClienteDaoImpl clienteDao, DiaTrabalhoDaoImpl diaTrabalhoDao) {
        this.pizzaDao = pizzaDao;
        this.pedidoDao = pedidoDao;
        this.clienteDao = clienteDao;
        this.diaTrabalhoDao = diaTrabalhoDao;
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
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (op != 5);

        scanner.close();
    }

    private int mostrarMenuPrincipal(Scanner scanner) {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gerenciar Pizzas");
        System.out.println("2. Gerenciar Pedidos");
        System.out.println("3. Gerenciar Clientes");
        System.out.println("4. Gerenciar Dia de Trabalho");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
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
            System.out.print("Escolha uma opção: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Adicionando Pizza...");
                    // lógica de adicionar pizza
                    break;
                case 2:
                    System.out.println("Atualizando Pizza...");
                    // lógica de atualizar pizza
                    break;
                case 3:
                    System.out.println("Excluindo Pizza...");
                    // lógica de excluir pizza
                    break;
                case 4:
                    System.out.println("Listando Pizzas...");
                    // lógica de listar pizzas
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (op != 5);
    }

    private void adicionarPizza(){
        System.out.println("\n\tAdicionar nova Piza");
        
        System.out.println("Nome da Pizza: ");
        String nome = scanner.nextLine();
        
        System.out.println("Valor da Pizza: ");
        double valor = scanner.nextDouble();
        
        System.out.println("Ingredientes: ");
        String ingredientes = scanner.nextLine();
        
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        
        
    }
    
//SECAO DOS PEDIDOS
    private void menuPedidos() {
        int op;
        do {
            System.out.println("\n--- Gerenciar Pedidos ---");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Atualizar Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Listar Pedidos por Cliente");
            System.out.println("5. Listar Pedidos por Dia de Trabalho");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Criando Pedido...");
                    // lógica de criar pedido
                    break;
                case 2:
                    System.out.println("Atualizando Pedido...");
                    // lógica de atualizar pedido
                    break;
                case 3:
                    System.out.println("Cancelando Pedido...");
                    // lógica de cancelar pedido
                    break;
                case 4:
                    System.out.println("Listando Pedidos por Cliente...");
                    // lógica de listar pedidos por cliente
                    break;
                case 5:
                    System.out.println("Listando Pedidos por Dia de Trabalho...");
                    // lógica de listar pedidos por dia de trabalho
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
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
            System.out.print("Escolha uma opção: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Adicionando Cliente...");
                    // lógica de adicionar cliente
                    break;
                case 2:
                    System.out.println("Atualizando Dados do Cliente...");
                    // lógica de atualizar cliente
                    break;
                case 3:
                    System.out.println("Excluindo Cliente...");
                    // lógica de excluir cliente
                    break;
                case 4:
                    System.out.println("Listando Clientes...");
                    // lógica de listar clientes
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (op != 5);
    }

    
//SECAO DOS DIAS DE TRABALHO    
    private void menuDiasTrabalho() {
        int op;
        do {
            System.out.println("\n--- Gerenciar Dia de Trabalho ---");
            System.out.println("1. Iniciar Dia de Trabalho");
            System.out.println("2. Encerrar Dia de Trabalho");
            System.out.println("3. Consultar Relatórios do Dia");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Iniciando Dia de Trabalho...");
                    // lógica de iniciar dia de trabalho
                    break;
                case 2:
                    System.out.println("Encerrando Dia de Trabalho...");
                    // lógica de encerrar dia de trabalho
                    break;
                case 3:
                    System.out.println("Consultando Relatórios do Dia...");
                    // lógica de consultar relatórios do dia
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (op != 4);
        
        scanner.close();
    }
}