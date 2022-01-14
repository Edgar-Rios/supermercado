package modelo;

public class Cliente {

	private int idCliente;
	private String nombre;
	private long dni;
	private String direccion;
	/**
	 * @param idCliente
	 * @param nombre
	 * @param dni
	 * @param direccion
	 */
	public Cliente(int idCliente, String nombre, long dni, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	private void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the dni
	 */
	public long getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(long dni) {
		this.dni = dni;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public boolean equals(Cliente cliente) {
		return (this.idCliente == cliente.getIdCliente());
	}
}
