package Venta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.EventTarget;

import com.mysql.cj.protocol.Resultset;

import ConexionBD.ConexionDt;
import ConexionBD.Metodos_sql;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class principal extends JFrame {

	// Esta es la clase contror de usuario.
	//esta clase te permite visualizar a los usuario que están en la base de datos por medio de una tabla.	//Aquí estan todas la variabes utilizada en este programa. 
	//Tambien estan la variables de la extencion JFrame.
			
	ConexionDt con = new ConexionDt();
	String[] datos = new String[5];
	public int h;
		
	Connection cn; 
	Statement st;
	Resultset rs;
	DefaultTableModel Model = new DefaultTableModel(); 
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases. 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Este es el Constructor 
		//Donde tenemos todos los procesos de jFrame 
	public principal() {
		// Aquí comienza el interfaz grafico

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(213, 45, 89));
		btnEliminar.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del botón ELIMINAR.
			public void actionPerformed(ActionEvent e) {
				//Esta fucionalidad del botón ELIMINAR te perminte al hacer clik en el botón pasar a la clase Eliminar.
				EliminarUsu eli = new EliminarUsu();
				dispose();
				eli.setVisible(true);

           }
		});
		btnEliminar.setBounds(204, 304, 125, 30);
		contentPane.add(btnEliminar);
		
		JButton btnSalir = new JButton("CERRAR SESION");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnSalir.setBackground(new Color(74, 74, 162));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBounds(546, 304, 142, 30);
		btnSalir.addActionListener(new ActionListener() {

			//Aquí está la funcionalidad del botón CERRAR SECCION.

	    public void actionPerformed(ActionEvent e) {
	    	// este botón te permite pasa la clase logeo donde tendrá que inicial sección nuevamente.
	    	    Logeo lg = new Logeo();
				lg.setVisible(true);
				dispose();
			}
		});
	
		// aqui se muesta el nomnre de las columnas de la base de datos.
		
		Model.addColumn("Usuario");
		Model.addColumn("Nombre");
		Model.addColumn("Apellido");
		Model.addColumn("Telefono");
		Model.addColumn("Email");
		//Aqui se muestra los datos almasenado en la base de datos.
		
        mostrar();
						
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
				}
		);
		scrollPane_1.setBounds(86, 37, 586, 244);
		contentPane.add(scrollPane_1);
		
		table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {
				});
		scrollPane_1.setViewportView(table);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(74, 74, 162));
		btnActualizar.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del botón ACTUALIZAR.
			public void actionPerformed(ActionEvent e) {
			// Este botón te permite entra a la clase ACTUALIZAR.
				Actualizar act= new Actualizar();
				act.setVisible(true);
				dispose();
			}
		});
		btnActualizar.setBounds(60, 304, 112, 30);
		contentPane.add(btnActualizar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			//Este botón lo que haces es que te vuelve al menú nuevamente.
			public void actionPerformed(ActionEvent e) {
			
			Menu Men= new Menu(); 	
				Men.setVisible(true);
				dispose();
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnVolver.setBackground(new Color(74, 74, 162));
		btnVolver.setBounds(376, 304, 142, 30);
		contentPane.add(btnVolver);
		// aquí termina la interfaz grafico.			
	}
	
	//esta es la funcion de mostrar.
	public void mostrar() {
		// Lo que haces esta clase es que extrae los datos de los usuarios.

		Model.setRowCount(0);
		String sql = "select * from usuarios";
		Connection meer = ConexionDt.getConexion();
		try {
			st =  meer.createStatement();
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
			System.out.println(result.getString(1));
			datos[0] = result.getString(2);
			datos[1] = result.getString(3);
			datos[2] = result.getString(4);
			datos[3] = result.getString(5);
			datos[4] = result.getString(6);
			Model.addRow(datos);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}	
}