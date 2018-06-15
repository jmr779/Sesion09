package ventanas;

import java.util.Date;

public interface iUsuario{

	public void eliminarUsuario(int aID);

	public void crearUsuario(int aID, String aEmail, String aPass, Date aFechaCreacion, Date aFechaUltimoAcceso);

	public Usuario listarUsuarios();

	public void registrarse(String aEmail, String aPass, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso);

	public void modificarDatos(String aEmail, String aPass);

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo);
}