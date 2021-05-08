package Graficos;

import Modelo.Implementador;
import Modelo.Persistencia;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

    private JPanel contentPane;

    public PantallaPrincipal(Implementador implementador) {
    setTitle("Pantalla principal");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
		contentPane.setLayout(null);

    JButton btnNewButton = new JButton("CARGAR NAFTA");
		btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            PantallaCombustible pantallaCombustible = new PantallaCombustible(implementador);
            pantallaCombustible.setVisible(true);
        }
    });
		btnNewButton.setBounds(101, 65, 228, 25);
		contentPane.add(btnNewButton);

    JButton btnNewButton_1 = new JButton("VER REGISTRO DE VENTAS");
		btnNewButton_1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            PantallaRegistroVentas pantallaRegistroVentas = new PantallaRegistroVentas(implementador);
            pantallaRegistroVentas.setVisible(true);
        }
    });
		btnNewButton_1.setBounds(101, 164, 228, 25);
		contentPane.add(btnNewButton_1);
}
}
