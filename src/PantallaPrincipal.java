import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal {
    private JLabel titulo;
    private JTextField inputExpresion;
    private JButton btnEnter;
    private JTextField inputResultado;
    public JPanel fondoPantalla;
    private JButton btnBorrarTodo;
    private JLabel txtExpresion;
    private JLabel txtResultado;
    private EvaluadorExpresion evaluadorExpresion;

    public PantallaPrincipal() {
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String expresion = inputExpresion.getText().replaceAll("\\s+", "");
                    evaluadorExpresion = new EvaluadorExpresion(expresion);
                    double resultado = evaluadorExpresion.evaluar(0); // Aquí debes decidir el valor de la variable si es necesario
                    inputResultado.setText(Double.toString(resultado));

//                    System.out.print("Recorrido InOrden: ");
//                    evaluadorExpresion.imprimirInOrden();
//                    System.out.println();
//
//                    System.out.print("Recorrido PreOrden: ");
//                    evaluadorExpresion.imprimirPreOrden();
//                    System.out.println();
//
//                    System.out.print("Recorrido PostOrden: ");
//                    evaluadorExpresion.imprimirPostOrden();
//                    System.out.println();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        btnBorrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputExpresion.setText("");
                inputResultado.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Evaluador de Expresiones Matemáticas");
        frame.setContentPane(new PantallaPrincipal().fondoPantalla);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
