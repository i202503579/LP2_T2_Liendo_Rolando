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
@Table(name = "tbl_orden_compra")
@Getter @Setter
public class OrdenCompraLiendo {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "nro_orden")
	    private Integer nroOrden;

	    @Column(name = "monto")
	    private Double monto;

	    @Column(name = "direccion_entrega")
	    private String direccionEntrega;

	    @Column(name = "fecha_entrega")
	    private LocalDate fechaEntrega;

	    @Column(name = "estado")
	    private String estado;

	    @ManyToOne
	    @JoinColumn(name = "id_proveedor")
	    private ProveedorLiendo proveedor;
}
