package camarero.lucas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import camarero.lucas.app.domain.Marca;
import camarero.lucas.app.repository.RepositorioMarca;


@Controller
@RequestMapping ("/marcas")
public class MarcaController {
	
	// traigo el repositorio
	@Autowired
   	private RepositorioMarca rm;
	
	// borra una marca y redirige a marcas para sacar un listado
	@GetMapping("/delete/{id}")
	public String borrarMarca(@PathVariable("id") int id) {
		rm.deleteById(id);
		return "redirect:/marcas";
	}
	
	// dirige al formulario para crear una marca
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Marca ma = new Marca();
		model.addAttribute("marca", ma);
		return "marcaForm";
	}
		
	// inserta la marca en la bbdd y redirige a marcas para sacar un listado
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Marca ma) {
		rm.save(ma);
		return "redirect:/marcas";
	}
		
	// dirige al formulario para editar una marca
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("marca", rm.findById(id));
		return "marcaForm";
	}
}
