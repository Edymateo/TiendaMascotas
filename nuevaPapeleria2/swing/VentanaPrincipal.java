package swing;

import java.awt.*;
import javax.swing.*;

import modelo.Inventario;
import modelo.ItemInventario;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private JPanel panelMenu;
    private JPanel panelContenido;
    private CardLayout cardLayout;
    private Inventario inventario;

    public VentanaPrincipal() {
        initComponents();
        iniciarInterfaz();
    }

    private void iniciarInterfaz() {
        setTitle("Menú Principal - Sistema de Inventario");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMenu = new JPanel(new GridLayout(7, 1, 10, 10));
        panelMenu.setPreferredSize(new Dimension(200, getHeight()));
        panelMenu.setBackground(new Color(44, 62, 80));

        String[] opciones = {
            "Ver Inventario", "Entrada Inventario", "Salida Inventario",
            "Modificar Producto", "Buscar Producto", "Guardar Producto", "Salir"
        };

        for (String opcion : opciones) {
            JButton boton = new JButton(opcion);
            boton.setFocusPainted(false);
            boton.setForeground(Color.WHITE);
            boton.setBackground(new Color(52, 73, 94));
            boton.setFont(new Font("Arial", Font.PLAIN, 14));

            boton.addActionListener(e -> {
                if (opcion.equals("Salir")) {
                    System.exit(0);
                } else {
                    cardLayout.show(panelContenido, opcion);
                }
            });

            panelMenu.add(boton);
        }

        panelContenido = new JPanel();
        cardLayout = new CardLayout();
        panelContenido.setLayout(cardLayout);

        // Sustituye estos paneles con los tuyos reales según los nombres
        panelContenido.add(new PanelVerInventario(inventario), "Ver Inventario");
        panelContenido.add(new PanelEntradaInventario(inventario), "Entrada Inventario");
        panelContenido.add(new JLabel("Registrar Salida", SwingConstants.CENTER), "Salida Inventario");
        panelContenido.add(new JLabel("Modificar Producto", SwingConstants.CENTER), "Modificar Producto");
        panelContenido.add(new JLabel("Buscar Producto 🔍", SwingConstants.CENTER), "Buscar Producto");
        panelContenido.add(new JLabel("Guardar Producto", SwingConstants.CENTER), "Guardar Producto");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelMenu, BorderLayout.WEST);
        getContentPane().add(panelContenido, BorderLayout.CENTER);

        cardLayout.show(panelContenido, "Ver Inventario");
    }

    private void initComponents() {
        // Puedes dejar este método vacío si todo se hace en iniciarInterfaz()
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}


    // Variables declaration - do not modify                     
    // End of variables declaration                   



