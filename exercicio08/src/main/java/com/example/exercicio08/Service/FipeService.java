package com.example.exercicio08.Service;

import com.example.exercicio08.Gateway.FipeGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FipeService {
    private final FipeGateway fipeGateway;

    @Autowired
    public FipeService(FipeGateway fipeGateway) {
        this.fipeGateway = fipeGateway;
    }

    public Object retornaDadosFipe(String marca, String modelo, String ano) {
        String valorFipeJson = fipeGateway.obterValor(marca, modelo, ano);

        return valorFipeJson;
    }

    public Object retornaMarcas () {
        String marcasFipeJson = fipeGateway.listarMarcas();

        return marcasFipeJson;
    }
}
