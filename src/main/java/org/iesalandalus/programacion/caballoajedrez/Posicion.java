package org.iesalandalus.programacion.caballoajedrez;

public class Posicion { 
	
	int fila;
	char columna;
	
	public Posicion() {
		
	}
	
	
	/*
	 * Crea los métodos get y set para los atributos. Recuerda que para el método set 
	 * se debe tener en cuenta que los valores son correctos (las filas van del 1 al 8 -ambos inclusive-
	 *  y las columnas de la 'a' a la 'h' -ambos inclusive-) y si no se lance una excepción del tipo IllegalArgumentException
	 *   con el mensaje adecuado y no modifique los atributos.
	 *
	 */
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		
		if (fila >= 1 && fila <= 8) {
			
			this.fila = fila;
			
		}else{ 
			
			throw new IllegalArgumentException("ERROR: Fila no vÃ¡lida.");
		}
		
	}
	public char getColumna() {
		
			return columna;	
		}
		
		
	
	public void setColumna(char columna) {
		if (columna >= 'a' && columna <='h' ){
			
		 this.columna = columna;
	
		}else{
			
		throw new IllegalArgumentException("ERROR: Columna no vÃ¡lida.");
		
	          }
		}
		

	

	
	/*
	 * Crea un constructor para esta clase que acepte como parámetros la fila y la columna 
	 * y que los asigne a los atributos si son correctos y si no lance una excepción del mismo tipo 
	 * que la anterior indicando el problema.
	 */
	
	public Posicion (int fila, char columna) {
		

		
		if (columna >= 'a' && columna <='h' ){
			
			 this.setColumna(columna);
		
			}else{
				
			throw new IllegalArgumentException("ERROR: Columna no vÃ¡lida.");
			
		          }
			

		if (fila >= 1 && fila <= 8) {
			
			this.setFila(fila);
			
		}else{ 
			
			throw new IllegalArgumentException("ERROR: Fila no vÃ¡lida.");
		}

}
	
	/*
	 * Crea el constructor copia para esta clase.
	 */
	
	public Posicion(Posicion posicion) {
		
		if ( posicion == null) {
			throw new IllegalArgumentException("ERROR: No es posible copiar una posiciÃ³n nula.");
		}else {
			this.setFila(posicion.fila);
			this.setColumna(posicion.columna);
			 
			
		}
		
		}
	
	/*
	 * Crea el método equals para comparar la igualdad de dos objetos de esta clase.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}
	
	/*
	 *Crea el método toString que devolverá un String y será la representación de la fila y la columna.
	 * 
	 */
	@Override
	public String toString() {
		return "[fila=" + fila + ", columna=" + columna + "]";
	}
	
	
	
}

