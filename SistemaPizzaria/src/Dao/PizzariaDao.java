package Dao;

import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pizzaria;

public interface PizzariaDao {
    void adicionarPizzaria(Pizzaria p);
    void atualizarPizzaria(DiaTrabalho d);
    void adicionarDiaTrabalho(DiaTrabalho d);
    void deletarDiaTrabalho(DiaTrabalho d);
    String obterRelatorioDiasTrabalhados();
}
