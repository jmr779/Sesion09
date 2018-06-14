/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteProyectoHMISData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd.Administrador bBDDAdministrador = bbdd.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			bbdd.AdministradorDAO.delete(bBDDAdministrador);
			bbdd.Registrado bBDDRegistrado = bbdd.RegistradoDAO.loadRegistradoByQuery(null, null);
			// Delete the persistent object
			bbdd.RegistradoDAO.delete(bBDDRegistrado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteProyectoHMISData deleteProyectoHMISData = new DeleteProyectoHMISData();
			try {
				deleteProyectoHMISData.deleteTestData();
			}
			finally {
				bbdd.ProyectoHMISPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
