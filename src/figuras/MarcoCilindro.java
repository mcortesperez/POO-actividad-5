package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public MarcoCilindro() {
        lamina();
        setTitle("Cilindro");
        setSize(270, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void lamina() {
        contenedor = getContentPane();
        contenedor.setLayout(null);        //Lamina sin layout

        radio = new JLabel();
        radio.setText("Radio(cm):");
        radio.setBounds(20, 20, 135, 23);   //Entrada para el valor del radio
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        altura = new JLabel();
        altura.setText("Altura(cm):");
        altura.setBounds(20, 50, 135, 23);        //Entrada para la altura
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 80, 135, 23);      //botón calcular
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen(cm³):");                             //Salida volumen
        volumen.setBounds(20, 110, 180, 23);

        superficie = new JLabel();
        superficie.setText("Superficie(cm²):");
        superficie.setBounds(20, 140, 180, 23);     //Salida superficie

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);                // Se agregan los elementos a la lamina "contenedor"
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0;
        double altura = 0;
        try {
            radio = Double.parseDouble(campoRadio.getText().trim());
            altura = Double.parseDouble(campoAltura.getText().trim());  /*Parseo de las entradas en los
                                                                         JTextfield */
            Cilindro cilindro = new Cilindro(radio, altura);

            volumen.setText("Volumen (cm³): " +
                    String.format("%.2f", cilindro.calcularVolumen()));     //Establecer salidas
            superficie.setText("Superficie (cm²): " +
                    String.format("%.2f", cilindro.calcularSuperficie()));

        } catch (Exception e){
            error = true;
        } finally {
            if(error) {
                JOptionPane.showMessageDialog(null,"Campo nulo o " +
                                "error en formato de numero", "Error", JOptionPane.ERROR_MESSAGE);
            }                               //Mensaje de error
        }
    }
}
