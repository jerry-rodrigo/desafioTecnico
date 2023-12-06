package com.desafioTecnico.controller;

import com.desafioTecnico.models.TipoCambio;
import com.desafioTecnico.services.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-cambio")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    @GetMapping("/listar")
    public List<TipoCambio> obtenerTiposCambio() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        // Agrega el nombre de usuario a los registros obtenidos
        List<TipoCambio> tiposCambio = tipoCambioService.obtenerTodos();
        tiposCambio.forEach(tc -> tc.setSolicitante(username));

        return tiposCambio;
    }

    @GetMapping("listarId/{id}")
    public TipoCambio obtenerTipoCambioPorId(@PathVariable Long id) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        // Obtiene el tipo de cambio por ID y agrega el nombre de usuario
        TipoCambio tipoCambio = tipoCambioService.obtenerPorId(id);
        tipoCambio.setSolicitante(username);
        return tipoCambio;
    }

    @PostMapping("/crear")
    public TipoCambio crearTipoCambio(@RequestBody TipoCambio tipoCambio) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        //tipoCambio.setSolicitante(tipoCambio.getSolicitante());
        tipoCambio.setSolicitante(username);
        tipoCambio.setFechaSolicitud(LocalDateTime.now());
        return tipoCambioService.crearTipoCambio(tipoCambio);
    }

    @PutMapping("actualizar/{id}")
    public TipoCambio actualizarTipoCambio(@PathVariable Long id, @RequestBody TipoCambio tipoCambio) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        // Agrega el nombre de usuario al tipo de cambio antes de actualizarlo
        tipoCambio.setSolicitante(username);
        return tipoCambioService.actualizarTipoCambio(id, tipoCambio);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarTipoCambio(@PathVariable Long id) {
        tipoCambioService.eliminarTipoCambio(id);
    }
}