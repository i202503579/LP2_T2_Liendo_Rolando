package com.examenT2.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_proveedor")
@Getter
@Setter
public class Proveedor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "pagina_web")
    private String paginaWeb;

    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;
}
