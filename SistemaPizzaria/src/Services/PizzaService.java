package Services;

import java.util.Scanner;

public class PizzaService {
    
    private Scanner scanner;

    public PizzaService(Scanner scanner) {
        this.scanner = scanner;
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
}
