package ventanas;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

public interface iUsuario{

	public void eliminarUsuario(int aID);

	public void crearUsuario(String aNombre, String aEmail, String aPass, boolean aActivo, Date aFechaCreacion, Date aFechaUltimoAcceso, String aRol);

	public Usuario listarUsuarios();

	public void registrarse(String aEmail, String aPass, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso, String rol);

	public void modificarDatos(String aEmail, String aPass);

	public void modificarDatosUserListado(int aID, String aEmail, String aPass, String aNombre, boolean aActivo, String aRol);

	public List cargarUsuarios();

	public List cargarUsuarios2();

}