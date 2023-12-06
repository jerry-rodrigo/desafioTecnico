package com.desafioTecnico.repositories;

import com.desafioTecnico.models.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoCambioRepository extends JpaRepository<TipoCambio, Long> {
    List<TipoCambio> findBySolicitante(String solicitante);
}
