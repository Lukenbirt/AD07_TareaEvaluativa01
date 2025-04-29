package camarero.lucas.app.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// anotaciones Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// anotaciones hybernate
@Entity
//@Table(name="guitarra")
public class Guitarra implements Serializable{

	// atributos
	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",schema="tareaevaluativa")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
    private int id;
    
	@Column
	private String nombre;
	
	@Column
	private String color;
	
	@Column
	private int trastes;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "marca_id")
	private Marca marca;

	// constructor no incluido en Lombok
	public Guitarra(String nombre, String color, int trastes) {
		this.nombre = nombre;
		this.color = color;
		this.trastes = trastes;
	}
}
