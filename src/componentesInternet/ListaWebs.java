package componentesInternet;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaWebs implements Iterable<Web>{
	
	private ArrayList<Web> webs;

	public ListaWebs() {
		webs = new ArrayList<Web>();
	}
	
	/**
	 * Devuelve el tamaño de la lista
	 * @return El tamaño de webs
	 */
	public int tamaño() {
		return webs.size();
	}
	
	/**
	 * Añade una web a la lista
	 * @param web: la web a añadir
	 * PRE: web no está en la lista
	 */
	public void anadirWeb(Web web) {
		webs.add(web);
	}
	
	/**
	* Añade un enlace a una web de la lista
	* @param idWebOrigen: id de la web de origen
	* @param idWebDestino: id de la web de destino
	* PRE: las webs con id idWebOrigen e idWebDestino están en la lista
	*/ 
	public void anadirEnlace(int idWebOrigen, int idWebDestino) {
		webs.get(idWebOrigen).anadirEnlace(idWebDestino);
	}

	/**
	 * Devuelve el iterador para la clase ListaWebs
	 */
	@Override
	public Iterator<Web> iterator() {
		return (new IteratorParaListaWebs());
	}
	
	/**
	 * Clase que implementa el iterador para ListaWebs
	 */
	private class IteratorParaListaWebs implements Iterator<Web>{
		private int actual;
		
		public IteratorParaListaWebs() {
			actual = 0;
		}

		@Override
		public boolean hasNext() {
			return (actual < webs.size()-1);
		}

		@Override
		public Web next() {
			actual++;
			return (webs.get(actual));
		}
	}
	
}
