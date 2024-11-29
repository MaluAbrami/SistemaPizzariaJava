package Dao;

import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pizzaria;

public interface PizzariaDao {
    void adicionarPizzaria(Pizzaria p);
    void atualizarPizzaria(Pizzaria p);
    void adicionarDiaTrabalho(DiaTrabalho d);
    String obterRelatorioDiasTrabalhados();
}
