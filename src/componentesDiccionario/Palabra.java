package componentesDiccionario;

import componentesInternet.ListaWebs;
import componentesInternet.Web;

public class Palabra implements Comparable {

	private String laPalabra;
	private ListaWebs coincidencias;
	
	public Palabra(String pal) {
		laPalabra = pal;
		coincidencias = new ListaWebs();
	}
	
	/**
	 * Getter para el atributo info
	 * @return El atributo info
	 */
	public String getLaPalabra() {
		return laPalabra;
	}
	
	/**
	 * Getter para el atributo coincidncias
	 * @return El atributo coincidencias
	 */
	public ListaWebs getCoincidencias() {
		return coincidencias;
	}
	
	/**
	 * Imprime la lista de las webs que coinciden con la palabra
	 */
	public void imprimirCoincidencias() {
		int i = 0;
		if(coincidencias.tamano() == 0) {
			System.out.print("No se han encontrado coincidencias\n");
		} else {
			for(Web w : coincidencias) {
				System.out.println(w.getNombre());
				i++;
			}
		}
		
		System.out.println("----------------------");
		System.out.println("Resultados: " + i);
	}

	@Override
	public int compareTo(Object o) {
		Palabra p = (Palabra)o;
		return (p.getLaPalabra().compareTo(this.laPalabra));
	}

}
