package com.examenT2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.model.OrdenCompraLiendo;
import com.examenT2.service.OrdenCompraService;
import com.examenT2.service.ProveedorService;
import com.examenT2.util.Alert;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("orden")
public class OrdenCompraController {
	 private final OrdenCompraService ordenCompraService;
	    private final ProveedorService proveedorService;
	    

	    @GetMapping("listadoLiendo")
	    public String listado(Model model) {
	        model.addAttribute("lstOrdenes", ordenCompraService.getAll());
	        return "orden/listadoLiendo";
	    }

	    @GetMapping("nuevoLiendo")
	    public String nuevo(Model model) {
	        model.addAttribute("lstProveedores", proveedorService.getAll());
	        model.addAttribute("ordenCompra", new OrdenCompraLiendo());
	        return "orden/nuevoLiendo";
	    }

	    @PostMapping("registrar")
	    public String registrar(@ModelAttribute OrdenCompraLiendo ordenCompra,
	                             Model model, RedirectAttributes flash) {
	        var response = ordenCompraService.create(ordenCompra);

	        if (!response.success()) {
	            model.addAttribute("lstProveedores", proveedorService.getAll());
	            model.addAttribute("ordenCompra", ordenCompra);
	            model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
	            return "orden/nuevoLiendo";
	        }

	        var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
	        flash.addFlashAttribute("toast", toast);
	        return "redirect:/orden/listadoLiendo";
	    }

	    @GetMapping("edicionLiendo/{id}")
	    public String edicion(@PathVariable Integer id, Model model) {
	        model.addAttribute("lstProveedores", proveedorService.getAll());
	        model.addAttribute("ordenCompra", ordenCompraService.getOne(id));
	        return "orden/edicionLiendo";
	    }

	    @PostMapping("guardarLiendo")
	    public String guardar(@ModelAttribute OrdenCompraLiendo ordenCompra,
	                           Model model, RedirectAttributes flash) {
	        var response = ordenCompraService.update(ordenCompra);

	        if (!response.success()) {
	            model.addAttribute("lstProveedores", proveedorService.getAll());
	            model.addAttribute("ordenCompra", ordenCompra);
	            model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
	            return "orden/edicionLiendo";
	        }

	        var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
	        flash.addFlashAttribute("toast", toast);
	        return "redirect:/orden/listadoLiendo";
	    }
}
