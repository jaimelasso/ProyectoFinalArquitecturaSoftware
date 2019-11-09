package inmoviliariak;

/** @author Jaime Lasso*/

public class Apartamento extends Inmueble {
    
    //Atributos
    private int numParqueaderos;
    private int piso;
    
    //Constructor

    public Apartamento(int id, int tipo, int mConstruidos, int estrato, int valorMetro) {
        super(id, tipo, mConstruidos, estrato, valorMetro);
    }

    public Apartamento(int id, int tipo, int mConstruidos, int estrato, int valorMetro, int numParqueaderos, int piso) {
        super(id, tipo, mConstruidos, estrato, valorMetro);
        this.numParqueaderos = numParqueaderos;
        this.piso = piso;
    }
    
    //Setters

    public void setNumParqueaderos(int numParqueaderos) {
        this.numParqueaderos = numParqueaderos;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumParqueaderos() {
        return numParqueaderos;
    }

    public int getPiso() {
        return piso;
    }

    @Override
    public String toString() {
        return getId() + "-" + getTipo() + "-" + getmConstruidos() + "-" + getEstrato() + "-" + getValorMetro() + "-" + getNumParqueaderos() + "-" + getPiso();
    }

    @Override
    public double calcularValorVenta(double valorBase){
        double valorVenta = super.calcularValorVenta(valorBase);
        double decremento = valorBase * 0.015 * getPiso();
        valorVenta = valorVenta - decremento;
        return valorVenta;
    }
    
}
