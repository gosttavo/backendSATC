package com.example.exercicio12.Mappers;
import com.example.exercicio12.DTOs.ContaDTO;
import com.example.exercicio12.Models.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper {
    public ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
