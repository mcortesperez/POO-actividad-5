package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;

    public MarcoEsfera() {
        lamina();
        setTitle("Esfera");
        setSize(270,240);
        setLocationRelativeTo(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void lamina() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel();
        radio.setText("Radio (cm):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm³):");
        volumen.setBounds(20, 90, 180, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 120, 180, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calcular) {
            boolean error = false;
            double radio;
            try {
                radio = Double.parseDouble(campoRadio.getText().trim());
                Esfera esfera = new Esfera(radio);

                volumen.setText("Volumen (cm³): " +
                        String.format("%.2f", esfera.calcularVolumen()));
                superficie.setText("Superficie (cm²): " +
                        String.format("%.2f", esfera.calcularSuperficie()));
            } catch (Exception e) {
                error = true;
            } finally {
                if(error) {
                    JOptionPane.showMessageDialog(null,"Campo nulo o"+
                            "error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

