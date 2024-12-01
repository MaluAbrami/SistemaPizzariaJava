package Services;

import DaoImpl.PizzaDaoImpl;
import Pizzas.PizzaQualquer;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import sistemapizzaria.Pizza;

public class PizzaService {
    private PizzaDaoImpl pizzaDao;
    private Scanner scanner;

    public PizzaService(Scanner scanner, PizzaDaoImpl pizzaDao) {
        this.scanner = scanner;
        this.pizzaDao = pizzaDao;
    }
    
    public void adicionarPizza(){
        String nome, ingredientes;
        double valor;
        int quantidade, id, resp = 1;

        System.out.println("\n\tAdicionar nova Pizza");

        System.out.print("\nNome da Pizza: ");
        scanner.nextLine();
        nome = scanner.nextLine();
        Pizza p = pizzaDao.procurarPizzaPorNome(nome);
        if (p != null) {
            System.out.println("\nJa existe uma pizza cadastrada com esse nome!\nPressione 'Enter' para conferir as pizzas ja cadastradas");
            scanner.nextLine();
            System.out.println(pizzaDao.listAllPizzas());
            System.out.println("Nao foi possivel adicionar uma nova pizza");
        } else{
            System.out.print("Valor da Pizza: ");
            valor = parseDouble(scanner.nextLine());

            System.out.print("Ingredientes: ");
            ingredientes = scanner.nextLine();

            System.out.print("Quantidade: ");
            quantidade = parseInt(scanner.nextLine());

            //ID de pizza sera definido automaticamente no DAO
            Pizza novaPizza = new PizzaQualquer(nome, valor, ingredientes, quantidade);
            pizzaDao.adicionarPizza(novaPizza);
            System.out.println("Pizza adicionada com sucesso!");
        }
    }
    
    public void atualizarPizza(){
        System.out.println("\n\tAtualizar Pizza");
        
        System.out.println("Id da Pizza que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Pizza p = pizzaDao.procurarPizzaPorId(id);
        
        if(p != null){
            String nome, ingredientes;
            double valor;
            int quantidade;
            
            System.out.print("Alterar nome? (1-sim/2-nao)");
            int resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.print("Novo nome: ");
                nome = scanner.nextLine();
                Pizza pizza = pizzaDao.procurarPizzaPorNome(nome);
                if(pizza != null) {
                    System.out.println("\nJa existe uma pizza cadastrada com esse nome!\nPressione 'Enter' para conferir as pizzas ja cadastradas");
                    scanner.nextLine();
                    System.out.println(pizzaDao.listAllPizzas());
                    System.out.println("Nao foi possivel atualizar a pizza");
                }
            } else {
                nome = p.getNome();
            }

            System.out.print("Alterar valor? (1-sim/2-nao)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if(resp == 1){
                System.out.print("Novo valor: ");
                valor = parseDouble(scanner.nextLine());
            } else {
                valor = p.getValor();
            }

            System.out.print("Alterar ingredientes? (1-sim/2-nao)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.print("Novos ingredientes: ");
                ingredientes = scanner.nextLine();
            } else {
                ingredientes = p.getIngredientes();
            }
            
            System.out.println("Alterar quantidade? (1-sim/2-nao)");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.print("Nova quantidade: ");
                quantidade = parseInt(scanner.nextLine());
            } else {
                quantidade = p.getQuantidade();
            }
            
            pizzaDao.atualizarPizza(id, nome, valor, ingredientes, quantidade);
            System.out.println("Pizza atualizada com sucesso!");
        } else {
            System.out.println("Erro: nao foi possivel atualizar a pizza");
        }
    }
    
    public void deletarPizza(){
        System.out.println("\n\tDeletando uma Pizza");
        
        System.out.println("Informe o id da pizza que deseja deletar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean resp = pizzaDao.deletePizza(id);
        
        if(resp){
            System.out.println("Pizza deletada com sucesso!");
        } else{
            System.out.println("Erro: nao foi possivel deletar a pizza");
        }
    }
    
    public void listarPizzas(){
        System.out.println("\n\tLista de Pizzas");
        System.out.println(pizzaDao.listAllPizzas());
    }
}