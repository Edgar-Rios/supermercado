package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCliente {
	
	private static int ID = 0;
	
	private List<Cliente> lstCliente;

	/**
	 * @param lstCliente
	 */
	public AdmCliente() {
		super();
		this.lstCliente = new ArrayList<Cliente>();
	}

	/**
	 * @return the lstCliente
	 */
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	/**
	 * @param lstCliente the lstCliente to set
	 */
	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	/*
	 * METODOS--------------------------
	 */

	public Cliente get(int idCliente) {
		Cliente cliente = null;
		
		for(Cliente c : this.lstCliente) {
			if(c.getIdCliente() == idCliente) {
				cliente = c;
				break;
			}
		}
		
		return cliente;
	}
	
	public Cliente get(long dni) {
		Cliente cliente = null;
		
		for(Cliente c : this.lstCliente) {
			if(c.getDni() == dni) {
				cliente = c;
				break;
			}
		}
		
		return cliente;
	}
	
	public boolean add(String nombre, long dni, String direccion) throws Exception {
		
		if(get(dni) != null) throw new Exception("ERROR: el cliente ya existe en el sistema");
		
		ID++;
		Cliente cliente = new Cliente(ID, nombre, dni, direccion);
		this.lstCliente.add(cliente);
		return true;
	}
	
	public boolean dlt(Cliente cliente) {
		int index = this.lstCliente.indexOf(cliente);
		
		this.lstCliente.remove(index);
		return true;
	}
}
