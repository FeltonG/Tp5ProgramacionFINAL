import org.w3c.dom.Node;

import java.lang.foreign.ValueLayout;

public class NodoArbol {
    String valor;
    //hijos izquierdo y derecho
    Node derecha;
    Node izquierda;

    // Constructor que inicializa el valor del nodo y los hijos como nulos
    public NodoArbol(String valor) {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;

    }
}
