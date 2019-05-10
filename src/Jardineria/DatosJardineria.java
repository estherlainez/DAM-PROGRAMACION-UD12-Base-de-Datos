package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
	
	public static void  consulta() {
		
		
	}
	public static void  borrarDatos() {
		
		
	}
	
	public static void insertarDatos() {
		//String instruccionSQL= "INSERT INTO jardineria (    ,    ,    ,    ) VALUES('  ', '','',)";
		
	}
	
	public static void modificarDatos() {
		
		
	}
	
	public static void  mostrarDatos() {
		/*
		// Consultar una tabla,mostrar tabla
		 miResulSet=miStatement.executeQuery("Select * from tabla");
		 
		 while(miResulSet.next()) {
			 System.out.println(miResulSet.getString(1)+" "+
				miResulSet.getString(2)+" "+
				miResulSet.getString(3)+" "+
				miResulSet.getString(4)+" "+
				miResulSet.getInt(5));
		 }   
		 
		                                 */
		
	}
}
