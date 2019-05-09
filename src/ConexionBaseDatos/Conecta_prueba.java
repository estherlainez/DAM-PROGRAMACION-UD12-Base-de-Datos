package ConexionBaseDatos;
import java.sql.*;
public class Conecta_prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//1. Crear conexion
			//Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes");
			Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?autoReconnect=true&useSSL=false",
					"root","12345678");
			//2.Crear objeto statement
			Statement miStatement= miConexion.createStatement();
			
			//3. Ejecutar sql
			ResultSet miResulset=miStatement.executeQuery("SELET * FROM CLIENTES");
			
			//4. Recorrer el Resultset
				while(miResulset.next()) {
					System.out.println(miResulset.getString("nombre")+" "+miResulset.getString("id")+" "+miResulset.getString("telefono"));
				}
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}
	}

}
