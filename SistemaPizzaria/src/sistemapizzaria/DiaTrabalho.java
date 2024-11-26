package sistemapizzaria;

import java.util.ArrayList;
import java.util.List;

public final class DiaTrabalho {
    private int id;
    private String data;
    private List<Pedido> pedidos = new ArrayList();
    private double faturamento;

    public DiaTrabalho(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
