import java.lang.foreign.ValueLayout;

public class NodoArbol {
    String valor;
    NodoArbol derecha;
    NodoArbol izquierda;

    public NodoArbol(String valor){
        this.valor= valor;
        this.derecha=null;
        this.izquierda=null;

    }
}
