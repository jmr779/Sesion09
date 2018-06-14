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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Registrado")
public class Registrado implements Serializable {
	public Registrado() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BBDD_REGISTRADO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BBDD_REGISTRADO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Pass", nullable=true, length=255)	
	private String pass;
	
	@Column(name="Activo", nullable=false, length=1)	
	private boolean activo;
	
	@Column(name="FechaCreacion", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaCreacion;
	
	@Column(name="FechaUltimoAcceso", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaUltimoAcceso;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPass(String value) {
		this.pass = value;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setActivo(boolean value) {
		this.activo = value;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setFechaCreacion(java.util.Date value) {
		this.fechaCreacion = value;
	}
	
	public java.util.Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaUltimoAcceso(java.util.Date value) {
		this.fechaUltimoAcceso = value;
	}
	
	public java.util.Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
