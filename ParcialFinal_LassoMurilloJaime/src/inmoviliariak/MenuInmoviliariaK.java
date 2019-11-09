package inmoviliariak;

/** @author Jaime Lasso*/

import inmobiliariaExcepciones.ImpuestosSinVentasException;
import inmobiliariaExcepciones.TipoNoIdentificadoException;
import inmobiliariaExcepciones.IDEquivocadoVentaException;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class MenuInmoviliariaK {

    public static ArrayList<Inmueble> grupoInmuebles = new ArrayList<>();
    public static ArrayList<Inmueble> InmueblesVendidos = new ArrayList<>();
    public static double valorTotalNeto = 0;
    public static double valorTotalImpuestos = 0;
    public static double valorTotalGanancia = 0;
    
    public MenuInmoviliariaK(){
        grupoInmuebles = new ArrayList<>();
    }
    
    
    /*public static void main(String[] args) {
        MenuInmoviliariaK menu = new MenuInmoviliariaK();
        menu.desplegarMenu();
    }*/

    public static void desplegarMenu() {
        System.out.println("\n--- Inmoviliaria Konrad Menu ---");
        System.out.println("Ingrese una opcion:");
        System.out.println("1. Agregar inmueble.");
        System.out.println("2. Mostrar inmuebles disponibles.");
        System.out.println("3. Vender Inmueble.");
        System.out.println("4. Dar total recaudado por ventas netas.");
        System.out.println("5. Dar impuestos pagados.");
        System.out.println("6. Dar total recaudes despues de impuestos.");
        System.out.println("7. Dar inmueble con precio base más bajo.");
        System.out.println("8. Dar estrato que más inmuebles tiene a la venta.");
        System.out.println("9. Dar número de casas que no son fincas y tienen más de 3 parqueaderos.");
        System.out.println("10. Dar número de inmuebles disponibles a la venta");        
        System.out.println("0. Salir.");        
        System.out.print("\nIngrese opción: ");
        Scanner scanner = new Scanner(System.in);
        String opcionSeleccionada = scanner.nextLine();
        switch (opcionSeleccionada){
            case "1":
                agregarInmueble();
                break;
            case "2":
                mostrarInmueblesDisponibles();
                break;
            case "3":
                venderInmueble();
                break;
            case "4":
                darRecaudoNeto();
                break;
            case "5":
                darImpuestosPagados();
                break;
            case "6":
                darRecaudosDespuesDeImpuestos();
                break;
            case "7":
                darInmueblePrecioBajo();
                break;
            case "8":
                darEstratoConInmuebles();
                break;
            case "9":
                //darCasasQueNoSonFincas();
                break;
            case "10":
                try {
                    darCantidadInmueblesVenta();
                }catch (TipoNoIdentificadoException e){
                    System.out.println(e.getMessage());
                    desplegarMenu();
                }
                break;
            case "0":
                System.exit(0);
                break;
        }
        desplegarMenu();
        
    }

    public static void agregarInmueble() {
        System.out.println("\n¿Qué tipo de inmueble desea ingresar?");
        System.out.println("1. Oficinas");
        System.out.println("2. Casas");
        System.out.println("3. Apartamentos");
        System.out.println("4. Fincas");
        System.out.println("0. Salir");
        System.out.print("\nIngrese opción: ");

        Scanner scanner = new Scanner(System.in);
        String opcionSeleccionada = scanner.nextLine();
        try{
            switch (opcionSeleccionada){
                case "1":
                    agregarOficina();
                    break;
                case "2":
                    agregarCasa();
                    break;
                case "3":
                    agregarApartamento();
                   break;
                case "4":
                    agregarFinca();
                    break;
                case "0":
                    System.exit(0);
                    break;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Recuerde cómo debe ingresar los datos de los inmuebles."
                    + "\nNota-> Cada parámetro va separado por '-' como se indica en el manual del usaurio"
                    + "\nInténtelo de nuevo...");
        }                    
                    
        desplegarMenu();
    }

    public static String capturarDatos(String str){
        String dato;
        dato = JOptionPane.showInputDialog(str);
        return dato;
    }
    
    public static void agregarFinca(){
        System.out.println("\n Ingrese los datos de la finca:");
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        
        String[] datosFinca = texto.split("-");
        
        int id = Integer.parseInt(datosFinca[0]);
        int tipo = Integer.parseInt(datosFinca[1]);
        int mConstruidos = Integer.parseInt(datosFinca[2]);
        int estrato = Integer.parseInt(datosFinca[3]);
        int valorMetro = Integer.parseInt(datosFinca[4]);
        int numParqueaderos = Integer.parseInt(datosFinca[5]);
        boolean vigPrivada = Boolean.parseBoolean(datosFinca[6]);
        int aConstruccion = Integer.parseInt(datosFinca[7]);
        
        Finca nuevaFinca = new Finca(id, tipo, mConstruidos, estrato, valorMetro, 
                numParqueaderos, vigPrivada, aConstruccion);
        
        grupoInmuebles.add(nuevaFinca);
        
        System.out.println("Oficina agregada con éxito!");
    }

    public static String agregarOficina(){
        String texto = capturarDatos("Ingrese los datos de la oficina:"
                + "\nUsuario: Recuerde que cada parámetro debe ser separado por un guión");
        
        String[] datosOficina = texto.split("-");
        
        int id = Integer.parseInt(datosOficina[0]);
        int tipo = Integer.parseInt(datosOficina[1]);
        int mConstruidos = Integer.parseInt(datosOficina[2]);
        int estrato = Integer.parseInt(datosOficina[3]);
        int valorMetro = Integer.parseInt(datosOficina[4]);
        boolean pVisitantes = Boolean.parseBoolean(datosOficina[5]);
        
        Oficina nuevaOficina = new Oficina(id, tipo, mConstruidos, estrato, valorMetro, pVisitantes);
        
        grupoInmuebles.add(nuevaOficina);
        
        System.out.println("Oficina agregada con éxito!");
        return texto;
    }

    public static String agregarCasa(){
        String texto = capturarDatos("Ingrese los datos de la casa:"
                + "\nUsuario: Recuerde que cada parámetro debe ser separado por un guión");
      
        String[] datosCasa = texto.split("-");
        
        int id = Integer.parseInt(datosCasa[0]);
        int tipo = Integer.parseInt(datosCasa[1]);
        int mConstruidos = Integer.parseInt(datosCasa[2]);
        int estrato = Integer.parseInt(datosCasa[3]);
        int valorMetro = Integer.parseInt(datosCasa[4]);
        int numParqueaderos = Integer.parseInt(datosCasa[5]);
        boolean vigPrivada = Boolean.parseBoolean(datosCasa[6]);
        
        Casa nuevaCasa = new Casa(id, tipo, mConstruidos, estrato, valorMetro, numParqueaderos, vigPrivada);
        
        grupoInmuebles.add(nuevaCasa);
        
        System.out.println("Oficina agregada con éxito!");
        return texto;
    }

    public static String agregarApartamento(){
        String texto = capturarDatos("Ingrese los datos del apartamento:"
                + "\nUsuario: Recuerde que cada parámetro debe ser separado por un guión");
       
        String[] datosCasa = texto.split("-");
        
        int id = Integer.parseInt(datosCasa[0]);
        int tipo = Integer.parseInt(datosCasa[1]);
        int mConstruidos = Integer.parseInt(datosCasa[2]);
        int estrato = Integer.parseInt(datosCasa[3]);
        int valorMetro = Integer.parseInt(datosCasa[4]);
        int numParqueaderos = Integer.parseInt(datosCasa[5]);
        int piso = Integer.parseInt(datosCasa[6]);
        
        Apartamento nuevoApartamento = new Apartamento(id, tipo, mConstruidos, estrato, valorMetro, numParqueaderos, piso);
        
        grupoInmuebles.add(nuevoApartamento);
        
        System.out.println("Apartamento agregado con éxito!");
        return texto;
    }
    
    public static boolean isEmpty(){
        boolean vacio;
        if(grupoInmuebles.size() == 0){
            vacio = true;
        }else{
            vacio = false;
        }
        return vacio;
    }
    
    public static void mostrarInmueblesDisponibles() {
        System.out.println("\nInmuebles comprados: ");
        for (int i = 0; i < grupoInmuebles.size(); i++){
            System.out.println(grupoInmuebles.get(i).toString());
        }   
    }
    
    public static void mostrarString(String str){
        JOptionPane.showMessageDialog(null, str);
    }
    
    public static String venderInmueble(){
        String inmVendido = "";
        int id = Integer.parseInt(capturarDatos("Ingrese ID del inmueble a vender:"));
        boolean noExiste = true;
        
        for (int i = 0; i < grupoInmuebles.size();i++){
            if (grupoInmuebles.get(i).getId() == id){
                int mConstruidos = grupoInmuebles.get(i).getmConstruidos();
                int valorMetro = grupoInmuebles.get(i).getValorMetro();
                double valorBase = grupoInmuebles.get(i).calcularValorBase(mConstruidos, valorMetro);
                double valorVenta = grupoInmuebles.get(i).calcularValorVenta(valorBase);
                
                System.out.println("Valor Base: " + valorBase);
                System.out.println("Valor Venta: " + valorVenta);
                
                valorTotalNeto += valorVenta;
                valorTotalImpuestos += grupoInmuebles.get(i).calcularImpuestos(valorVenta);
                
                inmVendido = grupoInmuebles.get(i).toString();
                
                InmueblesVendidos.add(grupoInmuebles.get(i));
                
                grupoInmuebles.remove(i);
                mostrarString("Inmueble ID: " + id + " ha sido vendido.\n" + 
                        "Valor Base: " + valorBase + "\n" +
                        "Valor Venta: " + valorVenta);
                
                noExiste = false;

                break;
            }else{
                noExiste = true;
            }
        }
        
        if(noExiste){
            mostrarString("El ID ingresado no exite. Inténtelo de nuevo...");
            //IDEquivocadoVentaException excepcion = new IDEquivocadoVentaException(id);
            //throw excepcion;
        }else{
            return inmVendido;
        }
        return "";
      
    }

                


    
    public static void darRecaudoNeto() {
        mostrarString("El valor total neto vendido es de: " + valorTotalNeto);
    }
    
    public static void darImpuestosPagados(){
            mostrarString("El valor total de impuestos pagados por ventas: " + valorTotalImpuestos);
    }
    
    public static void darRecaudosDespuesDeImpuestos() {
        valorTotalGanancia = valorTotalNeto - valorTotalImpuestos;
        mostrarString("El valor total ventas luego de impuestos: " + valorTotalGanancia);
    }

    public static void darInmueblePrecioBajo(){
        int id = 0;
        for (int i = 0; i < grupoInmuebles.size();i++){
            
            int mConstruidos = grupoInmuebles.get(i).getmConstruidos();
            int valorMetro = grupoInmuebles.get(i).getValorMetro();
            double valorBase = grupoInmuebles.get(i).calcularValorBase(mConstruidos, valorMetro);
            
            double valorMinimo = 0;
            
            if (valorBase > valorMinimo){
                id = grupoInmuebles.get(i).getId();
            }
        }
        System.out.println("El inmueble con el valor base más bajo, tiene el ID: " + id);
    }
    
    public static void darEstratoConInmuebles(){
        int [] arrayEstratos = new int[6];
        
        for (int i = 0; i < arrayEstratos.length; i++){
            arrayEstratos[i] = 0;
        }
        
        for (int i = 0; i < grupoInmuebles.size();i++){
            
            int estrato = grupoInmuebles.get(i).getEstrato();
            
            if(estrato == 1){
                arrayEstratos[0] += 1;
            }else if (estrato == 2){
                arrayEstratos[1] += 1;
            }else if (estrato == 3){
                arrayEstratos[2] += 1;
            }else if (estrato == 4){
                arrayEstratos[3] += 1;
            }else if (estrato == 5){
                arrayEstratos[4] += 1;
            }else if (estrato == 6){
                arrayEstratos[5] += 1;
            }
        }
        
       
        int posicion = 0;
        int cantidad = 0;

        for (int i = 0; i < arrayEstratos.length; i++){
            int temporal = arrayEstratos[i];
            
            if (temporal > cantidad){
                posicion = i+1;
            }
        }
        
        System.out.println("El estrato que más inmuebles tiene a la venta es: " + posicion);


    }

    public static void darCantidadInmueblesVenta() throws TipoNoIdentificadoException{
        System.out.println("Ingrese el tipo de inmueble que desea contar: ");
        Scanner sc = new Scanner(System.in);
        int tipo = sc.nextInt();
        int contador = 0;
        
        if (tipo < 1 || tipo > 4){
            TipoNoIdentificadoException exception = new TipoNoIdentificadoException(tipo);
            throw exception;
        }
        
        for (int i = 0; i < grupoInmuebles.size(); i++){
            if(tipo == grupoInmuebles.get(i).getTipo()){
                contador++;
            }
        }
        System.out.println("\nLa cantidad de inmuebles tipo " + tipo + " diponibles: " + contador);
    }


    
}
