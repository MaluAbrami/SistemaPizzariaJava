package Dao;

import sistemapizzaria.Pizza;

public interface PizzaDao {
    void adicionarPizza(Pizza p);
    Pizza procurarPizzaPorId(int id);
    void atualizarPizza(Pizza p);
    boolean deletePizza(int id);
    String listAllPizzas();
}
