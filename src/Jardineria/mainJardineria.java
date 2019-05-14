package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class mainJardineria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado= new Scanner(System.in);
		
		try {
		
				
		ConexionJardineria cn=new ConexionJardineria();
		String sql;
		
		
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
					sql="select * from productos";
					ConexionJardineria.Select(sql);
					
					break;
				case 2:
					sql="select * from clientes";
					ConexionJardineria.Select(sql);
					
					break;
				case 3:
					System.out.println("3. INSERTAR");
					/*
							System.out.println("Inserte codigo cliente");
							int CodigoCliente=teclado.nextInt();
							teclado.nextLine();
							System.out.println("Inserte nombre cliente");
							String NombreContacto=teclado.nextLine(); 
							System.out.println("Inserte apellido cliente");
							String ApellidoContacto=teclado.nextLine();
							System.out.println("Inserte telefono cliente");
							String Telefono=teclado.nextLine(); 
							System.out.println("Inserte fax cliente");
							String Fax=teclado.nextLine();
							System.out.println("Inserte una direccion del cliente");
							String LineaDireccion1=teclado.nextLine(); 
							System.out.println("Inserte una segunda direccion del cliente");
							String LineaDireccion2=teclado.nextLine(); 
							System.out.println("Inserte la ciudad de residencia del cliente");
							String Ciudad=teclado.nextLine(); 
							System.out.println("Inserte la region del cliente");
							String Region=teclado.nextLine(); 
							System.out.println("Inserte el pais del cliente");
							String Pais=teclado.nextLine(); 
							System.out.println("Inserte codigo postal");
							String CodigoPostal=teclado.nextLine();
							System.out.println("Inserte numero de Responsable de ventas");
							int CodigoEmpleadoRepVentas=teclado.nextInt(); 
							System.out.println("Inserte el limite de credito solicitado");
							double LimiteCredito=teclado.nextDouble();
					DatosJardineria.insertarCliente( CodigoCliente, NombreContacto,  ApellidoContacto,  Telefono,  Fax,
							 LineaDireccion1,  LineaDireccion2,  Ciudad,  Region,  Pais,  CodigoPostal,
							 CodigoEmpleadoRepVentas,  LimiteCredito);
					DatosJardineria.mostrarDatos();
					*/
					break;
				case 4:
					System.out.println("4. MODIFICAR");
					DatosJardineria.modificarDatos(teclado);
					DatosJardineria.mostrarDatos();
					break;
				case 5:
					System.out.println("5. BORRAR");
					System.out.println("¿Que cliente va a eliminar de la base de datos? \n Introduzca el nombre de contacto por favor: ");
					String nombreElimninar= teclado.nextLine();
					DatosJardineria.borrarDatos(nombreElimninar);
					DatosJardineria.mostrarDatos();
					break;
				case 6:
					
					System.out.println("6. SALIR");
					System.out.println("Que tengas buen dia...");
					try {
						cn.conector.close();
					}catch(Exception e) {
						System.out.println("no Conecta");
						e.printStackTrace();
					}
					
					break;
				
				}
				
				
				
			}while(opcion!=6);
		
		System.out.println("probando.....");
		}catch(Exception e) {
			System.out.println("Error, fallo conexion");
			e.printStackTrace();
		}
	}

}
