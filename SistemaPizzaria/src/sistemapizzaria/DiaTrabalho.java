package sistemapizzaria;

import java.util.ArrayList;
import java.util.List;

public final class DiaTrabalho {
    private int id;
    private static int contadorId = 1;
    private String data;
    private List<Pedido> pedidos = new ArrayList();
    private double faturamento;

    public DiaTrabalho(String data) {
        this.id = contadorId++;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void adicionarPedido(Pedido p){
        pedidos.add(p);
        faturamento += p.getValorPedido(); //SOMA OS VALORES DOS PEDIDOS QUE FOREM ADICIONADOS
    }
    
    public double getFaturamento() {
        return faturamento;
    }
}
