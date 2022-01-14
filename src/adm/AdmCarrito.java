package adm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Carrito;
import modelo.Cliente;
import modelo.ItemCarrito;
import modelo.Producto;

public class AdmCarrito {

	private static int ID = 0;
	private List<Carrito> lstCarrito;

	/**
	 * @param lstCarrito
	 */
	public AdmCarrito() {
		super();
		this.lstCarrito = new ArrayList<Carrito>();
	}

	/**
	 * @return the lstCarrito
	 */
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	/**
	 * @param lstCarrito the lstCarrito to set
	 */
	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	/*
	 * METODOS--------------------------------------
	 */

	public boolean clienteTieneCarrito(Cliente cliente) {
		for (Carrito carrito : this.lstCarrito) {
			if (carrito.getCliente().equals(cliente))
				return true;
		}

		return false;
	}

	public boolean add(LocalDate fecha, LocalTime hora, Cliente cliente) {
		ID++;
		Carrito carrito = new Carrito(ID, fecha, hora, cliente);
		this.lstCarrito.add(carrito);
		return true;
	}

	public Carrito get(int idCarrito) {
		Carrito carrito = null;

		for (Carrito c : this.lstCarrito) {
			if (c.getIdCarrito() == idCarrito) {
				carrito = c;
				break;
			}
		}

		return carrito;
	}

	public boolean dlt(int idCarrito) throws Exception {
		Carrito carrito = get(idCarrito);

		if (carrito == null)
			throw new Exception("ERROR: no existe carrito con id " + idCarrito + " en el sistema");

		int index = this.lstCarrito.indexOf(carrito);
		this.lstCarrito.remove(index);
		return true;
	}

	// ------------------------------------------
	public float calcularTotal(Cliente cliente) {
		long total = 0;

		for (Carrito carrito : this.lstCarrito) {
			if (carrito.getCliente().equals(cliente))
				total += carrito.calcularTotal();
		}

		return total;
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		float total = 0;

		for (Carrito carrito : this.lstCarrito) {
			if (carrito.getFecha().isAfter(fechaInicio) && carrito.getFecha().isBefore(fechaFin))
				total += carrito.calcularTotal();
		}

		return total;
	}

	public float calcularTotal(LocalDate fecha) {
		float total = 0;

		for (Carrito carrito : this.lstCarrito) {
			if (carrito.getFecha().isEqual(fecha))
				total += carrito.calcularTotal();
		}

		return total;
	}

	public float calcularTotal(int mes, int anio) {
		float total = 0;

		for (Carrito carrito : this.lstCarrito) {
			LocalDate fecha = carrito.getFecha();
			if ((fecha.getMonthValue() == mes) && (fecha.getYear() == anio))
				total += carrito.calcularTotal();
		}

		return total;
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) {
		float total = 0;

		for (Carrito carrito : this.lstCarrito) {
			if (carrito.getFecha().isAfter(fechaInicio) && carrito.getFecha().isBefore(fechaFin))
				if (carrito.getCliente().equals(cliente))
					total += carrito.calcularTotal();
		}

		return total;
	}

	public float calcularTotal(LocalDate fecha, Cliente cliente) {
		float total = 0;

		for (Carrito carrito : this.lstCarrito) {
			if (carrito.getFecha().isEqual(fecha))
				if (carrito.getCliente().equals(cliente))
					total += carrito.calcularTotal();
		}

		return total;
	}

	public float calcularTotal(int mes, int anio, Cliente cliente) {
		float total = 0;

		for (Carrito carrito : this.lstCarrito) {
			LocalDate fecha = carrito.getFecha();
			if ((fecha.getMonthValue() == mes) && (fecha.getYear() == anio))
				if (carrito.getCliente().equals(cliente))
					total += carrito.calcularTotal();
		}

		return total;
	}
}
