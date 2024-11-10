package com.example.exercicio13.Services;

import com.example.exercicio13.DTOs.JogadorRequestDTO;
import com.example.exercicio13.DTOs.JogadorResponseDTO;
import com.example.exercicio13.Mappers.JogadorMapper;
import com.example.exercicio13.Models.JogadorEntity;
import com.example.exercicio13.Repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JogadorService {
    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    JogadorMapper jogadorMapper;

    public JogadorResponseDTO inserirJogador(JogadorRequestDTO jogadorRequestDTO) {
        Integer randomHabilidade = new Random().nextInt(0, 100);

        JogadorEntity jogador = new JogadorEntity();
        jogador.setNome(jogadorRequestDTO.nome());
        jogador.setApelido(jogadorRequestDTO.apelido());
        jogador.setHabilidade(randomHabilidade);

        jogadorRepository.save(jogador);

        return jogadorMapper.toDTO(jogador);
    }

    public List<JogadorResponseDTO> listarJogadores() {
        return jogadorRepository.findAll().stream().map(jogadorMapper::toDTO).toList();
    }

}
