package componentesDiccionario;

public class ABBPalabras<Palabra extends Comparable<Palabra>> implements InterfacePalabras {
	
	private NodoABBPalabras<Palabra> root;
	
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
		// TODO Auto-generated method stub
		
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
	
	/**
	* Elimina del �rbol la palabra pasada como par�metro
	* Pre: la palabra como mucho est� una vez en el diccionario
	* @param pal: palabra a eliminar
	*/
	private void eliminarPalabra(Palabra pal) {
		if(!this.isEmpty()) this.eliminarPalabra(pal);
	}
	
	public void eliminarPalabraa(Palabra pal) {
		root.eliminarPalabra(pal);
	}

}
