package inmobiliariaExcepciones;

/** Jaime Lasso */

public class IDEquivocadoVentaException extends Exception {
    private int IDInmueble;
    
    public IDEquivocadoVentaException(int IDInmueble){
        this.IDInmueble = IDInmueble;
    }
    
    @Override
    public String getMessage(){
        return "El ID " + this.IDInmueble + "que ha digitado no existe."
                + "\n le recordamos dirigirse a la opción 2 del menú"
                + "\n para que conozca los ID disponibles a la venta"
                + "\n Inténtelo de nuevo";
    }
    
}
