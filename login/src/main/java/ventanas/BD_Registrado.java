package ventanas;


import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd.Registrado;

public class BD_Registrado {
	public BD_Principal _bD_Principal;
	public Vector<Registrado> _registrados = new Vector<Registrado>();

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso, String aPass, String rol) throws PersistentException {
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd.Registrado r = bbdd.RegistradoDAO.createRegistrado();
			r.setNombre(aNombre);
			r.setEmail(aEmail);
			r.setActivo(true);
			r.setPass(aPass);
			r.setFechaCreacion(aFechaCreacion);
			r.setFechaUltimoAcceso(aFechaUltimoAcceso);
			r.setRol(rol);
			bbdd.RegistradoDAO.save(r);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(int aID, String aEmail, String aPass, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}
	
	public List cargarUsuarios() throws PersistentException {
		List us = null;
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			us = bbdd.RegistradoDAO.queryRegistrado(null, null);
		} catch (PersistentException e) {
			t.rollback();
		}
		return us;
	}
	
	public List cargarUsuarios2() throws PersistentException {
		List us = null;
			us = bbdd.RegistradoDAO.queryRegistrado(null, null);
		return us;
	}
}