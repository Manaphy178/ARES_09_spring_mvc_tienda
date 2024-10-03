package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantesSQL.ConstantesSQL;
import daos.LibrosDAO;
import mappers.LibrosMapper;
import modelo.Libro;

public class LibrosDAOImpl implements LibrosDAO {

	private DataSource ds;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	// necesario para que por el xml de spring le demos
	// el datasource configurado en el mismo archivo
	public void setDs(DataSource ds) {
		this.ds = ds;
		System.out.println("configurando simple insert");
		this.simpleInsert = new SimpleJdbcInsert(ds);
		this.simpleInsert.withTableName("tabla_libros").usingGeneratedKeyColumns("id");
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Libro> obtenerLibros() {
		List<Libro> libros = this.jdbcTemplate.query(ConstantesSQL.SQL_OBTENER_LIBROS_PORTADA, new LibrosMapper());
		return libros;
	}

	@Override
	public void registrarLibro(Libro l) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		// hay que indicar el nombre de la columna en base de datos
		// y el valor correspondiente a insertar
		valores.put("titulo", l.getTitulo());
		valores.put("descripcion", l.getDescripcion());
		valores.put("precio", l.getPrecio());
		long idGenerado = Long.parseLong(this.simpleInsert.executeAndReturnKey(valores).toString());
		l.setId(idGenerado);

	}// end registrarLibro

	@Override
	public void borrarLibro(int id) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_BORRAR_LIBRO, id);
	}

	@Override
	public void editarLibro(Libro l) {
		// TODO Auto-generated method stub
	}

	@Override
	public Libro obtenerLibroPorId(long id) {
		Libro libro = this.jdbcTemplate.queryForObject(ConstantesSQL.SQL_OBTENER_LIBRO_POR_ID, new LibrosMapper(), id);
		return libro;
	}

	@Override
	public void actualizarLibro(Libro l) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_ACTUALIZAR_LIBRO, l.getTitulo(), l.getDescripcion(), l.getPrecio(),
				l.getId());
	}

}
