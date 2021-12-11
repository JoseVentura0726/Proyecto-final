package Venta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mantenimiento.getionUsu;
import clsprocye.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Logeo extends JFrame {
	// Esta es la clase Nuevo producto.
	
		//Aquí estan todas la variabes utilizada en este programa. 
		//Tambien estan la variables de la extencion JFrame.
		
	private JPanel contentPane;
	private JTextField textusuario;
	private JPasswordField passContra;

	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases.  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo frame = new Logeo();
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
	public Logeo() {
		// Aquí comienza el interfaz grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 40, 76, 35);
		contentPane.add(lblNewLabel);
		//Campo usuario. 
		textusuario = new JTextField();
		textusuario.setBounds(96, 43, 153, 28);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		//Campo Contraseña
		passContra = new JPasswordField();
		passContra.setBounds(114, 112, 175, 33);
		contentPane.add(passContra);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(30, 112, 117, 35);
		contentPane.add(lblNewLabel_1);

		//Botòn Ingresar
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnIngresar.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del boton Enter.
			public void actionPerformed(ActionEvent e) {
			Enter();
			}
		});
		btnIngresar.setBounds(47, 209, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			//Aqui esta la fucionalidad del botón Registral.
			// Este botón te dirige ha Registral. 

			public void actionPerformed(ActionEvent e) {
				registro reg = new registro();
				reg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(160, 209, 89, 23);
		contentPane.add(btnNewButton);
		// Aquí termina el interfaz grafico.		

	}
	//Esta es la funcion de Enter
	protected void Enter() {
		//Esta función lo que haces es que busca el usuario en la base de datos y lo compara para saber si existe o está mal el usuario.
		String usuario = textusuario.getText();
		String Contraseña = String.valueOf(passContra.getPassword());
		getionUsu gestionUsuario = new getionUsu();
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setContraseña(Contraseña);
		Menu Menu = new Menu();
		
		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido Usuario");
			Menu.setVisible(true);
			dispose();
			
		 }else {
			 JOptionPane.showMessageDialog(contentPane,"Ingrese su usuario \r\n"
			 		+ "y contraseña, si no está registrado debe registrarse." ,"Error", JOptionPane.ERROR_MESSAGE);
		 }	
		

	}
}
