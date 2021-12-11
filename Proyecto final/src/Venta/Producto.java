package Venta;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import ConexionBD.ConexionDt;
import ConexionBD.Metodos_sql;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Producto extends JFrame {

	// Esta es la clase interfaz de producto.
	
	//Aquí estan todas la variabes utilizada en este programa. 
	//Tambien estan la variables de la extencion JFrame.
		
	
	private JPanel contentPane;
	private JTable table;
	String[] datos = new String[6];	
 DefaultTableModel Model = new DefaultTableModel(); 
 Statement st;
	Resultset rs;
	
	Metodos_sql meg = Metodos_sql.getInstance();
	


	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto frame = new Producto();
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
		
	public Producto() {
		// Aquí comienza el interfaz grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 38, 487, 228);
		contentPane.add(scrollPane);
		table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {			@Override
			// estos es un eventos de click
			// los que haces es que si tocamas los datos presentado por el Jtable te proporciona la id de la persona que estas selecionado y lo manda a la clase ActualizacionProduc en la cual buscan los datos de que van hacer actualizado y lo presenta en la zerdas de clase, osea en el JTextField.
			public void mouseClicked(MouseEvent e) {
					
			if(e.getClickCount()==1) {
				String b = (String) table.getValueAt(table.getSelectedRow(), 0).toString();
				ActualizacionProduc  AcPr= new ActualizacionProduc(b);
				AcPr.setVisible(true);
				System.out.println(b);
				
				dispose();

			}
}});
		scrollPane.setViewportView(table);
		//botón Nuevo
		JButton btnNewButton = new JButton("NUEVO");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(74, 74, 162));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			//aqui esta la funcionalidad del botón Nuevo.
			public void actionPerformed(ActionEvent e) {
			//Este botón te permite al pecionarlo ir a la clase  Nuevo_produ para agragar nuevos productos a la dase de datos.	
			Nuevo_produ Nuevo = new Nuevo_produ();	
			Nuevo.setVisible(true);
			dispose();
			}
		});
		btnNewButton.setBounds(66, 291, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			//Este botón lo que haces es que te vuelve al menú nuevamente.
			public void actionPerformed(ActionEvent e) {
				Menu Me = new Menu();
				Me.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnVolver.setBackground(new Color(74, 74, 162));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBounds(199, 293, 89, 23);
		contentPane.add(btnVolver);
		
		//aquí está la funcionalidad del botón CERRAR SECCION.
		JButton btnCerrarSeccion = new JButton("CERRAR SESION");
        btnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// este botón te permite pasa la clase logeo donde tendrá que inicial sección nuevamente.			
			Logeo lo= new Logeo();
			lo.setVisible(true);
			dispose();
			
			}
		});
		btnCerrarSeccion.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnCerrarSeccion.setBackground(new Color(74, 74, 162));
		btnCerrarSeccion.setForeground(new Color(255, 255, 255));
		btnCerrarSeccion.setBounds(332, 293, 182, 23);
		contentPane.add(btnCerrarSeccion);

		// aqui se muesta el nomnre de las columnas de la base de datos.
				
		Model.addColumn("Id de producto");
		Model.addColumn("Nombre Producto");
		Model.addColumn("Marca Producto");
		Model.addColumn("Categoria Producto");
		Model.addColumn("Precio Producto");
		Model.addColumn("Stock Producto");
		//Aqui se muestra los datos almasenado en la base de datos.

		mostrar();
		
				
		
     
		
		
	}
    
	//esta es la funcion de mostrar.
				
		public void mostrar() {
			// Lo que haces esta clase es que extrae los datos de los usuarios.
			ActualizacionProduc  AcP= new ActualizacionProduc("a");

			Model.setRowCount(0);
			String sql = "select * from productos";
			Connection meer = ConexionDt.getConexion();
			try {
				st =  meer.createStatement();
				ResultSet result = st.executeQuery(sql);
				while(result.next()){
				System.out.println(result.getString(1));
				datos[0] = result.getString(1);
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				datos[3] = result.getString(4);
				datos[4] = result.getString(5);
				datos[5] = result.getString(6);
				
				
				Model.addRow(datos);				
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		
}

