package ventanas;


import java.util.List;
import java.util.Date;
import java.util.Vector;
import bbdd.*;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;


public class BD_Registrado {
	public BD_Principal _bD_Principal;
	public Vector<Registrado> _registrados = new Vector<Registrado>();

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso, String aPass) throws PersistentException{
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
	
	public List login() throws PersistentException {
		List usu = null;
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			usu = bbdd.RegistradoDAO.queryRegistrado(null, null);
		} catch (PersistentException e) {
			t.rollback();
		}
		return usu;
	}

	
}
