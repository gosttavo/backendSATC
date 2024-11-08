package com.example.exercicio12.Services;

import com.example.exercicio12.Models.Conta;
import com.example.exercicio12.Models.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {
    private final List<Conta> contas;

    public TransacoesService() {
        this.contas = new ArrayList<>();
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 2000.0));
    }

    public Transacao realizarTransacao(String origemCodigo, String destinoCodigo, Double valor) {
        Conta origem = encontrarContaPorCodigo(origemCodigo);
        Conta destino = encontrarContaPorCodigo(destinoCodigo);

        if (origem == null || destino == null || origem.getSaldo() < valor) {
            throw new IllegalArgumentException("Transação inválida");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);

        return new Transacao(origem, destino, valor);
    }

    private Conta encontrarContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}