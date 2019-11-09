package UI_InmobiliariaK;

import java.awt.*;
import javax.swing.JPanel;

/* @author Jaime Lasso */

public class PanelSuperior extends JPanel{
    
    private Image img;
    
    public PanelSuperior(Image img){
        this.img = img;
        Dimension dimension = new Dimension(img.getWidth(null), img.getHeight(null));
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setSize(dimension);
        this.setLayout(null);
        this.setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, null);
    }
    
    
}
