package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {

	private static int ID = 0;

	private List<Producto> lstProducto;

	/**
	 * @param lstProducto
	 */
	public AdmProducto() {
		super();
		this.lstProducto = new ArrayList<Producto>();
	}

	/**
	 * @return the lstProducto
	 */
	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	/**
	 * @param lstProducto the lstProducto to set
	 */
	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
	
	/*
	 * METODOS----------------------------------------
	 */
	
	
	
	public Producto get(int idProducto) {
		Producto producto = null;

		for (Producto p : this.lstProducto) {
			if (p.getIdProducto() == idProducto) {
				producto = p;
				break;
			}
		}

		return producto;
	}

	
	
	private boolean isNameExist(String nombreProducto) {

		for (Producto p : this.lstProducto) {
			if (p.getProducto() == nombreProducto) {
				return true;
			}
		}

		return false;
	}

	public boolean add(String nombreProducto, float precio) throws Exception {
		if (isNameExist(nombreProducto))
			throw new Exception("ERROR: el producto ya existe en la gondola");

		ID++;
		Producto producto = new Producto(ID, nombreProducto, precio);
		this.lstProducto.add(producto);

		return true;
	}

	public boolean upd(int idProducto, String nombreProducto, float precio) throws Exception {
		Producto producto = this.get(idProducto);

		if (producto == null)
			throw new Exception("ERROR: no existe ningun producto con el id ingresado");

		producto.setPrecio(precio);
		producto.setProducto(nombreProducto);
		return true;
	}

	public boolean dlt(int idProducto) throws Exception {
		Producto producto = this.get(idProducto);
		
		if(producto == null)
			throw new Exception("ERROR: no existe ningun producto con el id ingresado");
		
		int index = this.lstProducto.indexOf(producto);
		this.lstProducto.remove(index);
		return true;
	}

}
