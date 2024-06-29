import java.util.Stack;

public class ArbolExpresion {
    private final NodoArbol raiz;

    public ArbolExpresion(String expresion) {
        String expresionPostfija = convertirInfijoAPostfijo(expresion);
        raiz = construirArbol(expresionPostfija);
    }

    private String convertirInfijoAPostfijo(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : expresion.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    resultado.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedencia(c) <= precedencia(stack.peek())) {
                    resultado.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            resultado.append(stack.pop());
        }
        return resultado.toString();
    }

    private int precedencia(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private NodoArbol construirArbol(String expresion) {
        Stack<NodoArbol> stack = new Stack<>();
        NodoArbol t, t1, t2;

        for (int i = 0; i < expresion.length(); i++) {
            char current = expresion.charAt(i);

            if (!esOperador(current)) {
                t = new NodoArbol(Character.toString(current));
                stack.push(t);
            } else {
                t = new NodoArbol(Character.toString(current));

                t1 = stack.pop();
                t2 = stack.pop();

                t.setDerecha(t1);
                t.setIzquierda(t2);

                stack.push(t);
            }
        }

        t = stack.peek();
        stack.pop();

        return t;
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public double evaluar(NodoArbol nodo, double valorVariable) {
        if (nodo == null) {
            return 0;
        }

        if (!esOperador(nodo.getValor().charAt(0))) {
            if (nodo.getValor().equals("x")) {
                return valorVariable;
            } else {
                return Double.parseDouble(nodo.getValor());
            }
        }

        double izquierdaEval = evaluar(nodo.getIzquierda(), valorVariable);
        double derechaEval = evaluar(nodo.getDerecha(), valorVariable);

        switch (nodo.getValor()) {
            case "+":
                return izquierdaEval + derechaEval;
            case "-":
                return izquierdaEval - derechaEval;
            case "*":
                return izquierdaEval * derechaEval;
            case "/":
                if (derechaEval == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return izquierdaEval / derechaEval;
            default:
                return 0;
        }
    }

    public double evaluar(double valorVariable) {
        return evaluar(raiz, valorVariable);
    }

    public NodoArbol getRaiz() {
        return raiz;
    }
}
