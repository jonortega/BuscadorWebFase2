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
		if(sPalabra.compareTo(this.info.getLaPalabra()) == 0) devol = this.info;
		else if(sPalabra.compareTo(this.info.getLaPalabra()) < 0) {
			if(this.hasLeft()) devol = this.left.buscarPalabra(sPalabra);
		} else {
			if(this.hasRight()) devol = this.right.buscarPalabra(sPalabra);
		}
		return devol;
	}
	
	/**
	* Devuelve una lista con todas aquellas palabras del árbol que no sean
	* palabra clave de ninguna web
	* @return lista con las palabras a eliminar
	*/
	public LinkedList<Palabra> obtenerPalabrasAEliminar() {
		LinkedList<Palabra> lista = new LinkedList<Palabra>();
		if(this.info).getCoincidencias().isEmpty()) lista.add(this.info);
		if(this.hasLeft()) lista.addAll(this.left.obtenerPalabrasAEliminar());
		if(this.hasRight()) lista.addAll(this.right.obtenerPalabrasAEliminar());
		return lista;
	}
	
	/**
	 * Elimina el nodo con el menor valor del árbol
	 * @return Clase auxiliar con el valor y la referencia al nodo
	 */
	public ResultadoRemoveMin removeMin() {
		   ResultadoRemoveMin resul = new ResultadoRemoveMin();
		   if(!this.hasLeft()) {//El m�nimo es el actual
		      resul.elValor = this.info;
		      resul.elNodo = this.right; 
		   }else { //El m�nimo est� en el sub�rbol izquierdo
		      ResultadoRemoveMin resulLeft = this.left.removeMin();
		      this.left = resulLeft.elNodo; 
		      resul.elValor = resulLeft.elValor;
		      resul.elNodo = this; 
		    }
		    return resul;
	}
	
	/**
	* Elimina del �rbol la palabra pasada como par�metro
	* Pre: la palabra como mucho est� una vez en el diccionario
	* @param pal: palabra a eliminar
	*/
	public NodoABBPalabras eliminarPalabra(Palabra pal) {
		int comp = pal.compareTo(this.info);
		if(comp==0) {//Caso (a): this es el nodo a eliminar
			if(!this.hasLeft()) return this.right;  //Caso (a1)
		    else {
		    	if(!this.hasRight()) return this.left; //Caso (a2)
		    	else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor m�nimo del subarbol derecho
		    		ResultadoRemoveMin min = this.right.removeMin();
		        	this.right = min.elNodo;
		        	this.info = min.elValor;
		        	return this;
		    	}
		    }
		}else {
			if(comp<0){//Caso (b) El elemento a eliminar, si est�, estar� en el sub�rbol izq
		    	if(this.hasLeft()) this.left = this.left.eliminarPalabra(pal);
		    }else {//comp>0: Caso (c) El elemento a eliminar, si est�, estar� en el sub�rbol dcho
		    	if (this.hasRight()) this.right = this.right.eliminarPalabra(pal);
		    }
			return this;
		}
	}

}
