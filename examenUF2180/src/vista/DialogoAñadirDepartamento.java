package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAñadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Controlador controlador;
	private JTextField textCodigo;
	private JTextField textNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner spinnerPresupuesto;
	private JRadioButton rdbtnFunciones;
	private JRadioButton rdbtnPropiedad;
	private Component comboCentro;
	private ArrayList<Centro> listaCentros;
	private JButton btnAceptar;
	private JButton btnCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAñadirDepartamento dialog = new DialogoAñadirDepartamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAñadirDepartamento() {
		setBounds(100, 100, 782, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][87.00][93.00][149.00][68.00][]", "[][][18.00][][][][28.00][][][]"));
		{
			JLabel lblCodigo = new JLabel("C\u00F3digo:");
			contentPanel.add(lblCodigo, "cell 0 1 2 1,alignx trailing");
		}
		{
			textCodigo = new JTextField();
			contentPanel.add(textCodigo, "cell 2 1 3 1,growx");
			textCodigo.setColumns(10);
		}
		{
			JLabel lblCentro = new JLabel("Centro:");
			contentPanel.add(lblCentro, "cell 0 3 2 1,alignx trailing");
		}
		{
			comboCentro = new JComboBox();
			contentPanel.add(comboCentro, "cell 2 3 3 1,growx");
		}
		{
			JLabel lblTipo = new JLabel("Tipo Direcci\u00F3n:");
			contentPanel.add(lblTipo, "cell 0 5 2 1,alignx right");
		}
		{
			rdbtnPropiedad = new JRadioButton("Propiedad");
			rdbtnPropiedad.setSelected(true);
			buttonGroup.add(rdbtnPropiedad);
			contentPanel.add(rdbtnPropiedad, "flowx,cell 2 5,alignx right");
		}
		{
			rdbtnFunciones = new JRadioButton("En funciones");
			buttonGroup.add(rdbtnFunciones);
			contentPanel.add(rdbtnFunciones, "cell 3 5,alignx center");
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Presupuesto:");
			contentPanel.add(lblNewLabel_3, "cell 0 7 2 1,alignx right");
		}
		{
			spinnerPresupuesto = new JSpinner();
			spinnerPresupuesto.setModel(new SpinnerNumberModel(5, 1, 100, 1));
			contentPanel.add(spinnerPresupuesto, "cell 2 7,growx");
		}
		{
			JLabel lblNewLabel_5 = new JLabel("(En miles de \u20AC)");
			contentPanel.add(lblNewLabel_5, "cell 3 7,alignx center");
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Nombre:");
			contentPanel.add(lblNewLabel_4, "cell 0 9 2 1,alignx right");
		}
		{
			textNombre = new JTextField();
			contentPanel.add(textNombre, "cell 2 9 3 1,growx");
			textNombre.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("A\u00F1adir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void recogerDatos() {
		int cod_departamento = Integer.parseInt(textCodigo.getText());
		Centro centro = (Centro) ( (JComboBox) comboCentro).getSelectedItem();
		String tipo_dir = null;
		if(rdbtnPropiedad.isSelected()) {
			tipo_dir = "P";
		} else {
			tipo_dir = "F";
		}
		int presupuesto = (int) spinnerPresupuesto.getValue();
		String nombre = textNombre.getText();
		Departamento departamento = new Departamento(cod_departamento, centro.getCod_centro(), tipo_dir, presupuesto, nombre);
		
		
		controlador.insertaDepartamento(departamento);
		
	}
	
public void setCentros(ArrayList<Centro> listaCentros) {
		
		this.listaCentros = listaCentros;
		for (Centro centro : listaCentros) {
			((JComboBox) comboCentro).addItem(centro);
		}
		
	}	
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}
}
