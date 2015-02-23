package accesoDatos;

import java.util.ArrayList;
import modelo.SesionUsuario;
import modelo.Usuario;

public class Datos {
	
	public static final int MAX_USUARIOS=10;
	
	public static final int MAX_SESIONES=10;
	
	public static ArrayList<Usuario> datosUsuario = new ArrayList<Usuario>();
	
	public static ArrayList<SesionUsuario> SesionesUsuario=new ArrayList<SesionUsuario>();
	
	
	public static String buscaUsuario(String dni){
		StringBuilder aux2=new StringBuilder();
		
		for (Usuario U: datosUsuario){			
			
				if(U.nif.equals(dni)){		
					
						aux2.append(U.aTextoConSeparador('\n'));	
						return aux2.toString();
				}
		
		}
		return null;
		
	}
	public static String buscaSesion(String dni){
		StringBuilder aux3=new StringBuilder();
		
		for (SesionUsuario S: SesionesUsuario){			
			if(S!=null){
				if(S.usr.nif.equals(dni)){		
					
					aux3.append("El Usuario inicio sesion el :"+S.fecha);
					
					return aux3.toString();
				}
			}
		}
		return "Usuario no conectado";
		
	}
	
	
	public static String datosUsuariosTexto(){
		
		StringBuilder aux=new StringBuilder();
		
		for(Usuario U: datosUsuario){
			if(U!=null){
			aux.append(U.aTextoConSeparador('\n'));
			}
			
		}
		return aux.toString();
	}
	
	public static String datosSesionesTexto(){
		
		StringBuilder auxSesion=new StringBuilder();
		
		for(SesionUsuario S: SesionesUsuario){
			if(S!=null){
			auxSesion.append(S.usr.aTextoConSeparador('\n'));
			auxSesion.append(S.fecha + "\n\n");
						
			}
		}
		return auxSesion.toString();
	}
	
	public static void crearDatosPrueba(int n){	
		String barra = "";
	    int ale;
	    int e = 0;
		//creando el resto de usuarios automaticamente
		for(int i=0;i<999999999;i++)
		{
			
			ale =(int) (Math.random()*(99999999));
			
			Usuario aux = new Usuario();
			
			aux.nif=""+ale+"p";
			aux.nombre=i+1+"juan";
			aux.apellidos=i+1+"aaa";
		    aux.domicilio=i+1+"aaa";
			aux.correoE=i+1+"aaa";
			aux.fechaNacimiento=i+1+"aaa";
			aux.fechaAlta=i+1+"aaa";
			aux.claveAcceso=i+1+"aaadsfaa";
			aux.rol=i+1+"aaa";
			
			datosUsuario.add(i,aux);
			
			
			e++;
			if(e == 10000){
				System.out.println(barra);
				barra += "[*]";
				e = 0;
			}
		}
		
	}
}
