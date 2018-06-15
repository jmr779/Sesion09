package ventanas;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Principal implements iUsuario {
	public BD_Registrado _bD_Registrado;
	public BD_Registrado registrado = new BD_Registrado();


	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(int aID, String aEmail, String aPass, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aPass, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso) throws PersistentException{
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd.Registrado r = bbdd.RegistradoDAO.createRegistrado();
			r.setNombre(aNombre);
			r.setEmail(aEmail);
			r.setActivo(true);
			r.setPass(aPass);
			r.setFechaCreacion(aFechaCreacion);
			r.setFechaUltimoAcceso(aFechaUltimoAcceso);
			bbdd.RegistradoDAO.save(r);
			t.commit();
		} catch (Exception e) {
		t.rollback();
		}
	}

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List cargarUsuarios() {
		List user = null;
		try {
			user = registrado.cargarUsuarios();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}