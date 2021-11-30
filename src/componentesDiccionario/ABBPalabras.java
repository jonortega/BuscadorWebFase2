package componentesDiccionario;

import java.util.LinkedList;

public class ABBPalabras implements InterfacePalabras {
	
	private NodoABBPalabras root;
	
	/**
	 * Comprueba si el árbol es vacío
	 * @return true - si el árbol es vacío
	 * 		   false - si el árbol no es vacío
	 */
	public boolean isEmpty() {
		return (this.root == null);
	}

	/**
	* Añade una palabra a la lista
	* @param palabra: palabra a añadir
	*/
	@Override
	public void anadirPalabra(Palabra palabra) {
		if(this.isEmpty()) this.root = new NodoABBPalabras(palabra);
		else this.root.anadirPalabra(palabra);
	}

	/**
	* Busca una palabra en la lista y la devuelve
	* @param sPalabra: texto de la palabra a buscar
	* @return la Palabra (si está en la lista), null en caso contrario
	*/
	@Override
	public Palabra buscarPalabra(String sPalabra) {
		if(this.isEmpty()) return null;
		else return this.root.buscarPalabra(sPalabra);
	}
	
	/**
	* Elimina del �rbol la palabra pasada como par�metro
	* Pre: la palabra como mucho est� una vez en el diccionario
	* @param pal: palabra a eliminar
	*/
	private void eliminarPalabra(Palabra pal) {
		if(!this.isEmpty()) this.root.eliminarPalabra(pal);
	}
	
	/**
	* Haciendo uso de los métodos anteriores, obtiene la lista de palabras
	* del árbol a eliminar y elimina cada una de ellas.
	*/
	public void filtrarPalabrasClave() {
		LinkedList<Palabra> lista =  obtenerPalabrasAEliminar();
		for(Palabra p : lista) eliminarPalabra(p);
	}
}
