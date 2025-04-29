package camarero.lucas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import camarero.lucas.app.domain.Guitarra;
import camarero.lucas.app.repository.RepositorioGuitarra;
import camarero.lucas.app.repository.RepositorioMarca;

@Controller
@RequestMapping ("/guitarras")
public class GuitarraController {
	// traigo los repositorios
	@Autowired
   	private RepositorioGuitarra rg;
	@Autowired
   	private RepositorioMarca rm;
	
	// borra una guitarra y redirige a guitarras para sacar un listado
	@GetMapping("/delete/{id}")
	public String borrarGuitarra(@PathVariable("id") int id) {
		rg.deleteById(id);
		return "redirect:/guitarras";
	}
	
	// dirige al formulario para crear una guitarra
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Guitarra g = new Guitarra();
		model.addAttribute("guitarra", g);
		model.addAttribute("marcas", rm.findAll());
		return "guitarraForm";
	}
	
	// inserta la guitarra en la bbdd y redirige a guitarras para sacar un listado
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Guitarra g) {
		rg.save(g);
		return "redirect:/guitarras";
	}
	
	// dirige al formulario para editar una guitarra
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("guitarra", rg.findById(id));
		model.addAttribute("marcas", rm.findAll());
		return "guitarraForm";
	}
}