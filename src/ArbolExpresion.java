import java.util.Map;
import java.util.Stack;

public class ArbolExpresion {

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    // Función para construir un árbol de expresión a partir de una expresión postfix
    public Node constructTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        Node t, t1, t2;

        // Recorre cada token de la expresión postfix
        for (String s : postfix) {
            // Si el token no es un operador, crea un nodo y lo añade al stack
            if (!isOperator(s)) {
                t = new Node(s);
                stack.push(t);
            } else { // Si es un operador
                t = new Node(s);

                // Saca los dos nodos superiores del stack
                t1 = stack.pop();
                t2 = stack.pop();

                // Los asigna como hijos izquierdo y derecho del nodo actual
                t.right = t1;
                t.left = t2;

                // Añade esta subexpresión al stack
                stack.push(t);
            }
        }

        // El único elemento restante en el stack es la raíz del árbol de expresión
        t = stack.peek();
        stack.pop();

        return t;
    }

    // Función para evaluar el árbol de expresión con variables
    public double evaluate(Node root, Map<String, Double> variables) {
        if (root == null) {
            return 0;
        }

        // Nodo hoja (operando o variable)
        if (root.left == null && root.right == null) {
            if (variables.containsKey(root.value)) {
                return variables.get(root.value);
            } else {
                return Double.parseDouble(root.value);
            }
        }

        // Evalúa el subárbol izquierdo
        double leftEval = evaluate(root.left, variables);

        // Evalúa el subárbol derecho
        double rightEval = evaluate(root.right, variables);

        // Aplica el operador correspondiente
        switch (root.value) {
            case "+":
                return leftEval + rightEval;
            case "-":
                return leftEval - rightEval;
            case "*":
                return leftEval * rightEval;
            case "/":
                if (rightEval == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return leftEval / rightEval;
            default:
                return 0;
        }
    }

    // recorridos

    // Recorrido in-order del árbol
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // Recorrido pre-order del árbol
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Recorrido post-order del árbol
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }
}
