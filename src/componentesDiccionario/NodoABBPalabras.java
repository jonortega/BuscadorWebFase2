package componentesDiccionario;

public class NodoABBPalabras<Palabra extends Comparable<Palabra>> {
	
	Palabra info;
	NodoABBPalabras<Palabra> left;
	NodoABBPalabras<Palabra> right;

	/**
	 * Constuctora de la clase
	 * @param info: La informaciÃ³n del nodo
	 */
	public NodoABBPalabras(Palabra pal) {
		this.info = pal;
	}
	
	/**
	 * Comprueba si el nodo tiene Ã¡rbol izquierdo
	 * @return true - si tiene Ã¡rbol izquierdo
	 * 		   false - si no tiene Ã¡rbol izquierdo
	 */
	public boolean hasLeft() {
		return (this.left != null);
	}
	
	/**
	 * Comprueba si el nodo tiene Ã¡rbol derecho
	 * @return true - si tiene Ã¡rbol derecho
	 * 		   false - si no tiene Ã¡rbol derecho
	 */
	public boolean hasRight() {
		return (this.right != null);
	}
	
	/**
	 * Comprueba si el nodo es una hoja del Ã¡rbol
	 * @return true - si es hoja
	 * 		   false - si no es hoja
	 */
	public boolean isLeaf() {
		return (this.left == null && this.right == null);
	}
	
	public ResultadoRemoveMin<Palabra> removeMin() {
		   ResultadoRemoveMin<Palabra> resul = new ResultadoRemoveMin<Palabra>();
		   if(!this.hasLeft()) {//El mínimo es el actual
		      resul.elValor = this.info;
		      resul.elNodo = this.right; 
		   }else { //El mínimo está en el subárbol izquierdo
		      ResultadoRemoveMin<Palabra> resulLeft = this.left.removeMin();
		      this.left = resulLeft.elNodo; 
		      resul.elValor = resulLeft.elValor;
		      resul.elNodo = this; 
		    }
		    return resul;
	}
	
	/**
	* Elimina del árbol la palabra pasada como parámetro
	* Pre: la palabra como mucho está una vez en el diccionario
	* @param pal: palabra a eliminar
	*/
	public NodoABBPalabras<Palabra> eliminarPalabra(Palabra pal) {
		int comp = pal.compareTo(this.info);
		if(comp==0) {//Caso (a): this es el nodo a eliminar
			if(!this.hasLeft()) return this.right;  //Caso (a1)
		    else {
		    	if(!this.hasRight()) return this.left; //Caso (a2)
		    	else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor mínimo del subarbol derecho
		    		ResultadoRemoveMin<Palabra> min = this.right.removeMin();
		        	this.right = min.elNodo;
		        	this.info = min.elValor;
		        	return this;
		    	}
		    }
		}else {
			if(comp<0){//Caso (b) El elemento a eliminar, si está, estará en el subárbol izq
		    	if(this.hasLeft()) this.left = this.left.eliminarPalabra(pal);
		    }else {//comp>0: Caso (c) El elemento a eliminar, si está, estará en el subárbol dcho
		    	if (this.hasRight()) this.right = this.right.eliminarPalabra(pal);
		    }
			return this;
		}
	}

}
