package Venta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexionBD.ConexionDt;
import ConexionBD.Metodos_sql;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ActualizacionProduc extends JFrame {
   // Esta es la clase Actualiza y eliminar producto.
	
	//Aquí estan todas la variabes utilizada en este programa. 
	//Tambien estan la variables de la extencion JFrame.
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textCategoria;
	private JTextField textPrecio;
	private JTextField textCant_disponible;
	Metodos_sql me =Metodos_sql.getInstance();
	String[] datos = new String[5];	
	DefaultTableModel Model = new DefaultTableModel();
	public String id = "0";
	
		public String Nombre;
		public String Marca;
		public String Categoria;
		public String Precio;
		public String Can_disp;
	Statement st;
	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizacionProduc frame = new ActualizacionProduc("a");
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
	public ActualizacionProduc(String a) {
		id = a;
		// Aquí comienza el interfaz grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(74, 74, 162));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(40, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(new Color(74, 74, 162));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(40, 72, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categor\u00EDa");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBackground(new Color(74, 74, 162));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(40, 115, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBackground(new Color(74, 74, 162));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(40, 160, 39, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad disponible");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBackground(new Color(74, 74, 162));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(40, 206, 108, 14);
		contentPane.add(lblNewLabel_4);
		if (a != "a") {info();}
		//Campo Nombre. 
		textNombre = new JTextField();
		textNombre.setText(Nombre);
		textNombre.setBounds(89, 32, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		//Campo Marca.
		textMarca = new JTextField();
		textMarca.setText(Marca);
		textMarca.setColumns(10);
		textMarca.setBounds(89, 69, 86, 20);
		contentPane.add(textMarca);
		//Campo Categoria.
		textCategoria = new JTextField();
		textCategoria.setText(Categoria);
     	textCategoria.setColumns(10);
		textCategoria.setBounds(112, 112, 86, 20);
		contentPane.add(textCategoria);
		//Campo Precio.
		textPrecio = new JTextField();
		textPrecio.setText(Precio);
		textPrecio.setColumns(10);
		textPrecio.setBounds(89, 157, 86, 20);
		contentPane.add(textPrecio);
		//Campo Cantidad disponible.
		textCant_disponible = new JTextField();
		textCant_disponible.setText(Can_disp);
		textCant_disponible.setColumns(10);
		textCant_disponible.setBounds(158, 203, 86, 20);
		contentPane.add(textCant_disponible);
				   

      //botòn Actualizar.			
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		btnNewButton.setBackground(new Color(74, 74, 162));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			//aqui esta la fucionalidad del boton actualizar.
			public void actionPerformed(ActionEvent e) {
				//Este es el validador de los campos del boton actualizar.
				String s="",s1="",s2="",s3="",s4="";
				
				if(textNombre.getText().equals("")) {
	            	s="Nombre";  
	              }
					if(textMarca.getText().equals("")) {
						s1=",Marca";
					}
					if(textCategoria.getText().equals("")) {
						s2=",Categoria";
					}
			        if(textPrecio.getText().equals("")) {
			            s3 = ",Precio"; 	
			        }if(textCant_disponible.getText().equals("")) {
			        	s4 = ",Cantidad disponible";
			        }if(textNombre.getText().equals("")|| textMarca.getText().equals("")|| textCategoria.getText().equals("")|| textPrecio.getText().equals("") || textCant_disponible.getText().equals("") ){
			        	JOptionPane.showMessageDialog(contentPane,e,"No debes dejar campos vacíos, por favor rellene los siguientes campos: "+s+""+s1+""+s2+""+s3+""+s4+".", JOptionPane.ERROR_MESSAGE);
			        
			        
			        }else {
			        	//aqui se Actualizan los productos. 
			        	
			        	me.ActualizarProdu(id,textNombre.getText(),textMarca.getText(), textCategoria.getText(),textPrecio.getText(),textCant_disponible.getText());
		    				JOptionPane.showMessageDialog(contentPane, "Se ha Actualizar con exito");
		    				Producto Prod = new Producto();

		    				Prod.setVisible(true);
		    				dispose();
		    				
	    			}	
	 
					
			}
		});
		btnNewButton.setBounds(314, 68, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ELIMINAR");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		btnNewButton_1.setBackground(new Color(74, 74, 162));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del boton Eliminar.
			public void actionPerformed(ActionEvent e) {
				//Este es el validador de los campos del boton Eliminar.
                String s="",s1="",s2="",s3="",s4="";
				
				if(textNombre.getText().equals("")) {
	            	s="Nombre";  
	              }
					if(textMarca.getText().equals("")) {
						s1=",Marca";
					}
					if(textCategoria.getText().equals("")) {
						s2=",Categoria";
					}
			        if(textPrecio.getText().equals("")) {
			            s3 = ",Precio"; 	
			        }if(textCant_disponible.getText().equals("")) {
			        	s4 = ",Cantidad disponible";
			        }if(textNombre.getText().equals("")|| textMarca.getText().equals("")|| textCategoria.getText().equals("")|| textPrecio.getText().equals("") || textCant_disponible.getText().equals("") ){
			        	JOptionPane.showMessageDialog(contentPane,e,"No debes dejar campos vacíos, por favor rellene los siguientes campos: "+s+""+s1+""+s2+""+s3+""+s4+".", JOptionPane.ERROR_MESSAGE);
			        
			        
			        }else {
			        	    me.eliminalProd(id);
		    				JOptionPane.showMessageDialog(contentPane, "Se ha eliminado con exito");
		    				Producto Prod = new Producto();
		    				Prod.setVisible(true);
		    				dispose();
		    			}	
		    
			}
		});
		btnNewButton_1.setBounds(314, 156, 89, 23);
		contentPane.add(btnNewButton_1);
// aquí termina el interfaz grafico.		
		
	}
	//esta es la funcion de info
	public void info() {
	// Lo que haces esta clase es que por medio del id se busque los productos que se quieren actualizar o eliminar.

		String sql = "select * from productos where idProducto = "+id;
		
		
		Connection meer = ConexionDt.getConexion();
		try {
			st =  meer.createStatement();
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Nombre = result.getString(2);
				Marca = result.getString(3);
				Categoria = result.getString(4);
				Precio = result.getString(5);
				Can_disp = result.getString(6);
			}
					
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
 
	
}

