package camarero.lucas.app.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//anotaciones Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//anotaciones hybernate
@Entity
public class Marca {
	
	// atributos
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="tareaevaluativa")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String pais;
	
	@JsonManagedReference
	@OneToMany (mappedBy = "marca",cascade = CascadeType.ALL)
	//@JoinColumn (name = "marca_id")
	List <Guitarra> guitarras = new ArrayList<>();

	// constructor no incluido en Lombok
	public Marca(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
}

