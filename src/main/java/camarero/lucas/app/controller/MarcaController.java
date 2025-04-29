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

import camarero.lucas.app.domain.Marca;
import camarero.lucas.app.repository.RepositorioMarca;

@RestController
@RequestMapping ("/marcas")
public class MarcaController {
	
	// traigo el repositorio
	@Autowired
   	private RepositorioMarca rm;

	// devuelve el listado de marcas
	@GetMapping({"/",""})
	public List <Marca> index() {
	return rm.findAll();
	}
	
	// devuelve una marca en particular
	@GetMapping("/{id}")
	public Marca show(@PathVariable("id") int id) {
		return rm.findById(id).orElse(null);
	}
	
	// crea una marca
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Marca create(@RequestBody Marca marca) {
		return rm.save(marca);
	}
	
	// actualiza una marca
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Marca update(@RequestBody Marca marca, @PathVariable("id") int id) {
		Marca tempMarca = rm.findById(id).orElse(null);
		
		tempMarca.setNombre(marca.getNombre());
		tempMarca.setPais(marca.getPais());		
		
		//Al ser un id diferente, el método save hace en realidad un update
		return rm.save(tempMarca);
	}
	
	// borra una marca
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) {
		rm.deleteById(id);
	}
}
