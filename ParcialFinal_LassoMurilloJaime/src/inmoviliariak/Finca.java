package inmoviliariak;

/** @author Jaime Lasso*/

public class Finca extends Inmueble{
    
    //Atributo nuevo
    private int numParqueaderos;
    private boolean vigPrivada;
    private int aConstruccion;
    
    //constructor

    public Finca(int id, int tipo, int mConstruidos, int estrato, int valorMetro, 
            int numParqueaderos, boolean vigPrivada, int aConstruccion) {
        super(id, tipo, mConstruidos, estrato, valorMetro);
        this.numParqueaderos = numParqueaderos;
        this.vigPrivada = vigPrivada;
        this.aConstruccion = aConstruccion;
    }
    
    //Setters y Getters

    public void setNumParqueaderos(int numParqueaderos) {
        this.numParqueaderos = numParqueaderos;
    }

    public void setVigPrivada(boolean vigPrivada) {
        this.vigPrivada = vigPrivada;
    }

    public void setaConstruccion(int aConstruccion) {
        this.aConstruccion = aConstruccion;
    }

    public int getNumParqueaderos() {
        return numParqueaderos;
    }

    public boolean isVigPrivada() {
        return vigPrivada;
    }

    public int getaConstruccion() {
        return aConstruccion;
    }
    
    public String getVigPrivada(){
        String flag = "";
        if (isVigPrivada()){
            flag = "True";
        }else{
            flag = "False";
        }
        return flag;
    }
    
    @Override
    public String toString() {
        return getId() + "-" + getTipo() + "-" + getmConstruidos() + "-" + getEstrato() + "-" + getValorMetro()
                + "-" + getNumParqueaderos() + "-" + getVigPrivada() + "-" + getaConstruccion();
    }
    
    @Override
    public double calcularValorVenta(double valorBase){
        double valorVenta = super.calcularValorVenta(valorBase);
        if(!isVigPrivada()){
            double decremento = valorBase * 0.1;
            valorVenta = valorVenta - decremento;
        }
        double decremento = valorBase * 0.05 * getaConstruccion();
        valorVenta = valorVenta - decremento;
        return valorVenta;
    }    


    
}
