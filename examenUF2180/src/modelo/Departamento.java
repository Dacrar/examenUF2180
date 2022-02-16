/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class Departamento {

	private int cod_departamento;
	private int cod_centro;
	private String tipo_dir;
	private int presupuesto;
	private String nombre;
	
	
	
	public Departamento() {
		this.tipo_dir="";
		this.nombre="";
	}



	public Departamento(int cod_departamento, int cod_centro, String tipo_dir, int presupuesto, String nombre) {
		super();
		this.cod_departamento = cod_departamento;
		this.cod_centro = cod_centro;
		this.tipo_dir = tipo_dir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}



	/**
	 * @return el cod_departamento
	 */
	public int getCod_departamento() {
		return cod_departamento;
	}



	/**
	 * @param cod_departamento el cod_departamento a establecer
	 */
	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}



	/**
	 * @return el cod_centro
	 */
	public int getCod_centro() {
		return cod_centro;
	}



	/**
	 * @param cod_centro el cod_centro a establecer
	 */
	public void setCod_centro(int cod_centro) {
		this.cod_centro = cod_centro;
	}



	/**
	 * @return el tipo_dir
	 */
	public String getTipo_dir() {
		return tipo_dir;
	}



	/**
	 * @param tipo_dir el tipo_dir a establecer
	 */
	public void setTipo_dir(String tipo_dir) {
		this.tipo_dir = tipo_dir;
	}



	/**
	 * @return el presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}



	/**
	 * @param presupuesto el presupuesto a establecer
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}



	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cod_departamento);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return cod_departamento == other.cod_departamento;
	}



	@Override
	public String toString() {
		return "Departamento [cod_departamento=" + cod_departamento + ", cod_centro=" + cod_centro + ", tipo_dir="
				+ tipo_dir + ", presupuesto=" + presupuesto + ", nombre=" + nombre + "]";
	}
	
	
	
	

	
	
}
