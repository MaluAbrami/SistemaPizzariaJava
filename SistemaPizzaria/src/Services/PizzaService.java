package Services;

import Dao.PizzaDaoImpl;
import Pizzas.PizzaQualquer;
import java.util.Scanner;
import sistemapizzaria.Pizza;

public class PizzaService {
    private PizzaDaoImpl pizzaDao;
    private Scanner scanner;

    public PizzaService(Scanner scanner, PizzaDaoImpl pizzaDao) {
        this.scanner = scanner;
        this.pizzaDao = pizzaDao;
    }
    
    private void adicionarPizza(){
        System.out.println("\n\tAdicionar nova Pizza");
        
        System.out.println("Nome da Pizza: ");
        String nome = scanner.nextLine();
        
        System.out.println("Valor da Pizza: ");
        double valor = scanner.nextDouble();
        
        System.out.println("Ingredientes: ");
        String ingredientes = scanner.nextLine();
        
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        
        //ID de pizza sera definido automaticamente no DAO
        Pizza novaPizza = new PizzaQualquer(0, nome, valor, ingredientes, quantidade);
        pizzaDao.adicionarPizza(novaPizza);
    }
    
    private void atualizarPizza(){
        System.out.println("\n\tAtualizar Pizza");
        
        System.out.println("Id da Pizza que deseja atualizar: ");
        int id = scanner.nextInt();
        Pizza p = pizzaDao.procurarPizzaPorId(id);
        
        if(p != null){
            String nome, ingredientes;
            double valor;
            int quantidade;
            
            System.out.println("Alterar nome? (1-sim/2-nao)");
            int resp = scanner.nextInt();
            if(resp == 1){
                System.out.println("Novo nome: ");
                nome = scanner.nextLine();
            } else {
                nome = p.getNome();
            }

            System.out.println("Alterar valor? (1-sim/2-nao)");
            resp = scanner.nextInt();
            if(resp == 1){
                System.out.println("Novo valor: ");
                valor = scanner.nextDouble();
            } else {
                valor = p.getValor();
            }

            System.out.println("Alterar ingredientes? (1-sim/2-nao)");
            resp = scanner.nextInt();
            if (resp == 1) {
                System.out.println("Novos ingredientes: ");
                ingredientes = scanner.nextLine();
            } else {
                ingredientes = p.getIngredientes();
            }
            
            System.out.println("Alterar quantidade? (1-sim/2-nao)");
            resp = scanner.nextInt();
            if (resp == 1) {
                System.out.println("Nova quantidade: ");
                quantidade = scanner.nextInt();
            } else {
                quantidade = p.getQuantidade();
            }
            
            pizzaDao.atualizarPizza(id, nome, valor, ingredientes, quantidade);
            System.out.println("Pizza atualizada com sucesso!");
        } else {
            System.out.println("Erro: nao foi possivel atualizar a pizza");
        }
    }
    
    private void deletarPizza(){
        System.out.println("\n\tDeletando uma Pizza");
        
        System.out.println("Informe o id da pizza que deseja deletar: ");
        int id = scanner.nextInt();
        boolean resp = pizzaDao.deletePizza(id);
        
        if(resp){
            System.out.println("Pizza deletada com sucesso!");
        } else{
            System.out.println("Erro: nao foi possivel deletar a pizza");
        }
    }
    
    private void listarPizzas(){
        System.out.println("\n\tLista de Pizzas");
        System.out.println(pizzaDao.listAllPizzas());
    }
}