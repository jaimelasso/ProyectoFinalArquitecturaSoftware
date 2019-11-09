package UI_InmobiliariaK;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

/* @author Jaime Lasso */

public class MainWindow extends JFrame{
    
    //Constructor
    public MainWindow(){
        setTitle("Inmobiliaria K");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel Superior
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/LogoIK.png"));
        PanelSuperior ps = new PanelSuperior(icon.getImage());
        setVisible(true);
        TitledBorder tb = BorderFactory.createTitledBorder("");
        ps.setBorder(tb);
        getContentPane().add(ps, BorderLayout.NORTH);
        
        //Panel Inferior        
        PanelInferior pi = new PanelInferior();
        TitledBorder tBpi = BorderFactory.createTitledBorder("Opciones");
        pi.setBorder(tBpi);
        add(pi, BorderLayout.SOUTH);

        //Panel Derecho
        PanelDerecho pd = new PanelDerecho();
        add(pd, BorderLayout.EAST);

        //Panel Central        
        PanelCentral pc = new PanelCentral();
        TitledBorder tBpc = BorderFactory.createTitledBorder("Detalle inmueble");
        pc.setBorder(tBpc);
        add(pc, BorderLayout.CENTER);
      
    }
    
}
