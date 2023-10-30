package uniandes.dpoo.taller4.modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File; 
import java.util.Collection;

public class VentanaTop10 extends JFrame {
    private JTable tablaTop10;
    private DefaultTableModel modeloTabla;

    public VentanaTop10(Top10 top10) {
        setTitle("Top 10 de Jugadores");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Puntaje");

        tablaTop10 = new JTable(modeloTabla);
        tablaTop10.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(tablaTop10);
        add(scrollPane, BorderLayout.CENTER);
        cargarRegistros(top10.darRegistros());
    }

    private void cargarRegistros(Collection<RegistroTop10> registros) {
        for (RegistroTop10 registro : registros) {
            modeloTabla.addRow(new Object[]{registro.darNombre(), registro.darPuntos()});
        }
    }

    public static void main(String[] args) {
    	File archivo = new File("src/data/top10.csv");
        Top10 top10 = new Top10();
        top10.cargarRecords(archivo);

        VentanaTop10 ventanaTop10 = new VentanaTop10(top10);
        ventanaTop10.setVisible(true);
    }

}

