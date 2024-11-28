package Dao;

import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.Pizza;

public class PizzaDaoImpl implements PizzaDao{
    private List<Pizza> pizzas = new ArrayList();
    
    @Override
    public void adicionarPizza(Pizza p){
        int id = pizzas.getLast().getId() + 1;
        pizzas.add(p);
        p.setId(id);
    }
    
    @Override
    public Pizza procurarPizzaPorId(int id){
        for(Pizza p: pizzas){
            if(p.getId() == id)
                return p;      
        }
        return null;
    }
    
    @Override
    public void atualizarPizza(int id, String nome, double valor, String ingredientes, int quantidade) {
        Pizza p = procurarPizzaPorId(id);
        
        if(p != null){
            p.setNome(nome);
            p.setValor(valor);
            p.setIngredientes(ingredientes);
            p.setQuantidade(quantidade);
        }
    }
    
    @Override
    public boolean deletePizza(int id){
        Pizza p = procurarPizzaPorId(id);
        if(p != null){
            pizzas.remove(p);
            return true;
        }
        return false;
    }
    
    @Override
    public String listAllPizzas(){   
        StringBuilder report = new StringBuilder();
        
        if(pizzas.isEmpty())
            return "Erro: nenhuma pizza cadastrada";
        
        for(Pizza p: pizzas){
            report.append("\nId: ").append(p.getId())
                .append("\nNome: ").append(p.getNome())
                .append("\nValor: R$").append(p.getValor()).append("\n")
                .append(p.getIngredientes()).append(" ; ");            
        }
        
        return report.toString();
    }
}
