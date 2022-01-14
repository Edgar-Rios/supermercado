package modelo;

public class ItemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;
	 
	/**
	 * @param idItem
	 * @param producto
	 * @param cantidad
	 */
	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	/**
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}
	/**
	 * @param idItem the idItem to set
	 */
	protected void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float calcularSubTotal() {		
		return (this.producto.getPrecio() * this.cantidad);
	}
	
	
}
