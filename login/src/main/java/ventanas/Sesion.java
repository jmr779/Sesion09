package ventanas;

public class Sesion {
	private static int idUsuario=-1;
	private static String usuario="";

	public static int getIdUsuario() {
		return idUsuario;
	}

	public static void setIdUsuario(int idUsuario) {
		Sesion.idUsuario = idUsuario;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		Sesion.usuario = usuario;
	}
}
