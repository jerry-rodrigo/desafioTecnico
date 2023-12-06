package com.desafioTecnico.services;

import com.desafioTecnico.models.TipoCambio;
import java.util.List;

public interface TipoCambioService {
    List<TipoCambio> obtenerTodos();

    TipoCambio obtenerPorId(Long id);

    TipoCambio crearTipoCambio(TipoCambio tipoCambio);

    TipoCambio actualizarTipoCambio(Long id, TipoCambio tipoCambio);

    void eliminarTipoCambio(Long id);
}
