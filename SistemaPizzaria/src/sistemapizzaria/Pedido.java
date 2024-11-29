package sistemapizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorId = 0; //ID sera gerado de forma automatica
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas = new ArrayList();
    private double valorPedido;
    
    public Pedido(){
        this.id = contadorId++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getValorPedido(){
        return valorPedido;
    }
    
    public void adicionarCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void adicionarPizza(Pizza pizza){
        pizzas.add(pizza);
        valorPedido += pizza.getValor(); //ADICIONA AO VALOR TOTAL DO PEDIDO
    }
    
    public List<Pizza> getPizzas(){
        return pizzas;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){ //Para atualizacoes
        this.cliente = cliente;
    }
}
