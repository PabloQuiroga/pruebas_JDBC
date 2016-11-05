package pruebasjdbc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Interfaz para el manejo de inventario
 * 
 * @author Pablo Daniel Quiroga
 */
public class Inventario {
    private JFrame ventana;
    private JPanel contentPane;
    
    public Inventario(){
        initComponents();
        ventana.setTitle("Administracion de Inventario");
        ventana.setSize(600, 600);
        ventana.setPreferredSize(new Dimension(600, 600));
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    /**
     * Punto de inicio de la app
     * @param args
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Inventario frame = new Inventario();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
    }
    
    private void initComponents(){
        ventana = new JFrame();
        
        JMenuBar barra = new JMenuBar();
            JMenu menuProd = new JMenu("Producto");
                JMenuItem itNuevo = new JMenuItem("Alta");
                itNuevo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nuevo();
                    }
                });
                menuProd.add(itNuevo);
                JMenuItem itUpdate = new JMenuItem("Modificacion");
                itUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actualizar();
                    }
                });
                menuProd.add(itUpdate);
                JMenuItem itBorrar = new JMenuItem("Baja");
                itBorrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        borrar();
                    }
                });
                menuProd.add(itBorrar);
                JMenuItem itSalir = new JMenuItem("Salir");
                itSalir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        salir();
                    }
                });
                menuProd.add(itSalir);
            barra.add(menuProd);
            JMenu menuLista = new JMenu("Listado");
                JMenuItem itVer = new JMenuItem("Ver listado");
                itVer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrar();
                    }
                });
                menuLista.add(itVer);
                JMenuItem itBuscar = new JMenuItem("Busqueda");
                itBuscar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buscar();
                    }
                });
                menuLista.add(itBuscar);
            barra.add(menuLista);
        ventana.setJMenuBar(barra);
        
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
            //aqui componentes
        ventana.add(contentPane);
    }
    
    private void nuevo(){
        //estos pa pruebas
        JLabel etiPrueba = new JLabel("Hola");
        contentPane.add(etiPrueba, BorderLayout.NORTH);
        ventana.pack();//todos estos es "a revision"
    }
    private void actualizar(){
        // bla bla bla
        ventana.pack();
    }
    private void borrar(){
        // bla bla bla
        ventana.pack();
    }
    private void salir(){
        //aqui cerrar los servicios antes
        ventana.dispose();
    }
    private void mostrar(){
        //bla bla bla
        ventana.pack();
    }
    private void buscar(){
        //bla bla bla
        ventana.pack();
    }
}
