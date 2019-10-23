package DeustoDeluxe;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
                Usuario user = new Usuario(i, "nombre", "apellido", new ArrayList<Usuario>(), new ArrayList<Usuario>());
                String gson = user.toGson();
                salidaServidor.writeUTF(gson + "\n");
                System.out.println(Usuario.fromGson(gson));
            }

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Cliente cli = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
    }
}
