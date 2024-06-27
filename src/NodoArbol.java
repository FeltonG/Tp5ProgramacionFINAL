public class NodoArbol {
    int valor;
    NodoArbol derecha;
    NodoArbol izquierda;

    public NodoArbol(int valor){
        this.valor= valor;
        this.derecha=null;
        this.izquierda=null;

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }


    public NodoArbol getIzquierda() {
        return izquierda;
    }



}
