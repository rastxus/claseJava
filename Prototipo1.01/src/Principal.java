

	import java.util.Date;
	import java.util.Scanner;
	/**
	 * @author Jesus
	 *
	 */
	import accesoDatos.Datos;
	import modelo.SesionUsuario;
	import modelo.Usuario;
	import java.util.ArrayList;
	public class Principal {

	
		
		public static void main(String[] args) 
		{
			int opcion=0;
			
			while(opcion!=-1){
			
				
				Scanner teclado = new Scanner(System.in);
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado2 = new Scanner(System.in);
				
			System.out.println("\n\n\n|*******************************************[]");
			System.out.println("|[1] Crear Datos Usuarios.                  []");
			System.out.println("|[2] Muestra Datos Usuarios.                []");
			System.out.println("|[3] Inciar sesion.                         []");
			System.out.println("|[4] Buscar Usuarios.                       []");
			System.out.println("|[5] Buscar Inicios de Sesion.              []");
			System.out.println("|[6] Comprobar correo.                      []");
			System.out.println("|[7] Muestra todos los usuarios activos.    []\n\n");
			System.out.print(" ¿Que desea hacer?...              ");
			opcion=teclado.nextInt();
			
				if(opcion==1){
					Datos.crearDatosPrueba(Datos.MAX_USUARIOS);	
				}
				if(opcion==2){
					System.out.println(Datos.datosUsuariosTexto());
				}
				if(opcion==3){
					iniciarSesion(); 
				}
				if(opcion==4){
					System.out.print("¿Que usuario busca en el sistema?\n#dni:");
					String dni=teclado1.nextLine();
					System.out.println(Datos.buscaUsuario(dni));
				}
				if(opcion==5){
					System.out.print("¿Que usuario desea comprobar?\n#dni:");
					String dni=teclado1.nextLine();
					
					System.out.println(Datos.buscaSesion(dni));
				}
				
				if(opcion==6){
					System.out.println("\nIntroduzca correo\n");
					
					String correo=teclado2.nextLine();
					
					boolean valido=Usuario.correoValido(correo);
					
					if (valido==true){
						System.out.println("El correo es valido.");
					}
					else{System.out.println("El correo no es valido.");}
				}
				
				
				if(opcion==7){
					System.out.println("\nUsuarios conectados\n");
					
					System.out.println(Datos.datosSesionesTexto());
				}
			}
							
		
			 
		}//fin main
	
	



		 private static boolean iniciarSesion()
		 {
			 
			 System.out.println("********INICIO DE SESION*******");
			 Scanner teclado=new Scanner(System.in);
			 int intentos=3;
			 boolean acceso=false;
			 do{
				 System.out.println("Usuario");
				 String alias=teclado.nextLine();
			 
				 System.out.println("Contraseña");
				 String contraseña=teclado.nextLine();
			 
				 for(int i=0;i<Datos.datosUsuario.size();i++){
				 
					 if (Datos.datosUsuario.get(i).nombre.equals(alias)){
					 
						 if(Datos.datosUsuario.get(i).claveAcceso.equals(contraseña)){
							 
							 System.out.println("ok payo");
							 	registrodesesion(i);
							
						 	return true;
						 }
					 
					 }
					 
				 }
			 		
			 		System.out.println("Fallo intento de inicio de sesión. Número de intentos restantes: "+ intentos);
			 		intentos--;
			 } while(intentos>=0); 				
			
			return false;
		 }
		 public static void registrodesesion(int usuario){
			 
			SesionUsuario aux = new SesionUsuario();
			 
			
			aux.usr=Datos.datosUsuario.get(usuario);
			aux.fecha=new Date().toString();
			
			Datos.SesionesUsuario.add(aux);
			 		
			System.out.print("\n\n**Has iniciado sesión**\n"+aux.usr.aTextoConSeparador('\n'));
			System.out.print(aux.fecha);
				
				 
				
			 
		 }	
	}

