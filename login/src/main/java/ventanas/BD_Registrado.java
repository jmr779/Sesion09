package ventanas;


import java.awt.List;
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
	
	public boolean login(String user, String pass) throws PersistentException {
		java.util.List usu = null;
		String nombre = "";
		String cont = "";
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			/*usu = bbdd.RegistradoDAO.queryRegistrado(null, null);
			for(int i =0; i<= usu.size();i++) {
				usu.get(i).get
			}*/
			usu = bbdd.RegistradoDAO.queryRegistrado(null, null);
			for(int i =0; i<= usu.size();i++) {
				nombre = bbdd.RegistradoDAO.getRegistradoByORMID(i).getNombre();
				cont = bbdd.RegistradoDAO.getRegistradoByORMID(i).getPass();
				if(user == nombre && cont == pass) {
					return true;
				}
			}
			return false;
		} catch (PersistentException e) {
			t.rollback();
		}
		return false;
	}

	
}
