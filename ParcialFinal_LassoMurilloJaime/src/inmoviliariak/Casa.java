package inmoviliariak;

/** @author Jaime Lasso*/

public class Casa extends Inmueble {
    
    //Atributos
    private int numParqueaderos;
    private boolean vigPrivada;
    
    //Constructor

    public Casa(int id, int tipo, int mConstruidos, int estrato, int valorMetro) {
        super(id, tipo, mConstruidos, estrato, valorMetro);
    }
    
    public Casa(int id, int tipo, int mConstruidos, int estrato, int valorMetro, 
            int numParqueaderos, boolean vigPrivada){
        super(id, tipo, mConstruidos, estrato, valorMetro);
        this.numParqueaderos = numParqueaderos;
        this.vigPrivada = vigPrivada;
    }
    
    //Setters y Getters

    public void setNumParqueaderos(int numParqueaderos) {
        this.numParqueaderos = numParqueaderos;
    }

    public void setVigPrivada(boolean vigPrivada) {
        this.vigPrivada = vigPrivada;
    }

    public int getNumParqueaderos() {
        return numParqueaderos;
    }

    public boolean isVigPrivada() {
        return vigPrivada;
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
                + "-" + getNumParqueaderos() + "-" + getVigPrivada();
    }
    
    @Override
    public double calcularValorVenta(double valorBase){
        double valorVenta = super.calcularValorVenta(valorBase);
        if(!isVigPrivada()){
            double decremento = valorBase * 0.1;
            valorVenta = valorVenta - decremento;
        }
        return valorVenta;
    }

}
