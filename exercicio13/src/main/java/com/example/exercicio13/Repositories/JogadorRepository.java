package com.example.exercicio13.Repositories;

import com.example.exercicio13.Models.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, UUID> {
}

