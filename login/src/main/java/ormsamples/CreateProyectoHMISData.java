/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateProyectoHMISData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd.Registrado bBDDRegistrado = bbdd.RegistradoDAO.createRegistrado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : activo
			bbdd.RegistradoDAO.save(bBDDRegistrado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateProyectoHMISData createProyectoHMISData = new CreateProyectoHMISData();
			try {
				createProyectoHMISData.createTestData();
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
