
/**
 * @author jesus
 *
 */
public class Usuario {

		public String nif;
		public String nombre;
		public String apellidos;
		public String domicilio;
		public String correoE;
		public String fechaNacimiento;
		public String fechaAlta;
		public String claveAcceso;
		public String rol;
		
		@Override
		public String toString() {
			return "\n\nNIF:\t\t" + nif + "\n\nNombre:\t\t" + nombre
					+ "\n\nApellidos:\t" + apellidos + "\n\nDomicilio:\t" + domicilio
					+ "\n\nCorreoE:\t" + correoE + "\n\nFecha de Nacimiento:\t"
					+ fechaNacimiento + "\n\nFecha de Alta:\t" + fechaAlta
					+ "\n\nClaveAcceso:\t" + claveAcceso + "\n\nRol:\t" + rol;
		}
		
}
