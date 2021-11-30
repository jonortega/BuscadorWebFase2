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
		if(palabra.compareTo(this.info) < 0) {	//Irá a la izquierda
			if(this.hasLeft()) this.left.anadirPalabra(palabra);
			else this.left = new NodoABBPalabras(palabra);
		} else {								//Irá a la derecha
			if(this.hasRight()) this.right.anadirPalabra(palabra);
			else this.right = new NodoABBPalabras(palabra);
		}
	}
	
	/**
	 * Busca una palabra en el árbol y la devuelve
	 * @param sPalabra: texto de la palabra a buscar
	 * @return la Palabra (si está en el árbol), null en caso contrario
	 */
	public Palabra buscarPalabra(String sPalabra) {
		Palabra devol = null;
		if(sPalabra.compareTo(this.info.getInfo()) == 0) devol = this.info;
		else if(sPalabra.compareTo(this.info.getInfo()) < 0) {
			if(this.hasLeft()) devol = this.left.buscarPalabra(sPalabra);
		} else {
			if(this.hasRight()) devol = this.right.buscarPalabra(sPalabra);
		}
		return devol;
	}

}
