package camarero.lucas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import camarero.lucas.app.repository.RepositorioGuitarra;
import camarero.lucas.app.repository.RepositorioMarca;

@Controller
public class MainController {
	
	// traigo los repositorios
	@Autowired
   	private RepositorioGuitarra rg;
	@Autowired
   	private RepositorioMarca rm;
	
	// dirige a index
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	// dirige a guitarras y muestra un listado de las mismas
	@GetMapping ({"/guitarras"})
	public String getGuitarras(Model model) {
		model.addAttribute("guitarras", rg.findAll());
		return "guitarras";
	}
	
	// dirige a marcas y muestra un listado de las mismas
	@GetMapping ({"/marcas"})
	public String getMarcas(Model model) {
		model.addAttribute("marcas", rm.findAll());
		return "marcas";
	}
}
	

