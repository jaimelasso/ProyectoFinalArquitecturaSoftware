package UI_InmobiliariaK;

import javax.swing.JFrame;

/* @author Jaime Lasso */

public class FrameLogo extends JFrame {
  
    public FrameLogo() {
        ImageFondo image=new ImageFondo();
        image.setImage("/images/logoIK.png");
        setContentPane(image);
    }

     
}
