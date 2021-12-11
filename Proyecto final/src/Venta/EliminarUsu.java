package Venta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.Metodos_sql;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EliminarUsu extends JFrame {
 
	 // Esta es la clase eliminar producto.
	
		//Aquí estan todas la variabes utilizada en este programa. 
		//Tambien estan la variables de la extencion JFrame.
	private JPanel contentPane;
	private JTextField txtEliminar;
	Metodos_sql mosw = Metodos_sql.getInstance();

	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases.  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarUsu frame = new EliminarUsu();
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
	public EliminarUsu() {
		// Aquí comienza la interfaz grafico.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 298);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
      	//Campo Eliminar. 
		txtEliminar = new JTextField();
		txtEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		txtEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtEliminar.setBounds(41, 84, 119, 24);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		//Botòn Eliminar
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnEliminar.setBackground(new Color(74, 74, 162));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			//aqui esta la fucionalidad del boton Eliminar.
			public void actionPerformed(ActionEvent e) {
				//Este es el validador de los campos del boton Eliminar.
				mosw.eliminal(txtEliminar.getText());		
			    JOptionPane.showMessageDialog(contentPane, "Se ha eliminado con exito");			    
				principal prin = new principal();	
			    prin.setVisible(true); 				
			    dispose();
			    //System.out.println(prin.h);
			    
			}
		});
		btnEliminar.setBounds(41, 135, 119, 34);
		contentPane.add(btnEliminar);
		//botòn Salir.
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSalir.setBackground(new Color(74, 74, 162));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del boton Salir.

			public void actionPerformed(ActionEvent e) {
				principal prin = new principal();	
				prin.setVisible(true);	
				dispose();

			}
		});
		btnSalir.setBounds(41, 201, 119, 34);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(49, 39, 94, 20);
		contentPane.add(lblNewLabel);
		// aquí termina el interfaz grafico.		

	}

}
