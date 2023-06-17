package figuras;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, piramide;

    public MarcoPrincipal(){
        lamina();
        setTitle("Figuras");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void lamina() {

        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.setBounds(20, 50, 100, 23);
        cilindro.addActionListener(this);

        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.setBounds(150, 50, 80, 23);
        esfera.addActionListener(this);

        piramide = new JButton();
        piramide.setText("Pirámide");
        piramide.setBounds(260, 50, 100, 23);
        piramide.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) {
            MarcoEsfera esfera = new MarcoEsfera();
            esfera.setVisible(true);
        }
        if (evento.getSource() == cilindro) {
            MarcoCilindro cilindro = new MarcoCilindro();
            cilindro.setVisible(true);
        }
        if (evento.getSource() == piramide) {
            MarcoPiramide piramide = new MarcoPiramide();
            piramide.setVisible(true);
        }
    }
}
