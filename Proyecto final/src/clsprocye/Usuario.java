package clsprocye;

public class Usuario {

	
	// Esta clases se utiliza para obtener los datos y compartirlos para hacer el login.
	    private String Usuario; 
		private String contrase�a;
		
		
		//Construtor de la clase Usuario
		public Usuario(String usuario, String contrase�a) {
			
			this.Usuario = usuario;
			this.contrase�a = contrase�a;
					}
       //Metodos setters y getters: 
		public String getContrase�a() {
			return contrase�a;
		}
		public void setContrase�a(String contrase�a) {
			this.contrase�a = contrase�a;
		}
		public Usuario() {
			// TODO Auto-generated constructor stub
		}
		public String getUsuario() {
			return Usuario;
		}
		public void setUsuario(String usuario) {
			Usuario = usuario;
		}
				
		
}


