package componentesDiccionario;

public class NodoABBPalabras<T> {
	
	T info;
	NodoABBPalabras<T> left;
	NodoABBPalabras<T> right;

	public NodoABBPalabras(T info) {
		this.info = info;
	}

}
