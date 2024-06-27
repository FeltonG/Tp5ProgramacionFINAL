public class NodoArbol {
    String valor;
    NodoArbol derecha;
    NodoArbol izquierda;

    // Constructor que inicializa el valor del nodo y los hijos como nulos
    public NodoArbol(String valor) {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }
}
