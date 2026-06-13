package com.examenT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.model.ProveedorLiendo;
import com.examenT2.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	  private final ProveedorRepository proveedorRepository;

	    public List<ProveedorLiendo> getAll() {
	        return proveedorRepository.findAll();
	    }
}
