/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.CentroDAO;
import dao.DepartamentoDAO;
import modelo.Centro;
import modelo.Departamento;
import vista.DialogoAñadirCentro;
import vista.DialogoAñadirDepartamento;
import vista.VentanaMostrarCentros;
import vista.VentanaMostrarDepartamentos;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// Ventanas del sistema
	private VentanaPpal ventanaPpal;
	private VentanaMostrarCentros ventanaMostrarCentros;
	private DialogoAñadirCentro dialogoAñadirCentro;
	private VentanaMostrarDepartamentos ventanaMostrarDepartamentos;
	private DialogoAñadirDepartamento dialogoAñadirDepartamento;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;
	private DepartamentoDAO departamentoDAO;

	
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoAñadirCentro = new DialogoAñadirCentro();
		ventanaMostrarDepartamentos = new VentanaMostrarDepartamentos();
		dialogoAñadirDepartamento = new DialogoAñadirDepartamento();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoAñadirCentro.setControlador(this);
		ventanaMostrarDepartamentos.setControlador(this);
		dialogoAñadirDepartamento.setControlador(this);
		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
		departamentoDAO= new DepartamentoDAO();
	}
	
	
	/**
	 * Método que arranca el programa principal
	 */
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarListarCentros() {
		ArrayList<Centro> lista = centroDAO.obtenerCentros();
		ventanaMostrarCentros.setListaCentros(lista);
		ventanaMostrarCentros.setVisible(true);
	}
	
	public void mostrarInsertarCentros() {
		dialogoAñadirCentro.setVisible(true);
	}


	/** 
	 * Método del controlador que añade un nuevo centro a la tabla de centros
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		// Invocando a centroDAO
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Insercion del centro correcta");
			dialogoAñadirCentro.setVisible(false);
		}
	}
	
	public void mostrarListarDepartamentos() {
		ArrayList<Departamento> lista = departamentoDAO.obtenerDepartamento();
		ventanaMostrarDepartamentos.setListaDepartamento(lista);
		ventanaMostrarDepartamentos.setVisible(true);
	}
	public void mostrarInsertarDepartamentos() {
		
				ArrayList<Centro> listaCentros = centroDAO.obtenerCentros();
				dialogoAñadirDepartamento.setCentros(listaCentros);
				dialogoAñadirDepartamento.setVisible(true);
	}
	
	public void insertaDepartamento(Departamento departamento) {
	
		int resultado = departamentoDAO.insertarDepartamento(departamento);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Insercion del departamento correcta");
			dialogoAñadirCentro.setVisible(false);
		}
	}
	
	
	
}
