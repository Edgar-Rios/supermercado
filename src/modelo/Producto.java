package modelo;

public class Producto {
	private int idProducto;
	private String producto;
	private float precio;
	/**
	 * @param idProducto
	 * @param producto
	 * @param precio
	 */
	public Producto(int idProducto, String producto, float precio) {
		super();
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
	}
	/**
	 * @return the idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	private void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public boolean equals(Producto producto) {
		if (this.idProducto == producto.idProducto)
			return false;
		
		return false;
	}
	
	
}
