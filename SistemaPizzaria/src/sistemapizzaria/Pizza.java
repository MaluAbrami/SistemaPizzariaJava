package sistemapizzaria;

public abstract class Pizza {
    protected int id;
    protected static int contadorId = 1;
    protected String nome;
    protected double valor;
    protected String ingredientes;
    protected int quantidade;
    
    public Pizza(String nome, double valor, String ingredientes, int quantidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
