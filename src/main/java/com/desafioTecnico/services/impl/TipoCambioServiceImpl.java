package com.desafioTecnico.services.impl;

import com.desafioTecnico.models.TipoCambio;
import com.desafioTecnico.repositories.ITipoCambioRepository;
import com.desafioTecnico.services.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private ITipoCambioRepository tipoCambioRepository;

    @Override
    public List<TipoCambio> obtenerTodos() {
        return tipoCambioRepository.findAll();
    }

    @Override
    public TipoCambio obtenerPorId(Long id) {
        return tipoCambioRepository.findById(id).orElse(null);
    }

    @Override
    public TipoCambio crearTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public TipoCambio actualizarTipoCambio(Long id, TipoCambio tipoCambio) {
        // Verifica si el tipo de cambio existe antes de actualizar
        if (tipoCambioRepository.existsById(id)) {
            tipoCambio.setSolicitante("UsuarioActualizado");
            tipoCambio.setFechaSolicitud(LocalDateTime.now());
            return tipoCambioRepository.save(tipoCambio);
        } else {
            return createEmpty();
        }
    }

    @Override
    public void eliminarTipoCambio(Long id) {
        tipoCambioRepository.deleteById(id);
    }

    public static TipoCambio createEmpty() {
        TipoCambio tipoCambio = new TipoCambio();
        tipoCambio.setId(-1L);
        return tipoCambio;
    }
}
