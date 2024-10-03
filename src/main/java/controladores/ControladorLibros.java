package controladores;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daosImpl.LibrosDAOImpl;
import modelo.Libro;

@Controller
@RequestMapping("admin/")
public class ControladorLibros {

	// una forma muy comoda que nos da spring
	// para pedir una bean es esta:
	@Autowired
	private LibrosDAOImpl librosDAO;

	/*
	 * basicamente asi le hemos dicho a spring que nos de la unica bean que tenga de
	 * la unica clase que este implementando el interfaz SombrerosDAO
	 */
//lo que pongamos en @RequestMapping es la ruta que atiende el siguiente metodo
	@RequestMapping("admin/libros")
	public String obtenerLibros(Model model) {
		List<Libro> libros = librosDAO.obtenerLibros();
		model.addAttribute("libros", libros);
		return "admin/libros";// esto es la jsp que se muestra
	}

	@RequestMapping("admin/libros-borrar")
	public String borrarLibros(String id, Model model) {
//	Lo suyo seria validar la id antes de nada	
		librosDAO.borrarLibro(Integer.parseInt(id));
		return obtenerLibros(model);
	}

	@RequestMapping("libros-nuevo")
	public String nuevoLibro(Model model) {
		/*
		 * ahora vamos a mostrarle al usuario un formulario para registrar un libro
		 * spring mvc nos pide que le mandemos al formulario un objeto indicando el
		 * valor por defecto de cada campo
		 */
		Libro l = new Libro();
		l.setPrecio(1);
		model.addAttribute("nuevo-libro", 1);
		return "/admin/libros-nuevo";
	}

	@RequestMapping("libros-guardar-nuevo")
	public String guardarNuevoLibro(Libro nuevoLibro, Model model, HttpServletRequest request) {
//		lo suyo seria validar el libro antes de nada
		librosDAO.registrarLibro(nuevoLibro);
		/*
		 * nuevoLibro ya tiene el archivo subido, simplemente queremos guardar el
		 * archivo en una ruta concreta el proyecto realmente se esta ejecutando en una
		 * ruta distinta a la del workspace. necesitamos saber esa ruta:
		 */
		String rutaRealDelProyecto = request.getServletContext().getRealPath("");
//		vamos a crear una carpeta para las subidas de archivos:
		File rutaSubidas = new File(rutaRealDelProyecto + "/subidas");
		if (!rutaSubidas.exists()) {
			rutaSubidas.mkdirs();
		}
		String nombreArchivo = nuevoLibro.getId() + ".jpg";
		// Guardar el archivo subido a la ruta indicada
		try {
			nuevoLibro.getPortada().transferTo(new File(rutaSubidas, nombreArchivo));
			System.out.println("portada del producto subida en:" + rutaRealDelProyecto + "/subidas");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obtenerLibros(model);
	}

}
