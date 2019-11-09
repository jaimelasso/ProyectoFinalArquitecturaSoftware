package inmobiliariaExcepciones;

/* @author Jaime Lasso */

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NoRecuperarInmVendidosException extends Exception{
    
    JPanel exception;
    
    public NoRecuperarInmVendidosException(JPanel exc){
        this.exception = exception;
    }
    
    public void message(){
        JOptionPane.showMessageDialog(exception, "Recuerde: Para recuperar los inmuebles ya vendidos, "
                + "es importante que se haya efectuado alguna venta. "
                + "Inténtelo de nuevo...");
    }
    
}