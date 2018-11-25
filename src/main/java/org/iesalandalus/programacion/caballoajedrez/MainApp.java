package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

/*
 * Crea los diferentes m�todos que se indican en el diagrama de clases para permitir que el m�todo main
 *  nos muestre un men� que nos permitir�: 
 *  crear un caballo por defecto
 *   crear un caballo de un color
 *    crear un caballo de un color en una columna inicial v�lida
 *     mover el caballo 
 *      salir. 
 *      Despu�s de cada operaci�n se nos mostrar� el estado actual de nuestro caballo.
 *       El men� se repetir� mientras no elijamos la opci�n salir. 
 *       En todo caso se debe validar que todas las entradas al programa son correctas.
 */

public class MainApp {

	private static Caballo caballo;

	public static void main(String[] args) {

		int opcion = 0;

		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
		while (opcion != 5) {
			opcion = elegirOpcion();
		}
	}

	public static void mostrarMenu() {

		System.out.println("");
		System.out.println("1.) Crear un caballo por defecto");
		System.out.println("2.) Crear un caballo de un color espec�fico");
		System.out.println("3.) Crear un caballo de un color en una columna inicial");
		System.out.println("4.) Mover El caballo");
		System.out.println("5.) Salir");
		System.out.println("");

	}

	public static int elegirOpcion() {

		int opcion;

		mostrarMenu();

		opcion = Entrada.entero();

		switch (opcion) {

		case 1:
			crearCaballoDefecto();

			break;

		case 2:

			crearCaballoDefectoColor();

			break;

		case 3:

			crearCaballoColorPosicion();

			break;

		case 4:

			mover();

			break;

		case 5:

			System.out.println("Aplicaci�n Finalizada");

			break;

		default:
			System.out.println("Opci�n no v�lida");

			break;

		}
		return opcion;

	}

	public static void crearCaballoDefecto() {

		caballo = new Caballo();

		System.out.println(caballo.toString());

	}

	public static void crearCaballoDefectoColor() {

		caballo = new Caballo(elegirColor());

		System.out.println(caballo.toString());

	}

	public static Color elegirColor() {

		int opcionColor;
		Color color = null;

		do {

			System.out.println("Elige un color");
			System.out.println("1.) BLANCO.");
			System.out.println("2.) NEGRO.");

			opcionColor = Entrada.entero();

			switch (opcionColor) {

			case 1:
				color = Color.BLANCO;

				break;

			case 2:

				color = Color.NEGRO;

				break;

			default:

				System.out.println("Opci�n no v�lida");

				break;

			}
		} while (color == null);

		return color;

	}

	public static void crearCaballoColorPosicion() {

		Color color = elegirColor();

		char columna = elegirColumnaInicial();

		caballo = new Caballo(color, columna);

		System.out.println(caballo.toString());
	}

	public static char elegirColumnaInicial() {

		char opcionColumna;

		do {
			System.out.println("Elige una columna b o g");
			opcionColumna = Entrada.caracter();

		} while (opcionColumna != 'b' && opcionColumna != 'g');

		return opcionColumna;

	}

	public static void mover() {
		Direccion direccion;
	
		try {

			do {
				direccion = elegirDireccion();

			} while (direccion == null);

			caballo.mover(direccion);

			System.out.println(caballo.toString());

		} catch (OperationNotSupportedException onse) {
			System.out.println("Movimiento no valido");
		}
		mover();

	}

	public static void mostrarMenuDirecciones() {

		System.out.println("Elige un movimiento");
		System.out.println("1.) ARRIBA_IZQUIERDA");
		System.out.println("2.) ARRIBA_DERECHA");
		System.out.println("3.) DERECHA_ARRIBA");
		System.out.println("4.) DERECHA_ABAJO");
		System.out.println("5.) ABAJO_IZQUIERDA");
		System.out.println("6.) ABAJO_DERECHA");
		System.out.println("7.) IZQUIERDA_ABAJO");
		System.out.println("8.) IZQUIERDA_ARRIBA");
		System.out.println("9.) Volver al men�.");
	}

	public static Direccion elegirDireccion() {

		int opcion = 0;
		Direccion direccion = null;

		do {

			mostrarMenuDirecciones();

			opcion = Entrada.entero();

			switch (opcion) {

			case 1:
				direccion = Direccion.ARRIBA_IZQUIERDA;

				break;

			case 2:

				direccion = Direccion.ARRIBA_DERECHA;

				break;

			case 3:
				direccion = Direccion.DERECHA_ARRIBA;

				break;

			case 4:

				direccion = Direccion.DERECHA_ABAJO;

				break;

			case 5:
				direccion = Direccion.ABAJO_IZQUIERDA;

				break;

			case 6:

				direccion = Direccion.ABAJO_DERECHA;

				break;

			case 7:
				direccion = Direccion.IZQUIERDA_ABAJO;

				break;

			case 8:

				direccion = Direccion.IZQUIERDA_ARRIBA;

				break;

			case 9:

				elegirOpcion();

				break;

			default:

				System.out.println("Movimiento no v�lido");

				break;
			}

		} while (opcion < 1 || opcion > 8);

		return direccion;

	}

}