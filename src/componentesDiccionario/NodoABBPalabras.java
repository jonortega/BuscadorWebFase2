package componentesDiccionario;

public class NodoABBPalabras {
	
	Palabra info;
	NodoABBPalabras left;
	NodoABBPalabras right;

	/**
	 * Constuctora de la clase
	 * @param info: La información del nodo
	 */
	public NodoABBPalabras(Palabra info) {
		this.info = info;
	}
	
	/**
	 * Comprueba si el nodo tiene árbol izquierdo
	 * @return true - si tiene árbol izquierdo
	 * 		   false - si no tiene árbol izquierdo
	 */
	public boolean hasLeft() {
		return (this.left != null);
	}
	
	/**
	 * Comprueba si el nodo tiene árbol derecho
	 * @return true - si tiene árbol derecho
	 * 		   false - si no tiene árbol derecho
	 */
	public boolean hasRight() {
		return (this.right != null);
	}
	
	/**
	 * Comprueba si el nodo es una hoja del árbol
	 * @return true - si es hoja
	 * 		   false - si no es hoja
	 */
	public boolean isLeaf() {
		return (this.left == null && this.right == null);
	}
	
	/**
	 * Añade una palabra al árbol
	 * @param palabra: palabra a añadir
	 */
	public void anadirPalabra(Palabra palabra) {
		
	}

}
