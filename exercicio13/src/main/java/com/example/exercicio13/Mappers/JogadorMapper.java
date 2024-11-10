package com.example.exercicio13.Mappers;

import com.example.exercicio13.DTOs.JogadorResponseDTO;
import com.example.exercicio13.Models.JogadorEntity;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {
    public JogadorResponseDTO toDTO(JogadorEntity jogador) {
        return new JogadorResponseDTO(
                jogador.getNome(),
                jogador.getApelido(),
                jogador.getHabilidade()
        );
    }
}
