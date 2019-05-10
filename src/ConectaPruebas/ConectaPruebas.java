package ConectaPruebas;
import java.sql.*;

public class ConectaPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			/*paso 0: Añadimos el conector correspondiente, en este caso jdbc a eclipse.
			 * Asi podremos usar estas librerias en nuestro programa
			 * 
			 * PROYECTO->(btonDcho Propiedades-> Java Build Path(penultima opcion)->
			 * ->bibliotecas-> añadir Jar externos
			 */
			/*1) creamos la conexion. Usamos la clase DriveManager
			 * Esta instruccion tiene la siguiente sintaxis:
			 * jdbc:mysql://localhost:3306/prueba?autoReconnect=true&useSSL=false","root","12345678");
			 * [1] :[2] :[3],[4],[5]
			 * 
			 * [1]-> nombre del driver, en nuestro caso, jdbc
			 * 
			 * [2]->mysql: el nombre del protocolo
			 * 
			 * [3]-> //localhost: 3306/prueba: esta es la direccion donde esta nuestra 
			 * base de datos, direccion localhost (podria ser otro servidor)
			 * el numero de puerto, y el nombre de la base de datos, que en nuestro caso es prueba.
			 * 
			 * [4]->usuario
			 * 
			 * [5]->contraseña
			 * 
			 */
				Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?autoReconnect=true&useSSL=false",
						"root","12345678");
				
			//2.Crear objeto statement.Este objeto es el que nos permite enviar comandos sql a java
				Statement miStatement= miConexion.createStatement();
				
			//3.Ejecutar la sentencia. La sentencia sql nos devuelve una tabla de datos
			//de tipo ResulSet. Esta la pidemos recorrer para ver los diferentes campos
			//de la base de datos	
				ResultSet miResulSet=miStatement.executeQuery("Select * from clientes");
				
			//4.Recorrer el	 resulset
				System.out.println("\n\n SELECT");
				while(miResulSet.next()) {
					System.out.println(miResulSet.getInt("id")+" "+
							miResulSet.getString("nombre")+" "+
							miResulSet.getString("telefono")+" "+
							miResulSet.getString("provincia"));
					
					//+" " +miResulSet.getInt("numeroCompras"));
				}
			
			//5.Insertar sql
				String instruccionSQL= "INSERT INTO clientes (nombre, telefono, provincia, numeroCompras) VALUES('mario vargas ', '665778855','teruel',5)";
				
				miStatement.execute(instruccionSQL);
				
			//6. Consultar una tabla
				 miResulSet=miStatement.executeQuery("Select * from clientes");
				 System.out.println("\n\n SELECT DESPUES DE INSERT");
				 while(miResulSet.next()) {
					 System.out.println(miResulSet.getString(1)+" "+
						miResulSet.getString(2)+" "+
						miResulSet.getString(3)+" "+
						miResulSet.getString(4)+" "+
						miResulSet.getInt(5));
				 }
				 
				 
			//7.Consultas Preparadas
				 PreparedStatement sentencia= miConexion.prepareStatement
						 ("Select * from clientes where provincia=? and numeroCompras=?");
				 sentencia.setString(1, "zaragoza");
				 sentencia.setInt(2,3);
				 ResultSet rsp= sentencia.executeQuery();
				 System.out.println("\n\n  CONSULTAS PREPARADAS"); 
				 
				 while(rsp.next()) {
					 System.out.println(rsp.getString(1)+" "+rsp.getString(2)+" "+
						rsp.getString(3)+" "+rsp.getString(4)+" "+rsp.getInt(5));
				 }
			
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}

	}

}
