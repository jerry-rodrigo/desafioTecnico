package com.desafioTecnico.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_cambio")
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;
    private String monedaOrigen;
    private String monedaDestino;
    private Double montoConTipoCambio;
    private Double tipoCambio;
    private String solicitante;

    @CreatedDate
    private LocalDateTime fechaSolicitud;

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
        // Calcula el montoConTipoCambio al establecer el tipoCambio
        this.montoConTipoCambio = monto * tipoCambio;
    }
}
