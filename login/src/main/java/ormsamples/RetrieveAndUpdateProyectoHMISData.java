/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateProyectoHMISData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd.Administrador bBDDAdministrador = bbdd.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			bbdd.AdministradorDAO.save(bBDDAdministrador);
			bbdd.Registrado bBDDRegistrado = bbdd.RegistradoDAO.loadRegistradoByQuery(null, null);
			// Update the properties of the persistent object
			bbdd.RegistradoDAO.save(bBDDRegistrado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		bbdd.AdministradorCriteria bBDDAdministradorCriteria = new bbdd.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//bBDDAdministradorCriteria.ID.eq();
		System.out.println(bBDDAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Registrado by RegistradoCriteria");
		bbdd.RegistradoCriteria bBDDRegistradoCriteria = new bbdd.RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//bBDDRegistradoCriteria.ID.eq();
		System.out.println(bBDDRegistradoCriteria.uniqueRegistrado());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateProyectoHMISData retrieveAndUpdateProyectoHMISData = new RetrieveAndUpdateProyectoHMISData();
			try {
				retrieveAndUpdateProyectoHMISData.retrieveAndUpdateTestData();
				//retrieveAndUpdateProyectoHMISData.retrieveByCriteria();
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
