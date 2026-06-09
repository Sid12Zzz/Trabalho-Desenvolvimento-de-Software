package Modelo;

import java.util.ArrayList;
import java.util.List;
import repository.Validavel;

public class Pessoa extends Entidade implements Validavel {

    private String nome;
    private TipoPessoa tipoPessoa;
    private List<Endereco> enderecos;

    public Pessoa() {
        this.enderecos = new ArrayList<>();
    }

    public Pessoa(int codigo, String nome, String tipoPessoa) {
        super(codigo);
        this.nome = nome;
        this.tipoPessoa = TipoPessoa.fromString(tipoPessoa);
        this.enderecos = new ArrayList<>();
    }

    public Pessoa(int codigo, String nome, TipoPessoa tipoPessoa) {
        super(codigo);
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.enderecos = new ArrayList<>();
    }

    @Override
    public boolean isValido() {
        if (nome == null || nome.trim().isEmpty()) return false;
        if (nome.matches("\\d+")) return false;
        if (tipoPessoa == null) return false;
        return true;
    }

    @Override
    public String getMensagemErro() {
        if (nome == null || nome.trim().isEmpty()) return "Nome não pode ser vazio.";
        if (nome.matches("\\d+")) return "Nome não pode ser apenas números.";
        if (tipoPessoa == null) return "Tipo de pessoa não informado.";
        return "";
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public List<Endereco> getEnderecos() { return enderecos; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public TipoPessoa getTipoPessoa() { return tipoPessoa; }
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = TipoPessoa.fromString(tipoPessoa);
    }
    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String resumo() {
        return "Pessoa [" + codigo + "] " + nome + " - " + tipoPessoa;
    }
}