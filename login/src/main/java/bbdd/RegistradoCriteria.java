/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package bbdd;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RegistradoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression email;
	public final StringExpression pass;
	public final BooleanExpression activo;
	public final DateExpression fechaCreacion;
	public final DateExpression fechaUltimoAcceso;
	
	public RegistradoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		email = new StringExpression("email", this);
		pass = new StringExpression("pass", this);
		activo = new BooleanExpression("activo", this);
		fechaCreacion = new DateExpression("fechaCreacion", this);
		fechaUltimoAcceso = new DateExpression("fechaUltimoAcceso", this);
	}
	
	public RegistradoCriteria(PersistentSession session) {
		this(session.createCriteria(Registrado.class));
	}
	
	public RegistradoCriteria() throws PersistentException {
		this(bbdd.ProyectoHMISPersistentManager.instance().getSession());
	}
	
	public Registrado uniqueRegistrado() {
		return (Registrado) super.uniqueResult();
	}
	
	public Registrado[] listRegistrado() {
		java.util.List list = super.list();
		return (Registrado[]) list.toArray(new Registrado[list.size()]);
	}
}

