package camarero.lucas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import camarero.lucas.app.domain.Marca;

public interface RepositorioMarca extends JpaRepository<Marca, Integer>{

}
