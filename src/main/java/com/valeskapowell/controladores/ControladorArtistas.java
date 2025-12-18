package com.valeskapowell.controladores;

import com.valeskapowell.modelos.Artista;
import com.valeskapowell.servicios.ServicioArtistas;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicio;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        model.addAttribute("artistas", servicio.obtenerTodosLosArtistas());
        return "artistas";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable Long idArtista, Model model) {
        model.addAttribute("artista", servicio.obtenerArtistaPorId(idArtista));
        return "detalleArtista";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(
            @Valid @ModelAttribute("artista") Artista artista,
            BindingResult result) {

        if (result.hasErrors()) {
            return "agregarArtista";
        }

        servicio.agregarArtista(artista);
        return "redirect:/artistas";
    }
}
