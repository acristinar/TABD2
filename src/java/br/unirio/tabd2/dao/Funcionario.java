
package br.unirio.tabd2.dao;

/**
 *
 * @author Amanda
 */
public class Funcionario {
    private int cpf;
    private String nome;
    private String tipo;

    public Funcionario(int cpf, String nome, String tipo) {
        this.cpf = cpf;
        this.nome = nome;
        this.tipo = tipo;
    }

    Funcionario() {
        
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

}
