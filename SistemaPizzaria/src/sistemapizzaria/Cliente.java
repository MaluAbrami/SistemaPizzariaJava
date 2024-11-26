package sistemapizzaria;

import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private Endereco enderecos;

    public Cliente(int id, String nome, String telefone, Endereco enderecos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.enderecos = enderecos;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }
}
