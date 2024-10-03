package daosImpl;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import daos.UsuariosDAO;
import modelo.Usuario;

public class UsuariosDAOImpl implements UsuariosDAO{
	
	private DataSource ds; 
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;
	
	//necesario para que por el xml de spring le demos
	//el datasource configurado en el mismo archivo
	public void setDs(DataSource ds) {
		this.ds = ds;
		System.out.println("configurando simple insert");
		this.simpleInsert = new SimpleJdbcInsert(ds);
		this.simpleInsert.withTableName("tabla_usuarios");
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public void registrarUsuario(Usuario u) {
		HashMap<String, Object> valores = 
				new HashMap<String, Object>();
		valores.put("nombre", u.getNombre());
		valores.put("email", u.getEmail());
		valores.put("pass", u.getPass());
		this.simpleInsert.execute(valores);	
	}

}
