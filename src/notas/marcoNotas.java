package notas;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class marcoNotas extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public marcoNotas(){
        lamina_notas();
        setTitle("Notas");
        setSize(280,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void lamina_notas() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nota1 = new JLabel();
        nota1.setText("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);

        nota2 = new JLabel();
        nota2.setText("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);

        nota3 = new JLabel();
        nota3.setText("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);

        nota4 = new JLabel();
        nota4.setText("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);

        nota5 = new JLabel();
        nota5.setText("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 25);
        calcular.addActionListener(this);

        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(150, 170, 100, 25);
        limpiar.addActionListener(this);

        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 200, 25);

        desviacion = new JLabel();
        desviacion.setText("Desviación = ");
        desviacion.setBounds(20, 240, 200, 25);

        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 200, 25);

        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 200, 25);

        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }
    public void actionPerformed(ActionEvent evento) {
        boolean error = false;
        try {
            if (evento.getSource() == calcular) {
                Notas notas = new Notas();

                notas.notas_estudiante[0] = Double.parseDouble(campoNota1.getText().trim());
                notas.notas_estudiante[1] = Double.parseDouble(campoNota2.getText().trim());
                notas.notas_estudiante[2] = Double.parseDouble(campoNota3.getText().trim());
                notas.notas_estudiante[3] = Double.parseDouble(campoNota4.getText().trim());
                notas.notas_estudiante[4] = Double.parseDouble(campoNota5.getText().trim());

                promedio.setText("Promedio = " + String.format("%.2f", notas.mean()));
                desviacion.setText("Desviación estándar = " + String.format("%.2f", notas.std()));
                mayor.setText("Valor mayor = " + notas.max());
                menor.setText("Valor menor = " + notas.min());
            }
            if (evento.getSource() == limpiar) {
                campoNota1.setText("");
                campoNota2.setText("");
                campoNota3.setText("");
                campoNota4.setText("");
                campoNota5.setText("");
            }
        }catch(Exception e){
            error = true;
        }
        finally {
            if (error){
                JOptionPane.showMessageDialog(null, "Campo nulo" +
                        " o error en formato","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
