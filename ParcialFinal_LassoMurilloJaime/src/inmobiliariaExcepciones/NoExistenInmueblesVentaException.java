package inmobiliariaExcepciones;

/* @author Jaime Lasso */

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NoExistenInmueblesVentaException extends Exception{
    
    JPanel exception;
    
    public NoExistenInmueblesVentaException(JPanel exc){
        this.exception = exception;
    }
    
    public void message(){
        JOptionPane.showMessageDialog(exception, "Recuerde: Para vender inmuebles, "
                + "es importante que se encuentren algunos disponibles para su venta. "
                + "Inténtelo de nuevo...");
    }
    
}
