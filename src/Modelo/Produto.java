package Modelo;

import repository.Validavel;

public class Produto extends Entidade implements Validavel {

    private String descricao;
    private double custo;
    private double precoVenda;
    private int codigoFornecedor;

    public Produto() {}

    public Produto(int codigo, String descricao, double custo,
                   double precoVenda, int codigoFornecedor) {
        super(codigo);
        this.descricao = descricao;
        this.custo = custo;
        this.precoVenda = precoVenda;
        this.codigoFornecedor = codigoFornecedor;
    }

    @Override
    public boolean isValido() {
        if (descricao == null || descricao.trim().isEmpty()) return false;
        if (custo < 0) return false;
        if (precoVenda <= 0) return false;
        if (codigoFornecedor <= 0) return false;
        return true;
    }

    @Override
    public String getMensagemErro() {
        if (descricao == null || descricao.trim().isEmpty()) return "Descrição não pode ser vazia.";
        if (custo < 0) return "Custo não pode ser negativo.";
        if (precoVenda <= 0) return "Preço de venda deve ser maior que zero.";
        if (codigoFornecedor <= 0) return "Código do fornecedor inválido.";
        return "";
    }

    public String getDescricao()               { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getCusto()                   { return custo; }
    public void setCusto(double custo)         { this.custo = custo; }

    public double getPrecoVenda()              { return precoVenda; }
    public void setPrecoVenda(double p)        { this.precoVenda = p; }

    public int getCodigoFornecedor()           { return codigoFornecedor; }
    public void setCodigoFornecedor(int c)     { this.codigoFornecedor = c; }

    @Override
    public String resumo() {
        return "Produto [" + codigo + "] " + descricao +
                " - Custo: R$ " + custo + " | Venda: R$ " + precoVenda;
    }
}