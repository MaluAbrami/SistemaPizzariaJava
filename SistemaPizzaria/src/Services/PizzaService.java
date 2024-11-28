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
        System.out.println("\n\tAdicionar nova Piza");
        
        System.out.println("Nome da Pizza: ");
        String nome = scanner.nextLine();
        
        System.out.println("Valor da Pizza: ");
        double valor = scanner.nextDouble();
        
        System.out.println("Ingredientes: ");
        String ingredientes = scanner.nextLine();
        
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        
        Pizza novaPizza = new PizzaQualquer(0, nome, valor, ingredientes, quantidade);
        pizzaDao.adicionarPizza(novaPizza);
    }
    
    private void 
}
