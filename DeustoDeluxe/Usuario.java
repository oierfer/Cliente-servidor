package DeustoDeluxe;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.swt.widgets.DateTime;

import com.google.gson.*;
import com.google.gson.stream.*;

public class Usuario {
	int id;
	String nombre;
	String apellidos;
	ArrayList<Usuario> usuarios_si;
	ArrayList<Usuario> usuarios_no;

	public Usuario(int id, String nombre, String apellidos, ArrayList<Usuario> si, ArrayList<Usuario> no) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuarios_si = si;
		this.usuarios_no = no;
	}
	
	public String toGson() {
	//{id,nombre,apellidos,[user1;user2;],[user1;user2;]}
		Gson aux = new GsonBuilder().create();
		return aux.toJson(this);
		
//		String aux = "{" + this.id + "," + this.nombre + "," + this.apellidos;
//		aux += ",[";
//		for(Usuario user: usuarios_si) {
//			aux += user.id + ";";
//		}
//		aux += "],[";
//		for(Usuario user: usuarios_no) {
//			aux += user.id + ";";
//		}
//		aux += "]}";
//		return aux;
	}
	
	public static Usuario fromGson(String gson) {
//		String[] user = gson.split(",");
//		return new Usuario(user[0], user[1], user[2], );
		
		Gson aux = new Gson();//GsonBuilder().create();
		Usuario nuevo = aux.fromJson(gson, Usuario.class);
		return nuevo;
	}
	
	public static void main(String[] args) {
		Usuario user = new Usuario(1, "oier", "fernandez", null, null);
		String texto;
		System.out.println(texto = user.toGson());
		Usuario nuevo = (fromGson(texto));
		System.out.println(nuevo);
	}
}
