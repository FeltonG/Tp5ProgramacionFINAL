public class EvaluadorExpresion {
    private final ArbolExpresion arbolExpresion;

    public EvaluadorExpresion(String expresion) {
        arbolExpresion = new ArbolExpresion(expresion);
    }

    public double evaluar(double valorVariable) {
        return arbolExpresion.evaluar(valorVariable);
    }
}
