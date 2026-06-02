package Modelo;

public enum TipoPessoa {
    CLIENTE,
    FORNECEDOR,
    AMBOS;

    public static TipoPessoa fromString(String valor) {
        return TipoPessoa.valueOf(valor.trim().toUpperCase());
    }
}
