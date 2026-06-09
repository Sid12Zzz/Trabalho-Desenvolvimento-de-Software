package Modelo;

import java.util.ArrayList;
import java.util.List;
import repository.Validavel;

public class Pedido implements Validavel {

    private int numeroPedido;
    private Pessoa cliente;
    private String enderecoEntrega;
    private List<ItemPedido> itens;
    private double total;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(int numeroPedido, Pessoa cliente, String enderecoEntrega) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.itens = new ArrayList<>();
    }

    @Override
    public boolean isValido() {
        if (cliente == null) return false;
        if (enderecoEntrega == null || enderecoEntrega.trim().isEmpty()) return false;
        if (itens == null || itens.isEmpty()) return false;
        return true;
    }

    @Override
    public String getMensagemErro() {
        if (cliente == null) return "Pedido deve ter um cliente.";
        if (enderecoEntrega == null || enderecoEntrega.trim().isEmpty()) return "Endereço de entrega não pode ser vazio.";
        if (itens == null || itens.isEmpty()) return "Pedido deve ter pelo menos um item.";
        return "";
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularTotal();
    }

    public void calcularTotal() {
        double soma = 0;
        for (ItemPedido item : itens) {
            soma += item.getSubtotal();
        }
        this.total = soma;
    }

    public int getNumeroPedido()             { return numeroPedido; }
    public void setNumeroPedido(int n)       { this.numeroPedido = n; }

    public Pessoa getCliente()               { return cliente; }
    public void setCliente(Pessoa cliente)   { this.cliente = cliente; }

    public String getEnderecoEntrega()       { return enderecoEntrega; }
    public void setEnderecoEntrega(String e) { this.enderecoEntrega = e; }

    public List<ItemPedido> getItens()       { return itens; }

    public double getTotal()                 { return total; }
}