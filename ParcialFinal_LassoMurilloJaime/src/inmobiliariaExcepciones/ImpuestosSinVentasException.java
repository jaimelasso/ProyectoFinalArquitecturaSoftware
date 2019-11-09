package inmobiliariaExcepciones;

/* @author Jaime Lasso */

public class ImpuestosSinVentasException extends Exception{
    
    private double valorTotalImpuestos;
    
    public ImpuestosSinVentasException (double valorTotalImpuestos){
        this.valorTotalImpuestos = valorTotalImpuestos;        
    }
    
    @Override
    public String getMessage(){
        return "Para calcular los impuestos, es necesario que POR LO MENOS HAYA VENDIDO UN INMUEBLE"
                + "\nVuelva a intentarlo...";
    }
}
