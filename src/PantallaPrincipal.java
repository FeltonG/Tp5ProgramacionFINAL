import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal {
    private JLabel titulo;
    private JTextField inputVariable;
    private JTextField inputExpresion;
    private JButton btnEnter;
    private JTextField inputResultado;
    public JPanel fondoPantalla;
    private JButton btnBorrarTodo;
    private JLabel txtVariable;
    private JLabel txtExpresion;
    private JLabel txtResultado;


    public PantallaPrincipal() {

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Crea una variable y obtiene el valor escrito en el input de expresion
                String expresion = inputExpresion.getText().replaceAll("\\s+", "");
                double variable = Double.parseDouble(inputVariable.getText());
                EvaluadorExpresion evaluadorExpresion = new EvaluadorExpresion(expresion);
                double resultado = evaluadorExpresion.evaluar(variable);
                inputResultado.setText(Double.toString(resultado));

            }
        });


        btnBorrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputExpresion.setText("");
                inputVariable.setText("");
                inputResultado.setText("");
            }
        });


    }


}
