package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import adm.AdmCarrito;

public class Supermercado {

	private AdmProducto admProducto;
	private AdmCliente admCliente;
	private AdmCarrito admCarrito;

	/**
	 * @param lstProducto
	 */
	public Supermercado() {
		super();
		this.admProducto = new AdmProducto();
		this.admCliente = new AdmCliente();
		this.admCarrito = new AdmCarrito();
	}

	/*
	 * METODOS
	 * 
	 */

	// PRODUCTOS

	public boolean agregarProducto(String nombreProducto, float precio) throws Exception {
		return this.admProducto.add(nombreProducto, precio);
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		return this.admProducto.dlt(idProducto);
	}

	// --------------------------------------

	// CLIENTES
	public boolean agregarCliente(String nombre, long dni, String direccion) throws Exception {
		return this.admCliente.add(nombre, dni, direccion);
	}

	public Cliente traerCLiente(int idCliente) {
		return this.admCliente.get(idCliente);
	}

	public boolean eliminarCliente(int idCliente) throws Exception {
		Cliente cliente = this.admCliente.get(idCliente);

		if (cliente == null)
			throw new Exception("ERROR: no existe dentro del sistema nigun cliente con id: " + idCliente);

		if (!this.admCarrito.clienteTieneCarrito(cliente))
			throw new Exception("ERROR: el cliente tiene carritos dentro del sistema");

		this.admCliente.dlt(cliente);
		return true;
	}

	// ----------------------------------------------------------

	// CARRITOS

	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) {
		return this.admCarrito.add(fecha, hora, cliente);
	}
	
	public Carrito traerCarrito(int idCarrito) {
		return this.admCarrito.get(idCarrito);
	}
	
	public boolean eliminarCarrito(int idCarrito) throws Exception {
		return this.admCarrito.dlt(idCarrito);
	}

	//*****************************************************
	//*****************************************************
	
	public float calcularTotal(long dniCliente) throws Exception {
		Cliente cliente = this.admCliente.get(dniCliente);
		
		if(cliente == null) throw new Exception("ERROR: no existe cliente con dni " + dniCliente + " dentro del sistema");
		
		return this.admCarrito.calcularTotal(cliente);
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.admCarrito.calcularTotal(fechaInicio, fechaFin);
	}
	
	public float calcularTotal(LocalDate fecha) {
		return this.admCarrito.calcularTotal(fecha);
	}
	
	public float calcularTotal(int mes, int anio) throws Exception {
		LocalDate fecha= LocalDate.now();
		
		if(mes>12 && anio>fecha.getYear())
			throw new Exception("ERROR: fecha fuera de los parametros normales");
		
		return this.admCarrito.calcularTotal(mes, anio);
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
		
		if(!this.admCarrito.clienteTieneCarrito(cliente))
			throw new Exception("ERROR: fecha fuera de los parametros normales");
		
		return this.admCarrito.calcularTotal(fechaInicio, fechaFin, cliente);
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
		if(!this.admCarrito.clienteTieneCarrito(cliente))
			throw new Exception("ERROR: fecha fuera de los parametros normales");
		
		return this.admCarrito.calcularTotal(fecha, cliente);
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
		
		LocalDate fecha= LocalDate.now();
		if(mes>12 && anio>fecha.getYear())
			throw new Exception("ERROR: fecha fuera de los parametros normales");
		
		if(this.admCarrito.clienteTieneCarrito(cliente))
			throw new Exception("ERROR: El cliente no posee carritos de compras");
				
		return this.admCarrito.calcularTotal(mes, anio, cliente);
	}
	
}
