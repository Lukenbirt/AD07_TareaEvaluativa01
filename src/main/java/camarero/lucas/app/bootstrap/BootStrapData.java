/*
package camarero.lucas.app.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import camarero.lucas.app.domain.Guitarra;
import camarero.lucas.app.domain.Marca;
import camarero.lucas.app.repository.RepositorioGuitarra;
import camarero.lucas.app.repository.RepositorioMarca;
import jakarta.transaction.Transactional;

@Component
public class BootStrapData implements CommandLineRunner{
	
	// traigo los repositorios
	@Autowired
	private RepositorioGuitarra rg;
	@Autowired
	private RepositorioMarca rm;
	
	// realizo todo en una transacción para que no haya problemas al ser una relación
	// bidireccional la que hay entre guitarra y marca
	@Transactional
	// sobreescribo el run
	@Override
	public void run(String... arg0) throws Exception {
		
		// creo los objetos
		Guitarra g = new Guitarra("Stratocaster", "Sunburst", 22);
		Marca m = new Marca("Fender", "USA");
		g.setMarca(m);
		m.getGuitarras().add(g);
		
		// guardo los objetos en la bbdd
		rm.save(m);
		rg.save(g);
	}
}
*/
