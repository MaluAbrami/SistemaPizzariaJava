package Dao;

import sistemapizzaria.Pizza;

public interface PizzaDao {
    void adicionarPizza(Pizza p);
    Pizza procurarPizzaPorId(int id);
    Pizza procurarPizzaPorNome(String nome);
    void atualizarPizza(int id, String nome, double valor, String ingredientes, int quantidade);
    boolean deletePizza(int id);
    String listAllPizzas();
}
