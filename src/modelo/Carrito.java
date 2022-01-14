package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;
	private boolean isCerrado;

	/**
	 * @param idCarrito
	 * @param fecha
	 * @param hora
	 * @param lstItem
	 * @param cliente
	 * @param isCerrado
	 */
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = new ArrayList<ItemCarrito>();
		this.cliente = cliente;
		this.isCerrado = false;
	}

	/**
	 * @return the idCarrito
	 */
	public int getIdCarrito() {
		return idCarrito;
	}

	/**
	 * @param idCarrito the idCarrito to set
	 */
	private void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the hora
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	/**
	 * @return the lstItem
	 */
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	/**
	 * @param lstItem the lstItem to set
	 */
	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return this.cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean getCerrado() {
		return this.isCerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.isCerrado = isCerrado;
	}

	/*
	 * METODOS
	 * 
	 */

	public boolean agregarItem(Producto producto, int cantidad) {
		ItemCarrito item = getItemList(producto);
		
		if (item == null) {
			int id = this.lstItem.size()+1;
			item = new ItemCarrito(id, producto, cantidad);
			this.lstItem.add(item);
		} else {
			int cantidadActual = item.getCantidad();
			item.setCantidad(cantidadActual + cantidad);
		}

		return true;
	}

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		ItemCarrito item = getItemList(producto);

		if (item == null)
			throw new Exception("ERROR: el producto en la lista del carrito");

		if (cantidad >= item.getCantidad()) {
			int index = this.lstItem.indexOf(item);
			this.lstItem.remove(index);
			this.acomodarItemsId();
		} else {
			int cantidadActual = item.getCantidad();
			item.setCantidad(cantidadActual - cantidad);
		}

		return true;
	}

	private ItemCarrito getItemList(Producto producto) {
		ItemCarrito item = null;
		for (ItemCarrito ic : this.lstItem) {
			if (ic.getProducto().equals(producto)) {
				item = ic;
				break;
			}
		}

		return item;
	}

	public float calcularTotal() {
		float total = 0;

		for (ItemCarrito item : this.lstItem) {
			total += item.calcularSubTotal();
		}

		return total;
	}

	private void acomodarItemsId() {
		for (int i = 0; i < this.lstItem.size(); i++) {
			this.lstItem.get(i).setIdItem(i + 1);
		}
	}

}
