package Graficos;

import Modelo.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class PantallaCombustible extends JFrame {

    private final JTextField litros;
    private JPanel panel;


    public PantallaCombustible(Implementador implementador) {

        setTitle("Cargar narfta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("LITROS A CARGAR:");
        lblNewLabel.setBounds(12, 32, 165, 16);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("TIPO DE COMBUSTIBLE:");
        lblNewLabel_1.setBounds(12, 100, 165, 16);
        contentPane.add(lblNewLabel_1);

        litros = new JTextField();
        litros.setBounds(207, 29, 195, 22);
        contentPane.add(litros);
        litros.setColumns(10);

        JComboBox<String> tiposCombustibles = new JComboBox<>();

        Combustible combustibleComun = new Comun();
        tiposCombustibles.addItem(combustibleComun.toString());
        Combustible combustibleSuper = new Super();
        tiposCombustibles.addItem(combustibleSuper.toString());


        tiposCombustibles.setBounds(207, 97, 195, 22);
        contentPane.add(tiposCombustibles);

        JButton btnNewButton = new JButton("CONSULTAR MONTO");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double total = implementador.CalcularMontoTotal(Double.parseDouble(litros.getText()),
                        tiposCombustibles.getSelectedIndex() == 0 ? new Comun() : new Super());
                JOptionPane.showMessageDialog(null, "Monto a pagar: $"+total);

 }
        });
        btnNewButton.setBounds(12, 182, 165, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("CONFIRMAR PAGO");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar el pago?");
                    if (eleccion == JOptionPane.YES_OPTION) {
                        implementador.registrarUnaVenta(LocalDateTime.now(), litros.getText(),
                                tiposCombustibles.getSelectedIndex() == 0 ? new Comun() : new Super());
                        JOptionPane.showMessageDialog(null, "Se regitro la venta correctamente.");
                    }
                }catch(RuntimeException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        btnNewButton_1.setBounds(225, 182, 177, 25);
        contentPane.add(btnNewButton_1);
    }



}

