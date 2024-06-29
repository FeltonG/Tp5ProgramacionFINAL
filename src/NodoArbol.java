public class NodoArbol {
    private String valor;
    private NodoArbol derecha;
    private NodoArbol izquierda;

    public NodoArbol(String valor) {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }
}
