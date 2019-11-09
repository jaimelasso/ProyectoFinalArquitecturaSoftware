package inmobiliariaExcepciones;

/* @author Jaime Lasso */

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NoSuficientesOficinasException extends Exception{
    
    JPanel exception;
    
    public NoSuficientesOficinasException(JPanel exc){
        this.exception = exception;
    }
    
    public void message(){
        JOptionPane.showMessageDialog(exception, "Recuerde: Para poder vender las dos oficinas más costosas, "
                + "es importante que por lo menos existan dos oficinas disponibles a la venta."
                + "Inténtelo de nuevo...");
    }
    
}