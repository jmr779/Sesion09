/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListProyectoHMISData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Registrado...");
		bbdd.Registrado[] bBDDRegistrados = bbdd.RegistradoDAO.listRegistradoByQuery(null, null);
		int length = Math.min(bBDDRegistrados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bBDDRegistrados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Registrado by Criteria...");
		bbdd.RegistradoCriteria bBDDRegistradoCriteria = new bbdd.RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//bBDDRegistradoCriteria.ID.eq();
		bBDDRegistradoCriteria.setMaxResults(ROW_COUNT);
		bbdd.Registrado[] bBDDRegistrados = bBDDRegistradoCriteria.listRegistrado();
		int length =bBDDRegistrados== null ? 0 : Math.min(bBDDRegistrados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bBDDRegistrados[i]);
		}
		System.out.println(length + " Registrado record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListProyectoHMISData listProyectoHMISData = new ListProyectoHMISData();
			try {
				listProyectoHMISData.listTestData();
				//listProyectoHMISData.listByCriteria();
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
