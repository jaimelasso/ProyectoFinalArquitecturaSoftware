package inmobiliariaExcepciones;

/* @author Jaime Lasso */

public class TipoNoIdentificadoException extends Exception{
    
    private int tipo;
    
    public TipoNoIdentificadoException (int tipo){
        this.tipo = tipo;
    }
    
    @Override
    public String getMessage(){
        return "Ha ingresado el inmueble tipo " + tipo + " el cual NO ES CORRECTO." +
                "\nRecuerde los tipos correctos son: + "
                + "\n1 = Oficina"
                + "\n2 = Casa"
                + "\n3 = Apartamento"
                + "\n4 = Finca";
    }
    
}
