package Modelo;

public enum TipoPessoa {
    CLIENTE,
    FORNECEDOR,
    AMBOS;
    a

    public static TipoPessoa fromString(String valor) {
        return TipoPessoa.valueOf(valor.trim().toUpperCase());
    }
}
