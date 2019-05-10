package Jardineria;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultaJardineria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado= new Scanner(System.in);
		
		try {
		Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?autoReconnect=true&useSSL=false",
				"root","12345678");
		
		Statement miStatement= miConexion.createStatement();
		
		ResultSet miResulSet=miStatement.executeQuery("Select * from productos");
		
		System.out.println("MENU");
		System.out.println("1. Consultar los productos que tenemos");
		System.out.println("2. Consultar los pedidos y el detalle de pedido segun el cliente por teclado");
		System.out.println("3. Insertar en clientes");
		System.out.println("4. Modificar en clientes");
		System.out.println("5. Borrar clientes");
		System.out.println("6. Salir");
		System.out.println("Introduzca opcion");
		
		int opcion=teclado.nextInt();
			do {
				switch(opcion) {
				case 1:
					System.out.println("1. SELECCIONAR");
					ResultSet res=miStatement.executeQuery("Select * from productos");
					
					while(res.next()) {
						System.out.println(res.getString(1)+" "+
								res.getString(2)+" "+
								res.getString(3)+" "+
								res.getString(4)+" "+
								res.getString(5)+" "+
								res.getString(6));
						
						//+" " +miResulSet.getInt("numeroCompras"));
					}
					break;
				case 2:
					System.out.println("2. CONSULTA PREPARADA");
					break;
				case 3:
					System.out.println("3. INSERTAR");
					break;
				case 4:
					System.out.println("4. MODIFICAR");
					break;
				case 5:
					System.out.println("5. BORRAR");
					break;
				case 6:
					System.out.println("6. SALIR");
					System.out.println("Que tengas buen dia...");
					break;
				
				}
				
				
				
			}while(opcion!=4);
		
		System.out.println("probando.....");
		}catch(Exception e) {
			System.out.println("Error, fallo conexion");
			e.printStackTrace();
		}
	}

}
