package com.example.exercicio12.Controllers;

import com.example.exercicio12.DTOs.ContaDTO;
import com.example.exercicio12.DTOs.TransacaoRequestDTO;
import com.example.exercicio12.DTOs.TransacaoResponseDTO;
import com.example.exercicio12.Mappers.ContaMapper;
import com.example.exercicio12.Models.Transacao;
import com.example.exercicio12.Services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private final TransacoesService transacoesService;
    private final ContaMapper contaMapper;

    @Autowired
    public TransacaoController(TransacoesService transacoesService, ContaMapper contaMapper) {
        this.transacoesService = transacoesService;
        this.contaMapper = contaMapper;
    }

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        Transacao transacao = transacoesService.realizarTransacao(
                request.origem(), request.destino(), request.valor());

        ContaDTO origemDTO = contaMapper.toDTO(transacao.getOrigem());
        ContaDTO destinoDTO = contaMapper.toDTO(transacao.getDestino());

        return new TransacaoResponseDTO(origemDTO, destinoDTO, transacao.getValor());
    }
}
