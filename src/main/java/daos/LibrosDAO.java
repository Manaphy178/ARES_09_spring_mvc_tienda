package daos;

import java.util.List;

import modelo.Libro;

public interface LibrosDAO {

	List<Libro> obtenerLibros();
	
	void registrarLibro(Libro l);
	
	void borrarLibro(int id);
	
	void editarLibro(Libro l);

	Libro obtenerLibroPorId(long id);

	void actualizarLibro(Libro l);
	
}
