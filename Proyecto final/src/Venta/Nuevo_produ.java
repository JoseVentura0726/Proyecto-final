package Venta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.Metodos_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Nuevo_produ extends JFrame {
	   // Esta es la clase nuevo producto.
	
		//Aquí estan todas la variabes utilizada en este programa. 
		//Tambien estan la variables de la extencion JFrame.
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField textPrecio;
	private JTextField textCantidad_dis;
	Metodos_sql me = Metodos_sql.getInstance(); 
	

	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases.  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo_produ frame = new Nuevo_produ();
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
	public Nuevo_produ() {
		// Aquí comienza el interfaz grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(34, 22, 46, 14);
		contentPane.add(lblNewLabel);
		//Campo Nombre
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 19, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(34, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setBounds(34, 147, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad disponible");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setBounds(34, 189, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Categor\u00EDa");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 250, 250));
		lblNewLabel_4.setBounds(34, 107, 60, 14);
		contentPane.add(lblNewLabel_4);
		//Campo Marca.
		txtMarca = new JTextField();
		txtMarca.setBounds(90, 67, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		//Campo Categoria
		txtCategoria = new JTextField();
		txtCategoria.setBounds(90, 104, 86, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		//Campo Precio
		textPrecio = new JTextField();
		textPrecio.setBounds(76, 144, 100, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		//Campo Cantidad disponible
		textCantidad_dis = new JTextField();
		textCantidad_dis.setBounds(135, 186, 86, 20);
		contentPane.add(textCantidad_dis);
		textCantidad_dis.setColumns(10);
		
		

	//botòn Agregar
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(74, 74, 162));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
		 //Aqui esta la fucionalidad del boton Agregar.
			public void actionPerformed(ActionEvent e) {	
				
		//Este es el validador de los campos del boton Agregar. 
			String s="",s1="",s2="",s3="",s4="";
	          
              if(txtNombre.getText().equals("")) {
            	s=",Nombre";  
              }
				if(txtMarca.getText().equals("")) {
					s1=",Marca";
				}
				if(txtCategoria.getText().equals("")) {
					s2=",Categoria";
				}
		        if(textPrecio.getText().equals("")) {
		            s3 = ",Precio"; 	
		        }if(textCantidad_dis.getText().equals("")) {
		        	s4 = ",Cantidad disponible";
		        }if(txtNombre.getText().equals("")|| txtMarca.getText().equals("")|| txtCategoria.getText().equals("")|| textPrecio.getText().equals("") || textCantidad_dis.getText().equals("") ){
    				JOptionPane.showMessageDialog(contentPane,e,"No debes dejar campos vacíos, por favor rellene los siguientes campos: "+s+""+s1+""+s2+""+s3+""+s4+".", JOptionPane.ERROR_MESSAGE);

		        
		        }else {
		        	// Este botòn lo que haces es agregar los productos a la base de datos por medios de la clase metodos sql.
	           		me.guardarProdu(txtNombre.getText(),txtMarca.getText(), txtCategoria.getText(), textPrecio.getText(), textCantidad_dis.getText());
	    				JOptionPane.showMessageDialog(contentPane, "Se ha guardado con exito");
	    				Producto Prod = new Producto();
	    				Prod.setVisible(true);
	    				dispose();
	    				
    			}	
 	
			}
		});
		btnNewButton.setBounds(253, 46, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del boton Volver.
			
			public void actionPerformed(ActionEvent e) {
			//aqui te permite volver a la clase productos sin ningun nuevo producto.
			Producto Prod= new Producto();
			Prod.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton_1.setBackground(new Color(74, 74, 162));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(277, 165, 89, 23);
		contentPane.add(btnNewButton_1);
		// aquí termina el interfaz grafico.		

	}
	
}
