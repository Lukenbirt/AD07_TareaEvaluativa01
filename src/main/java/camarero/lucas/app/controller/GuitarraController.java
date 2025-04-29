package camarero.lucas.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import camarero.lucas.app.domain.Guitarra;
import camarero.lucas.app.repository.RepositorioGuitarra;

@RestController
@RequestMapping ("/guitarras")
public class GuitarraController {
	// traigo el repositorio
	@Autowired
   	private RepositorioGuitarra rg;
	
	// devuelve el listado de guitarras
	@GetMapping({"/",""})
	public List <Guitarra> index() {
		return rg.findAll();
	}
	
	// devuelve una guitarra en particular
	@GetMapping("/{id}")
	public Guitarra show(@PathVariable("id") int id) {
		return rg.findById(id).orElse(null);
	}
	
	// crea una guitarra
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Guitarra create(@RequestBody Guitarra guitarra) {
		return rg.save(guitarra);
	}
	
	// actualiza una guitarra
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Guitarra update(@RequestBody Guitarra guitarra, @PathVariable("id") int id) {
		Guitarra tempGuitarra = rg.findById(id).orElse(null);
		
		tempGuitarra.setNombre(guitarra.getNombre());
		tempGuitarra.setColor(guitarra.getColor());
		tempGuitarra.setTrastes(guitarra.getTrastes());
		tempGuitarra.setMarca(guitarra.getMarca());

		return rg.save(tempGuitarra);
	}
	
	// borra una guitarra
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) {
		rg.deleteById(id);
	}

}