package figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public MarcoPiramide() {
        lamina();
        setTitle("Pirámide");
        setSize(270,240);
        setLocationRelativeTo(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void lamina() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel();
        base.setText("Base (cm):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel();
        altura.setText("Altura (cm):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        apotema = new JLabel();
        apotema.setText("Apotema (cm):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm³):");
        volumen.setBounds(20, 140, 180, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm²):");
        superficie.setBounds(20, 170, 180, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }
    public void actionPerformed(ActionEvent event) {
        Piramide piramide;
        boolean error = false;
        double base;
        double altura;
        double apotema;
        try {
            base = Double.parseDouble(campoBase.getText().trim());
            altura = Double.parseDouble(campoAltura.getText().trim());
            apotema = Double.parseDouble(campoApotema.getText().trim());
            piramide = new Piramide(base, altura, apotema);

            volumen.setText("Volumen (cm³): " +
                    String.format("%.2f", piramide.calcularVolumen()));
            superficie.setText("Superficie (cm²): " +
                    String.format("%.2f", piramide.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o " +
                                "error en formato de número",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
