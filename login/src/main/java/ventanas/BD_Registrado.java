package BBDD;

import DiagramaClases.BD_Principal;
import java.util.Vector;
import BBDD.Registrado;
import DiagramaClases.Usuario;

public class BD_Registrado {
	public BD_Principal _bD_Principal;
	public Vector<Registrado> _registrados = new Vector<Registrado>();

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(int aID, String aEmail, pass aString, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}
}