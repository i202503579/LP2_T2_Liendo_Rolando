package com.examenT2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.model.OrdenCompraLiendo;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraLiendo, Integer> {
    List<OrdenCompraLiendo> findAllByOrderByNroOrdenDesc();

}
