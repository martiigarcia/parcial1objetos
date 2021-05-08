package JDBC;

import Modelo.Venta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JDBCVenta {

    public void cargarVenta(Venta venta){
        JDBCConexion conexion = new JDBCConexion();

        try {

            PreparedStatement consulta =
                    conexion.conexion().prepareStatement(
                            "INSERT INTO registro_de_ventas " +
                                    "(fecha_de_carga, litros_cargados, monto_abonado) " +
                                    "VALUES (?, ?, ?)");

            consulta.setTimestamp(1, Timestamp.valueOf(venta.fecha()));
            consulta.setDouble(2, venta.litrosCargados());
            consulta.setDouble(3, venta.MontoFacturado());

            int cant = consulta.executeUpdate();
            if (cant > 0) {
                System.out.println("Se registro la consulta");
            }


            consulta.close();
            conexion.conexion().close();

        } catch (SQLException  e){
            throw new RuntimeException("No se pudo registrar la venta.", e);
        }

    }

    public List<Venta> recuperarListaVentas(){
        JDBCConexion conexion = new JDBCConexion();
        List<Venta> ventas = new ArrayList<>();
        try {
            PreparedStatement consulta =
                    conexion.conexion().prepareStatement(
                            "SELECT * FROM `registro_de_ventas`");

            ResultSet result = consulta.executeQuery();

            while (result.next()) {

                Timestamp time=result.getTimestamp("fecha_de_carga");
                LocalDateTime tiempo = time == null ? null : time.toLocalDateTime();

                ventas.add(new Venta(tiempo,
                        result.getDouble("litros_cargados"),
                        result.getDouble("monto_abonado")));

            }
            result.close();
            consulta.close();
            conexion.conexion().close();

            return ventas;

        } catch (SQLException e){
            throw new RuntimeException("No se pudo recuperar la lista de ventas.", e);
        }
    }
}
