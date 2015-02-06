import java.util.Date;
import java.util.Scanner;
/**
 * @author jesus
 *
 */
public class Principal {

	/**
	 * @param args
	 */
		//Apartado 6 y 7
	public static final int MAX_USUARIOS=10;
	
	public static final int MAX_SESIONES=10;
	
	public static Usuario[] datosUsuario=new Usuario[MAX_USUARIOS];
	
	public static SesionUsuario[] SesionesUsuario=new SesionUsuario[MAX_SESIONES];
	
	public static void main(String[] args) 
	{
		//Scanner teclado=new Scanner(System.in);
		
		//int n=teclado.nextInt();
		
		//Dos usuarios creados a mano
			//USUSARIAO 0
		datosUsuario[0]=new Usuario();	//Si no estuvviera declarad
		
		datosUsuario[0].nif="39662227p";
		datosUsuario[0].nombre="Juan";
		datosUsuario[0].apellidos="Apañez";
		datosUsuario[0].domicilio="C/false ,29 30006 Murcia";
		datosUsuario[0].correoE="aaa@aaa.com";
		datosUsuario[0].fechaNacimiento="04/09/1922";
		datosUsuario[0].fechaAlta="05/08/2014";
		datosUsuario[0].claveAcceso="123";
		datosUsuario[0].rol="fontanero";

		//USUSARIAO 1
		datosUsuario[1]=new Usuario();
		
		datosUsuario[1].nif="39662227p";
		datosUsuario[1].nombre="2 Juan";
		datosUsuario[1].apellidos="Apañez";
		datosUsuario[1].domicilio="C/false ,29 30006 Murcia";
		datosUsuario[1].correoE="aaa@aaa.com";
		datosUsuario[1].fechaNacimiento="04/09/1922";
		datosUsuario[1].fechaAlta="05/08/2014";
		datosUsuario[1].claveAcceso="1234";
		datosUsuario[1].rol="fontanero";
		
		crearDatosPrueba(MAX_USUARIOS);
		
		//4 y 5
		/**	Usuario usr1=null;				  //simple declaración// Si esto da error
			
		Usuario usr2 = new Usuario(); //declarción y creación 
		
		usr2.nif="123456789p";
		usr2.nombre="Eustaquio";
		usr2.apellidos="Arrancel";
		usr2.domicilio="C/ Falsa nº123 ";
		usr2.correoE="ultrafalso@jajaja.net";
		usr2.fechaNacimiento="25/12/0000";
		usr2.fechaAlta="3/12/2014";
		usr2.claveAcceso="123123";
		usr2.rol="gerente";
		
		usr1=usr2;
		//duplicar objeto usr2
	usr1=new Usuario();
		
		usr1.nif="123456789p";
		usr1.nombre="Eustaquio";
		usr1.apellidos="Arrancel";
		usr1.domicilio="C/ Falsa nº123 ";
		usr1.correoE="ultrafalso@jajaja.net";
		usr1.fechaNacimiento="25/12/0000";
		usr1.fechaAlta="3/12/2014";
		usr1.claveAcceso="123123";
		usr1.rol="gerente";
		
		System.out.println(usr1.toString());
		
		System.out.println(usr2.toString());		
	*/	
		//muestraUsuario(MAX_USUARIOS);
		
		 iniciarSesion();
		 for(SesionUsuario e:SesionesUsuario){
				System.out.println(e);
			
		 }
	}
	public static void crearDatosPrueba(int n)
	{int ale;
		//creando el resto de usuarios automaticamente
		for(int i=2;i<MAX_USUARIOS;i++)
		{
			ale =(int) (Math.random()*(99999999));
			
			datosUsuario[i]=new Usuario();
			
			datosUsuario[i].nif=""+ale+"p";
			datosUsuario[i].nombre=i+1+"juan";
			datosUsuario[i].apellidos=i+1+"aaa";
			datosUsuario[i].domicilio=i+1+"aaa";
			datosUsuario[i].correoE=i+1+"aaa";
			datosUsuario[i].fechaNacimiento=i+1+"aaa";
			datosUsuario[i].fechaAlta=i+1+"aaa";
			datosUsuario[i].claveAcceso=i+1+"aaa";
			datosUsuario[i].rol=i+1+"aaa";
			
		}
		
	}
	static void muestraUsuario(int n){
		for(int i=0;i<n;i++){
			System.out.println(datosUsuario[i].toString());
		}
	}



	 private static boolean iniciarSesion(){
		 
		 System.out.println("********INICIO DE SESION*******");
		 Scanner teclado=new Scanner(System.in);
		 int intentos=3;
		 boolean acceso=false;
		 do{
			 System.out.println("Usuario");
			 String alias=teclado.nextLine();
		 
			 System.out.println("Contraseña");
			 String contraseña=teclado.nextLine();
		 
			 for(int i=0;i<MAX_USUARIOS;i++){
			 
				 if (datosUsuario[i].nombre.equals(alias)){
				 
					 if(datosUsuario[i].claveAcceso.equals(contraseña)){
						 
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
	 private static void registrodesesion(int usuario){
		 for(int i=0;i<MAX_USUARIOS;i++){
			 
		
			 if(SesionesUsuario[i]==null){
		 
		 SesionesUsuario[i]=new SesionUsuario();
		 SesionesUsuario[i].usr=datosUsuario[usuario];
		 SesionesUsuario[i].fecha=new Date().toString();
		 		break;
			 }
		 }
	 }	
}		