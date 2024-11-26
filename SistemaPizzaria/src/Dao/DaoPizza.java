package Dao;

import java.util.ArrayList;
import java.util.List;
import sistemapizzaria.Pizza;

public class DaoPizza {
    private List<Pizza> pizzas = new ArrayList();
    
    public void adicionarPizza(Pizza p){
        pizzas.add(p);
    }
    
    public void atualizarPizza(){
        //atualizacao automatica
    }
    
    public boolean delete(Pizza p){
        Pizza p_aux = buscarPorId(p.getId());
        if(p != null){
            pizzas.remove(p_aux);
            return true;
        }
        return false;
    }
    
    public String listAll(){   
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
    
    public Pizza buscarPorId(int id){
        for(Pizza p: pizzas){
            if(p.getId() == id)
                return p;      
        }
        return null;
    }
    
    public String imprimi(int id){
        StringBuilder report = new StringBuilder();
        
        if(pizzas.isEmpty()){
            System.out.println("Erro: Nenhuma pizza cadastrada");
        }
        Pizza p = buscarPorId(id);
        
        report.append("\nId: ").append(p.getId())
                .append("\nNome: ").append(p.getNome())
                .append("\nValor: R$").append(p.getValor()).append("\n")
                .append(p.getIngredientes()).append(" ; ");
        return report.toString();
    }
}
