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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class registro extends JFrame {

	 // Esta es la clase registar usuario.
	// lo que hacer esta clase de agregar nuevos usuarios a la base de datos para así poderce logea en el programa.
	
	//Aquí estan todas la variabes utilizada en este programa. 
	//Tambien estan la variables de la extencion JFrame.
	
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField texNumero;
	private JTextField textCorreo;
	private JPasswordField passContra;
	private JTextField textUsauario;
	private JPasswordField passwordField;
	Metodos_sql metodos = Metodos_sql.getInstance();
	Logeo lg = new Logeo();
	
	/**
	 * Launch the application.
	 */
	//Este es el Main de esta clases.  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
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
	//Donde tenemos todos los procesos de jFrame.
	public registro() {
		// Aquí comienza el interfaz grafico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(43, 52, 92, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(43, 98, 92, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de telefono");
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(43, 149, 114, 27);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Correo electronico");
		lblNewLabel_2_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(43, 204, 92, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(43, 261, 92, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Confirmar contrase\u00F1a");
		lblNewLabel_2_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(43, 308, 123, 27);
		contentPane.add(lblNewLabel_2_3);
		//Campo Nombre
		textNombre = new JTextField();
		textNombre.setBounds(121, 55, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		//Campo
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(121, 101, 86, 20);
		contentPane.add(textApellido);
		//Campo Apellido
		texNumero = new JTextField();
		texNumero.setColumns(10);
		texNumero.setBounds(154, 152, 114, 20);
		contentPane.add(texNumero);
		//Campo Correo
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(161, 207, 107, 20);
		contentPane.add(textCorreo);
		//Campo Contraseña
		passContra = new JPasswordField();
		passContra.setBounds(145, 264, 123, 20);
		contentPane.add(passContra);
		
		JButton btnRegistral = new JButton("Registrar ");
		btnRegistral.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRegistral.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			 //Aqui esta la fucionalidad del boton Registral.
			public void actionPerformed(ActionEvent e) {
				//Este es el validador de los campos del boton Registral. 
				String i =passContra.getText();
				String v = passwordField.getText();
              String s="",s1="",s2="",s3="",s4="",s5="",s6="";
              
              if(textUsauario.getText().equals("")) {
            	s="Usauario";  
              }
            //Campo Contraceña
				if(passContra.getText().equals("")) {
					s1=",Contraseña";
				}
				if(textNombre.getText().equals("")) {
					s2=",Nombre";
				}
		        if(textApellido.getText().equals("")) {
		            s3 = ",Apellido"; 	
		        }if(texNumero.getText().equals("")) {
		        	s4 = ",Numero de telefono";
		        }if(textCorreo.getText().equals("")) {
		        	s5 = ",Correo Eletronico";
		        	
		        }if(passwordField.getText().equals("")) {
		        	s6 = ",Confirmacion de contraseña";
		        }if(textUsauario.getText().equals("")|| passContra.getText().equals("")|| textNombre.getText().equals("")|| textApellido.getText().equals("") || texNumero.getText().equals("") || (textCorreo.getText().equals("") || passwordField.getText().equals(""))){
		 			JOptionPane.showMessageDialog(null, "No debes dejar campos vacíos, por favor rellene los siguientes campos: "+s+""+s1+""+s2+""+s3+""+s4+""+s5+""+s6+"." );
		        
		        
		        }else {
            	if(i.equals(v)) {
            		// Este botòn lo que haces es agregar los usuarios a la base de datos por medios de la clase metodos sql.
    				metodos.guardar(textUsauario.getText(),textNombre.getText(),textApellido.getText(),texNumero.getText(),textCorreo.getText(),passContra.getText());
    				JOptionPane.showMessageDialog(contentPane, "Se ha registrado con exito");
    				
    				lg.setVisible(true);
    				dispose();
 
    			}else {
    				JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden");
    				
    			}	
 
            }		
 			
			}
			});
		btnRegistral.setBounds(342, 114, 89, 23);
		contentPane.add(btnRegistral);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			 //Aqui esta la fucionalidad del boton Volver.

			public void actionPerformed(ActionEvent e) {
			//este botòn lo que haces es volver al logeo.
			lg.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBounds(342, 247, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(43, 11, 46, 14);
		contentPane.add(lblNewLabel_3);
		//Campo usauario
		textUsauario = new JTextField();
		textUsauario.setBounds(121, 8, 86, 20);
		contentPane.add(textUsauario);
		textUsauario.setColumns(10);
		//Campo Comfimacion contraceña
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 311, 128, 20);
		contentPane.add(passwordField);
	}
	// aquí termina el interfaz grafico.		

	
}
