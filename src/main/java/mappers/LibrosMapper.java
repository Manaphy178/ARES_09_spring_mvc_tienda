package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.Libro;

//con spring jdbc tenemos que definir a parte
//como formar un objeto de Libro cuando pidamos 
//libros a la base de datos

public class LibrosMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int arg1) throws SQLException {
		Libro l = new Libro();
		l.setTitulo(rs.getString("titulo"));
		l.setDescripcion(rs.getString("descripcion"));
		l.setPrecio(rs.getDouble("precio"));
		l.setId(rs.getLong("id"));
		return l;
	}

}
