package UI_InmobiliariaK;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* @author Jaime Lasso */

public class ImagesTipoInmueble extends JPanel{
    private ImageIcon imagen;
    private String url;
    
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        imagen = new ImageIcon(getClass().getResource(url));
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paint(g);
    }
    
    public void setURL(String url){
        this.url = url;
    }
    
}
