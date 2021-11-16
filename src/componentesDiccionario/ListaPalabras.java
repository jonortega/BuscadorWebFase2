package componentesDiccionario;

import java.util.ArrayList;

public class ListaPalabras {

	private ArrayList<Palabra> palabras;
	
	/**
	 * Constructora: Genera una lista vacia
	 */
	public ListaPalabras() {
		palabras = new ArrayList<Palabra>();
	}
	
	/**
	* Añade una palabra a la lista
	* @param palabra: palabra a añadir
	*/
	public void anadirPalabra(Palabra palabra) {
		palabras.add(palabra);
	}
	
	/**
	* Busca una palabra en la lista y la devuelve
	* @param sPalabra: texto de la palabra a buscar
	* @return la Palabra (si está en la lista), null en caso contrario
	*/
	public Palabra buscarPalabra(String sPalabra) {	
		//Búsqueda dicotomica
		int izq = 0;
		int der = palabras.size()-1;
		int medio = (izq + der)/2;
		Palabra devol = null;

		while((izq < der) && (!palabras.get(medio).getInfo().equals(sPalabra))) {
			if(palabras.get(medio).getInfo().compareToIgnoreCase(sPalabra) > 0) {
				der = medio-1;
			} else {
				izq = medio+1;
			}
			medio = (izq + der)/2;
		}
		if(palabras.get(medio).getInfo().equals(sPalabra)) devol = palabras.get(medio);
		return devol;
	}

}
