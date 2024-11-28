package Dao;

import sistemapizzaria.DiaTrabalho;

public interface DiaTrabalhoDao {
    void adicionarDiaTrabalho(DiaTrabalho d);
    DiaTrabalho procurarDiaTrabalhoPorId(int id);
    void atualizarDiaTrabalho(DiaTrabalho d);
    boolean deleteDiaTrabalho(int id);
    String listAllDiasTrabalho();
    String listAllPedidosPorDiaTrabalho(int id);
}
