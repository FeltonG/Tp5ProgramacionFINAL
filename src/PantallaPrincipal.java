import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PantallaPrincipal {
    private JTextField inputExpresion;
    private JButton btnEnter;
    private JTextField inputResultado;
    public JPanel fondoPantalla;
    private JLabel txtResultado;
    private JLabel titulo;
    private JLabel expresionesGuardadastxt;
    private JButton btnBorrarTodo;
    private JTextField txtTextField; // Cambiado a JTextField para guardar la última expresión
    private EvaluadorExpresion evaluadorExpresion;
    private String ultimaExpresion; // Variable para almacenar la última expresión

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
                    double resultado = evaluadorExpresion.evaluar(0); // Ajusta el valor de la variable si es necesario
                    inputResultado.setText(Double.toString(resultado));

                    // Guardar la última expresión
                    ultimaExpresion = expresion;

                    // Actualizar el JTextField con la última expresión guardada
                    actualizarExpresionGuardada();
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

    // Método para actualizar el JTextField con la última expresión guardada
    private void actualizarExpresionGuardada() {
        txtTextField.setText(ultimaExpresion); // Actualiza el texto en el JTextField
    }
}