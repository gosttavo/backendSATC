package com.example.exercicio12.Models;

public class Conta {
    private String codigo;
    private String cliente;
    private Double saldo;

    public Conta(String codigo, String cliente, Double saldo) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
