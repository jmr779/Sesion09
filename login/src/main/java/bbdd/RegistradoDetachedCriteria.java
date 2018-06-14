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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RegistradoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression email;
	public final StringExpression pass;
	public final BooleanExpression activo;
	public final DateExpression fechaCreacion;
	public final DateExpression fechaUltimoAcceso;
	
	public RegistradoDetachedCriteria() {
		super(bbdd.Registrado.class, bbdd.RegistradoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		pass = new StringExpression("pass", this.getDetachedCriteria());
		activo = new BooleanExpression("activo", this.getDetachedCriteria());
		fechaCreacion = new DateExpression("fechaCreacion", this.getDetachedCriteria());
		fechaUltimoAcceso = new DateExpression("fechaUltimoAcceso", this.getDetachedCriteria());
	}
	
	public RegistradoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd.RegistradoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		pass = new StringExpression("pass", this.getDetachedCriteria());
		activo = new BooleanExpression("activo", this.getDetachedCriteria());
		fechaCreacion = new DateExpression("fechaCreacion", this.getDetachedCriteria());
		fechaUltimoAcceso = new DateExpression("fechaUltimoAcceso", this.getDetachedCriteria());
	}
	
	public Registrado uniqueRegistrado(PersistentSession session) {
		return (Registrado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Registrado[] listRegistrado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Registrado[]) list.toArray(new Registrado[list.size()]);
	}
}

