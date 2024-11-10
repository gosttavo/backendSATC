package com.example.exercicio13.Controllers;

import com.example.exercicio13.DTOs.JogadorRequestDTO;
import com.example.exercicio13.DTOs.JogadorResponseDTO;
import com.example.exercicio13.Services.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @GetMapping("/jogadores")
    public List<JogadorResponseDTO> listarJogadores() {
        return jogadorService.listarJogadores();
    }

    @PostMapping("/jogador")
    public JogadorResponseDTO inserirJogador(@RequestBody @Valid JogadorRequestDTO jogadorRequestDTO) {
        return jogadorService.inserirJogador(jogadorRequestDTO);
    }
}
