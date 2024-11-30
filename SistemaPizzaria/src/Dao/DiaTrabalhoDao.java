package Dao;

import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pedido;

public interface DiaTrabalhoDao {
    void adicionarDiaTrabalho(DiaTrabalho d);
    DiaTrabalho procurarDiaTrabalhoPorId(int id);
    void atualizarDiaTrabalho(DiaTrabalho d);
    boolean deleteDiaTrabalho(int id);
    String listAllDiasTrabalho();
    String listAllPedidosPorDiaTrabalho(int id);
    DiaTrabalho procurarDiaTrabalhoPorData(String data);
    Pedido verificarSePedidoJaExisteEmAlgumDia(int pedidoId);
}
