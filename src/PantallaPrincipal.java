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
    private JTextPane textPane1;
    private JLabel expresionesGuardadastxt;
    private EvaluadorExpresion evaluadorExpresion;

    public PantallaPrincipal() {
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String expresion = inputExpresion.getText().replaceAll("\\s+", "");
                    if (expresion.isEmpty()) {
                        throw new IllegalArgumentException("La expresión no puede estar vacía");
                    }
                    evaluadorExpresion = new EvaluadorExpresion(expresion);
                    double resultado = evaluadorExpresion.evaluar(0); // Aquí debes decidir el valor de la variable si es necesario
                    inputResultado.setText(Double.toString(resultado));
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al evaluar la expresión: " + ex.getMessage());
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Evaluador de Expresiones Matemáticas");
                frame.setContentPane(new PantallaPrincipal().fondoPantalla);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                frame.setSize(1300, 400);

                frame.setVisible(true);
            }
        });
    }
}
