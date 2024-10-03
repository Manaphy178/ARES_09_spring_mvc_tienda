package constantesSQL;

public class ConstantesSQL {

	public final static String SQL_OBTENER_LIBROS_PORTADA = 
			"select * from tabla_libros order by id desc;";
	public final static String SQL_REGISTRAR_LIBRO = 
			"INSERT INTO `tabla_libros` (`titulo`, `descripcion`, `precio`, `id`) VALUES ( ? , ? , ? , NULL)";
	public static final String SQL_BORRAR_LIBRO = 
			"DELETE FROM tabla_libros WHERE `tabla_libros`.`id` = ? ;";
	public static final String SQL_OBTENER_LIBRO_POR_ID = 
			"select * from tabla_libros where id = ? ;";
	public static final String SQL_ACTUALIZAR_LIBRO = 
			"UPDATE `tabla_libros` SET `titulo` = ?, `descripcion` = ?, `precio` = ? WHERE `tabla_libros`.`id` = ?";
}
