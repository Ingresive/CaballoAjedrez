package org.iesalandalus.programacion.caballoajedrez;


public class  Caballo	{
	Color color;
	Posicion posicion;
	
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

	
	//Crea un constructor por defecto para esta clase que cree un caballo negro en la posición '8b'.
	 
	
	
	
	public Caballo() {
		color= Color.NEGRO;
		posicion = new Posicion();
		posicion.fila = 8;
		posicion.columna = 'b';
		
	}
	
	//Crea un constructor para la clase que acepte como parametro el color que creará un caballo de dicho color
	//cuya posicion sera '1b' si es blanco o '8b' si es negro.. 
	
	
	public Caballo(Color color) {
		
		if ((color != Color.BLANCO && color != Color.NEGRO) || color == null ) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}else {
			this.color = color;
			
			        if (color == Color.BLANCO) {
			        
		               posicion = new Posicion();
			           posicion.fila = 1;
			           posicion.columna = 'b';
			      }else{
			    	   posicion = new Posicion();
				       posicion.fila = 8;
				       posicion.columna = 'b';				
			           }
			
		}
		
		new Caballo(color, posicion);
	}
	
	
	/*Crea un constructor para la clase que acepte como parámetros el color y la columna inicial.
	 *  La columna inicial debe ser la 'b' o la 'g' (de lo contrario debe lanzar la excepción IllegalArgumentException
	 *  con un mensaje adecuado) y creara un caballo del color dado y colocado en dicha columna 
	 * y cuya fila será la 1 si el blanco y la 8 si es el negro.
	 *
	 * */
	
	public Caballo (Color color, char columnaInicial) {
		
		if (columnaInicial != 'b' && columnaInicial != 'g' ) {
			
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
			
		}else {
			
			if (color == Color.BLANCO) {
				posicion = new Posicion();
				posicion.fila = 1;
				posicion.columna = columnaInicial;
			}else {
				posicion = new Posicion();
				posicion.fila = 8;
				posicion.columna = columnaInicial;
			}
			new Caballo(color, posicion);
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
	
	

}
