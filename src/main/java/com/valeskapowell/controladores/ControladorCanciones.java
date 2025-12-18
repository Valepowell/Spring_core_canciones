package com.valeskapowell.controladores;

import com.valeskapowell.modelos.Cancion;
import com.valeskapowell.servicios.ServicioArtistas;
import com.valeskapowell.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorCanciones {

	@Autowired
	private ServicioCanciones servicio;
	
	@Autowired
	private ServicioArtistas servicioArtistas;
	
	// MOSTRAR CANCIONES
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {

	List<Cancion> canciones = servicio.obtenerTodasLasCanciones();

	System.out.println("Cantidad de canciones: " + canciones.size());

	model.addAttribute("listaCanciones", canciones);

	return "canciones";
	}
	
	// DETALLE CANCION
	@GetMapping("/canciones/detalle/{id}")
	public String desplegarDetalleCancion(@PathVariable Long id, Model model) {
	Cancion cancion = servicio.obtenerCancionPorId(id);

	if (cancion == null) {
		return "redirect:/canciones";
	}

	model.addAttribute("cancion", cancion);
		return "detalleCancion";
	}
	
	// REDIRECCIONAR A CANCIONES
	@GetMapping("/")
	public String index() {
		return "redirect:/canciones";
	}

	    // FORMULARIO
    @GetMapping("canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    // PROCESAR FORMULARIO
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult result,
        @RequestParam("artistaId") Long artistaId,
        Model model) {

    if (result.hasErrors()) {
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    cancion.setArtista(servicioArtistas.obtenerArtistaPorId(artistaId));
    servicio.agregarCancion(cancion);

    return "redirect:/canciones";
}

	// FORMULARIO EDITAR
	@GetMapping("canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(
            @PathVariable("idCancion") Long idCancion,
            Model model) {

        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "editarCancion";
    }

	@PostMapping("canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult result,
            @PathVariable("idCancion") Long idCancion,
            @RequestParam("artistaId") Long artistaId,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }

        cancion.setId(idCancion);
        cancion.setArtista(servicioArtistas.obtenerArtistaPorId(artistaId));
        servicio.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    // ELIMINAR CANCION
    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicio.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }
}


