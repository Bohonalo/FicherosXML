package dom;

import java.io.Serializable;

public class EmpleadoDepto implements Serializable {

	private static final long serialVersionUID = 5708919249503688448L;
	
	private int id;
	private String nombre;
	private Departamento dep;
	private double salario;
	
	
	public EmpleadoDepto(int id, String nombre, Departamento dep, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dep = dep;
		this.salario = salario;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Departamento getDep() {
		return dep;
	}
	
	public void setDep(Departamento dep) {
		this.dep = dep;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
