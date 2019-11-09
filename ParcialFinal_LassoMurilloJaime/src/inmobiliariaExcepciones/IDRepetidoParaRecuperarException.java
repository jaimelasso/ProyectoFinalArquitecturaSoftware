package inmobiliariaExcepciones;

/* @author Jaime Lasso */

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class IDRepetidoParaRecuperarException extends Exception{
    
    JPanel exception;
    
    public IDRepetidoParaRecuperarException(JPanel exc){
        this.exception = exception;
    }
    
    public void message(){
        JOptionPane.showMessageDialog(exception, "Recuerde: No puede recuperar inmuebles vendidos a disponibles "
                + "si alguno de estos tiene un ID igual a los inmuebles disponibles. "
                + "Inténtelo de nuevo...");
    }
    
}