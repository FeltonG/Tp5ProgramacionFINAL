public class EvaluadorExpresion {
    private ArbolExpresion arbolExpresion;

    // esto recibe un string -> la expresion = (x+1 * 3)
    public EvaluadorExpresion(String expresion) {
        arbolExpresion = new ArbolExpresion(expresion);
    }

    public double evaluar(double valorVariable) {
        return arbolExpresion.evaluar(valorVariable);
    }

//    public void imprimirInOrden() {
//        arbolExpresion.recorridoInOrden(arbolExpresion.getRaiz());
//    }
//
//    public void imprimirPreOrden() {
//        arbolExpresion.recorridoPreOrden(arbolExpresion.getRaiz());
//    }
//
//    public void imprimirPostOrden() {
//        arbolExpresion.recorridoPostOrden(arbolExpresion.getRaiz());
//    }
}
