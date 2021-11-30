package componentesDiccionario;

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
		// TODO Auto-generated method stub
		return null;
	}


}
