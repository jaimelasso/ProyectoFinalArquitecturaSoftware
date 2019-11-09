package inmoviliariak;

/** @author Jaime Lasso*/

public class Oficina extends Inmueble {
    
    //Atributos
    private boolean pVisitantes;
    
    //Constructor

    public Oficina(int id, int tipo, int mConstruidos, int estrato, int valorMetro) {
        super(id, tipo, mConstruidos, estrato, valorMetro);
    }

    public Oficina(int id, int tipo, int mConstruidos, int estrato, int valorMetro, boolean pVisitantes) {
        super(id, tipo, mConstruidos, estrato, valorMetro);
        this.pVisitantes = pVisitantes;
    }

    
    //Setters y Getters

    public void setpVisitantes(boolean pVisitantes) {
        this.pVisitantes = pVisitantes;
    }

    public boolean ispVisitantes() {
        return pVisitantes;
    }
    
    public String getpVisitantes(){
        String flag = "";
        if (ispVisitantes()){
            flag = "True";
        }else{
            flag = "False";
        }
        return flag;
    }
    
    @Override
    public String toString() {
        return getId() + "-" + getTipo() + "-" + getmConstruidos() + "-" + getEstrato() + "-" + getValorMetro() + "-" + getpVisitantes();
    }


    @Override
    public double calcularValorVenta(double valorBase){
        double valorVenta = super.calcularValorVenta(valorBase);
        double incremento = valorBase * 0.05 * getEstrato();
        valorVenta = valorVenta + incremento;
        
        double impuesto;
        if(ispVisitantes()){
            impuesto = valorBase * 0.2;
            valorVenta = valorVenta + impuesto;
        }else{
            impuesto = valorBase * 0.1;
            valorVenta = valorVenta - impuesto;
        }
        
        return valorVenta;
    }    
    
    @Override
    public double calcularImpuestos(double valorVenta){
        double impuestos = super.calcularImpuestos(valorVenta);
        if(getmConstruidos() > 100){
            impuestos += valorVenta * 0.07;
        }
        return impuestos;
    }
    
}
