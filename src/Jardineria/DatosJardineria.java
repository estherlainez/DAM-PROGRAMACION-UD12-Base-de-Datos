package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class DatosJardineria {
		public static void conectar() {
			try {
				Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?autoReconnect=true&useSSL=false",
						"root","12345678");
				Statement miStatement= miConexion.createStatement();
			
			}catch(Exception e) {
				System.out.println("No conecta");
				e.printStackTrace();
			}

		}
	
	
	
	
			
		
		public static void  borrarDatos(String nombreBorrar) {
				Scanner teclado=new Scanner(System.in);
				try {
					Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?autoReconnect=true&useSSL=false",
							"root","12345678");
					Statement miStatement= miConexion.createStatement();
					String instruccionSQL= "DELETE FROM CLIENTES WHERE NOMBRE= "+nombreBorrar+"";
					miStatement.executeUpdate(instruccionSQL);
					System.out.println("Sus datos se actualizaron en la base de datos con exito");
					
				}catch(Exception e) {
					System.out.println("No conecta");
					e.printStackTrace();
				}
				
				
			}
			
			

			
			public static void insertarCliente(int CodigoCliente,String NombreContacto, String ApellidoContacto, String Telefono, String Fax,
					String LineaDireccion1, String LineaDireccion2, String Ciudad, String Region, String Pais, String CodigoPostal,
					int CodigoEmpleadoRepVentas, double LimiteCredito) throws SQLException {
				String instruccionSQL= "INSERT INTO jardineria (CodigoCliente,NombreContacto,ApellidoContacto,Telefono,Fax, "
						+ "LineaDireccion1, LineaDireccion2,Ciudad,Region,Pais,CodigoPostal,CodigoEmpleadoRepVentas,LimiteCredito  ) "
						
						+ "VALUES(CodigoCliente,'NombreContacto','ApellidoContacto','Telefono','Fax','LineaDireccion1', 'LineaDireccion2',"
						+ "'Ciudad','Region','Pais','CodigoPostal','CodigoEmpleadoRepVentas','LimiteCredito')";
				Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?autoReconnect=true&useSSL=false",
						"root","12345678");
				Statement miStatement= conexion.createStatement();
				try {
					miStatement = conexion.createStatement();        
					miStatement.execute(instruccionSQL);
		        	System.out.println("Sus datos se registraron en la base de datos con exito");
		          
		        }catch (SQLException e){
		                 e.printStackTrace();        
		        } 
			}
			
			
			public static void modificarDatos( Scanner teclado) {
				
				try {
					Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?autoReconnect=true&useSSL=false",
							"root","12345678");
					Statement miStatement= miConexion.createStatement();
					String nuevoNombre=teclado.nextLine();
					String instruccionSQL= "UPDATE CLIENTES SET NOMBRE=nuevoNombre WHERE NOMBRE='Esther'";
					miStatement.executeUpdate(instruccionSQL);
					System.out.println("Sus datos se actualizaron en la base de datos con exito");
					
				}catch(Exception e) {
					System.out.println("No conecta");
					e.printStackTrace();
				}
				
			}
			
			public static void  mostrarDatos() {
				try {
					Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?autoReconnect=true&useSSL=false",
							"root","12345678");
					Statement miStatement= miConexion.createStatement();
					ResultSet miResulSet=miStatement.executeQuery("Select * from clientes");
					 
					 while(miResulSet.next()) {
						 System.out.println(miResulSet.getInt(1)+" "+
							miResulSet.getString(2)+" "+
							miResulSet.getString(3)+" "+
							miResulSet.getString(4)+" "+
							miResulSet.getString(5)+" "+
							miResulSet.getString(6)+" "+
							miResulSet.getString(7)+" "+
							miResulSet.getString(8)+" "+
							miResulSet.getString(9)+" "+
							miResulSet.getString(10)+" "+
							miResulSet.getString(11)+" "+
							miResulSet.getInt(12)+" "+
							miResulSet.getInt(13));
					 }   
					
					
				}catch(Exception e) {
					System.out.println("No conecta");
					e.printStackTrace();
				}
				
				
				
				
				 
			}                               
	
}
