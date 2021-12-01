package componentesDiccionario;

import java.util.LinkedList;

public class ABBPalabras implements InterfacePalabras {
	
	private NodoABBPalabras root;

	/**
	 * Constructora de la clase sin parametros
	 */
	public ABBPalabras() {
		this.root = null;
	}
	
	/**
	 * Constructora de la clase con parametro
	 * @param info: el info del nodo root
	 */
	public ABBPalabras(Palabra info) {
		this.root = new NodoABBPalabras(info);
	}
	
	/**
	 * Constructora de la clase con parametro
	 * @param root: el nodo root
	 */
	public ABBPalabras(NodoABBPalabras root) {
		this.root = root;
	}
	
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
	* Devuelve una lista con todas aquellas palabras del árbol que no sean
	* palabra clave de ninguna web
	* @return lista con las palabras a eliminar
	*/
	private LinkedList<Palabra> obtenerPalabrasAEliminar(){
		if(this.isEmpty()) return new LinkedList<Palabra>();
		else return root.obtenerPalabrasAEliminar();
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
