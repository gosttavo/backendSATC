package com.example.exercicio12.DTOs;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {}
