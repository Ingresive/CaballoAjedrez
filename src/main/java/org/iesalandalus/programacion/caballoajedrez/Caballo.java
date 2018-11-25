package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;
/*
 * Crea la clase Caballo, dentro del paquete adecuado, 
 * cuyos atributos serán un color (del tipo enumerado Color) y posicion (de la clase Posicion),
 *  con la visibilidad adecuada.
 */

public class Caballo {
	private Color color;
	private Posicion posicion;

/*
 * Crea los métodos get y set para cada atributo con la visibilidad adecuada.
 */
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	/*
	 * Crea un constructor por defecto para esta clase que cree un caballo negro en la posición '8b'.
	 */
	public Caballo() {
		this.posicion = new Posicion(8, 'b');
		this.color = Color.NEGRO;

	}
	/*
	 * Crea un constructor para la clase que acepte como parámetro el color que creará 
	 * un caballo de dicho color cuya posición será '1b' si es blanco o '8b' si es negro.
	 */

	public Caballo(Color color) {

		this.setColor(color);

		if ((color != Color.BLANCO && color != Color.NEGRO) || color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		} else {
			if (color == Color.BLANCO) {
				this.posicion = new Posicion(1, 'b');

			} else {
				color = Color.NEGRO;
				this.posicion = new Posicion(8, 'b');
			}

		}

	}

	/*
	 * Crea un constructor para la clase que acepte como parÃ¡metros el color y la
	 * columna inicial. La columna inicial debe ser la 'b' o la 'g' (de lo contrario
	 * debe lanzar la excepciÃ³n IllegalArgumentException con un mensaje adecuado) y
	 * creara un caballo del color dado y colocado en dicha columna y cuya fila
	 * serÃ¡ la 1 si el blanco y la 8 si es el negro.
	 */

	public Caballo(Color color, char columnaInicial) {

		this.setColor(color);
		int fila;

		if (color == null) {

			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");

		} else {

			if (columnaInicial != 'b' && columnaInicial != 'g') {

				throw new IllegalArgumentException("ERROR: Columna inicial no vÃ¡lida.");

			}

			if (color == Color.BLANCO ) {

				fila = 1;

				this.posicion = new Posicion(fila, columnaInicial);
			}else{
				
				fila = 8;
				
				this.posicion = new Posicion(fila, columnaInicial);
			}

		}
	}

	public Caballo(Color color, Posicion posicion) {
		this.color = color;
		this.posicion = posicion;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	
	/*
	 * Crea el mÃ©todo mover que dependiendo del movimiento modificarÃ¡ la posiciÃ³n
	 * del mismo o si no puede realizar dicho movimiento debe lanzar una excepciÃ³n
	 * del tipo OperationNotSupportedException con un mensaje adecuado y no
	 * modificarÃ¡ la posiciÃ³n del caballo. 
	 */

	public void mover(Direccion direccion) throws OperationNotSupportedException {

		int movimientoFila;
		char movimientoColumna;

		movimientoFila = this.posicion.getFila();
		movimientoColumna = this.posicion.getColumna();
		


		switch (direccion) {

		case ARRIBA_DERECHA:

			movimientoFila++;
			movimientoFila++;
			movimientoColumna++;

			if ((movimientoFila > 8 || movimientoColumna > 'h')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}

			break;

		case ARRIBA_IZQUIERDA:
			movimientoFila++;
			movimientoFila++;
			movimientoColumna--;

			if ((movimientoFila > 8 || movimientoColumna < 'a')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}
			break;

		case IZQUIERDA_ABAJO:
			movimientoColumna--;
			movimientoColumna--;
			movimientoFila--;

			if ((movimientoFila < 1 || movimientoColumna < 'a')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}
			break;

		case IZQUIERDA_ARRIBA:
			movimientoColumna--;
			movimientoColumna--;
			movimientoFila++;

			if ((movimientoFila > 8 || movimientoColumna < 'a')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}
			break;

		case ABAJO_IZQUIERDA:
			movimientoFila--;
			movimientoFila--;
			movimientoColumna--;

			if (movimientoFila < 1 || movimientoColumna < 'a') {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
				System.out.println();
			}

			break;

		case ABAJO_DERECHA:
			movimientoFila--;
			movimientoFila--;
			movimientoColumna++;

			if ((movimientoFila < 1 || movimientoColumna > 'h')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}

			break;

		case DERECHA_ARRIBA:

			movimientoColumna++;
			movimientoColumna++;
			movimientoFila++;

			if ((movimientoFila > 8 || movimientoColumna > 'h')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}

			break;

		case DERECHA_ABAJO:

			movimientoColumna++;
			movimientoColumna++;
			movimientoFila--;

			if ((movimientoFila < 1 || movimientoColumna > 'h')) {

				throw new OperationNotSupportedException("ERROR: Movimiento no vÃ¡lido.");

			} else {
				this.posicion.setColumna(movimientoColumna);
				this.posicion.setFila(movimientoFila);
			}
			
			
			break;

		}
		

	}
	
	/*
	 *Crea el método equals para comparar la igualdad de objetos de la clase
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

/*
 * Crea el método toString que devuelva un String que será la representación de dicho objeto (color y posición).
 * 
 */
	@Override
	public String toString() {
		return "Caballo [posiciÃ³n=" + posicion + ", color=" + color + "]";
	}

}
