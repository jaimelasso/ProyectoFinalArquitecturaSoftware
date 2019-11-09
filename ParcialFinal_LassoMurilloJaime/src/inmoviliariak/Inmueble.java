package inmoviliariak;

/** @author Jaime Lasso*/

public class Inmueble {
    
    //Atributos
    private int id;
    private int tipo;
    private int mConstruidos;
    private int estrato;
    private int valorMetro;
    
    //Construtor
    
    public Inmueble(int id, int tipo, int mConstruidos, int estrato, int valorMetro){
        this.id = id;
        this.tipo = tipo;
        this.mConstruidos = mConstruidos;
        this.estrato = estrato;
        this.valorMetro = valorMetro;
    }

    //Setters y Getters

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setmConstruidos(int mConstruidos) {
        this.mConstruidos = mConstruidos;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public void setValorMetro(int valorMetro) {
        this.valorMetro = valorMetro;
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public int getmConstruidos() {
        return mConstruidos;
    }

    public int getEstrato() {
        return estrato;
    }

    public int getValorMetro() {
        return valorMetro;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + ", tipo=" + tipo + ", mConstruidos=" + mConstruidos + ", estrato=" + estrato + ", valorMetro=" + valorMetro + '}';
    }

    public double calcularValorBase(int mConstruidos, int valorMetro){
        double valorBase = this.mConstruidos * this.valorMetro;
        return valorBase;
    }
    
    public double calcularValorVenta(double valorBase){
        double valorVenta = valorBase + (valorBase * 0.025);
        return valorVenta;
    }
    
    public double calcularImpuestos(double valorVenta){
        return valorVenta * 0.05;
    }
    
}