package com.example.exercicio08.Gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FipeGateway {
    private final String baseUrl = "https://parallelum.com.br/fipe/api/v1/carros";
    private final RestTemplate restTemplate = new RestTemplate();

    public String listarMarcas() {
        return restTemplate.getForObject(baseUrl + "/marcas", String.class);
    }

    public String listarModelos(String marcaId) {
        return restTemplate.getForObject(baseUrl + "/marcas/" + marcaId + "/modelos", String.class);
    }

    public String listarAnos(String marcaId, String modeloId) {
        return restTemplate.getForObject(baseUrl + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos", String.class);
    }

    public String obterValor(String marcaId, String modeloId, String anoId) {
        return restTemplate.getForObject(baseUrl + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + anoId, String.class);
    }
}
