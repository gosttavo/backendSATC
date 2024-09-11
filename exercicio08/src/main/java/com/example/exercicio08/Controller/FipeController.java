package com.example.exercicio08.Controller;

import com.example.exercicio08.Service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
public class FipeController {
    @Autowired
    private FipeService fipeService;

    @GetMapping("/fipe")
    public Object retornaMarcas () {
        return fipeService.retornaMarcas();
    }

    @PostMapping("/fipe")
    public Object getFipeCarro (@RequestBody String marca, String modelo, String ano) {
        return fipeService.retornaDadosFipe(marca, modelo, ano);
    }
}