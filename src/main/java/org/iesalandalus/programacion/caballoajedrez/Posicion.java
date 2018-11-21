package org.iesalandalus.programacion.caballoajedrez;

public class Posicion { 
	
	int fila;
	char columna;
	
	
	//Get y Set
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		
		if (fila >= 1 || fila <= 8) {
			
			this.fila = fila;
			
		}else{ 
			
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}
		
	}
	public char getColumna() {
		
			return columna;	
		}
		
		
	
	public void setColumna(char columna) {
		if (columna >= 'a' && columna <='h' ){
			
		 this.columna = columna;
	
		}else{
			
		throw new IllegalArgumentException("ERROR: Columna  no válida.");
		
	          }
		}
		
	
	
	//Constructor 
	
	public Posicion (int fila, char columna) {
		
	}
	

}
