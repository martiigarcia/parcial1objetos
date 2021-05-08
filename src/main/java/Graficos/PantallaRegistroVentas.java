package Graficos;

import Modelo.Implementador;
import Modelo.Venta;
import Modelo.Persistencia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PantallaRegistroVentas extends JFrame {

    private JPanel contentPane;
    private final JTable table;
    private final DefaultTableModel modelo;
    private JLabel lblNewLabel;
    private Date fecha1;
    private Date fecha2;
    private List<Venta> listaVentas;

    public PantallaRegistroVentas(Implementador implementador) {
        setTitle("Listado de ventas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 831, 389);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();


        lblNewLabel = new JLabel("Buscar entre la fecha:");

        JTextField TextField = new JTextField();

        JLabel lblNewLabel_1 = new JLabel("y la fecha: ");

        JTextField TextField_1 = new JTextField();

        JButton btnNewButton = new JButton("Buscar");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    String fecha1 = TextField.getText();
                    String fecha2 = TextField_1.getText();
                    modelo.setRowCount(0);
                    listaVentas = implementador.recuperarListaVentasEntreFechas(fecha1, fecha2);
                    for(Venta venta : listaVentas){
                        modelo.addRow(new Object[] {venta.litrosCargados(), venta.MontoFacturado(), venta.fecha().toString()});
                    }
                    table.setModel(modelo);

                }

            });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(TextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(TextField_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                                .addGap(59)
                                                .addComponent(btnNewButton)
                                                .addGap(88))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 763, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(TextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton))
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addContainerGap())
        );

        table = new JTable();
        modelo = new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Listros cargados", "Monto abonado", "Fecha de carga"
                }
        );
        listaVentas = implementador.recuperarListaVentas();
        for(Venta venta : listaVentas){
            modelo.addRow(new Object[] {venta.litrosCargados(), venta.MontoFacturado(), venta.fecha().toString()});
        }
        table.setModel(modelo);


        table.getColumnModel().getColumn(0).setPreferredWidth(128);
        table.getColumnModel().getColumn(1).setPreferredWidth(128);
        table.getColumnModel().getColumn(2).setPreferredWidth(128);
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
    }
}
