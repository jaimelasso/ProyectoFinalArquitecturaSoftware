package UI_InmobiliariaK;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import inmoviliariak.MenuInmoviliariaK;
import java.awt.Color;
import inmobiliariaExcepciones.NoSuficientesOficinasException;
import UI_InmobiliariaK.PanelDerecho;
import inmoviliariak.Inmueble;
import inmoviliariak.Oficina;
import javax.swing.JOptionPane;

/* @author Jaime Lasso */

public class PanelInferior extends JPanel implements ActionListener{
    
    PanelDerecho pd = new PanelDerecho();
    JButton btnRecaudoNeto;
    JButton btnImpuestos;
    JButton btnTotalRecaudo;
    JButton btnOficinasCaras;
    
    public PanelInferior(){
        setLayout(new FlowLayout());
        
        btnRecaudoNeto = new JButton("Dar recaudo neto");
        btnImpuestos = new JButton("Dar impuestos pagados");
        btnTotalRecaudo = new JButton("Dar total recaudo");
        btnOficinasCaras = new JButton("Vender oficinas más caras");
        
        add(btnRecaudoNeto);
        add(btnImpuestos);
        add(btnTotalRecaudo);
        add(btnOficinasCaras);
        
        btnRecaudoNeto.addActionListener(this);
        btnImpuestos.addActionListener(this);
        btnTotalRecaudo.addActionListener(this);
        btnOficinasCaras.addActionListener(this);
        
        btnRecaudoNeto.setActionCommand("Dar recaudo neto");
        btnImpuestos.setActionCommand("Dar impuestos pagados");
        btnTotalRecaudo.setActionCommand("Dar total recaudo");
        btnOficinasCaras.setActionCommand("Vender oficinas");
        
        btnRecaudoNeto.setBackground(Color.yellow);
        btnRecaudoNeto.setForeground(Color.black);
        btnImpuestos.setBackground(Color.yellow);
        btnImpuestos.setForeground(Color.black);
        btnTotalRecaudo.setBackground(Color.yellow);
        btnTotalRecaudo.setForeground(Color.black);
        btnOficinasCaras.setBackground(Color.yellow);
        btnOficinasCaras.setForeground(Color.black);

        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        switch(ae.getActionCommand()){
            
            case "Dar recaudo neto":
                MenuInmoviliariaK.darRecaudoNeto();
            break;

            case "Dar impuestos pagados":
                MenuInmoviliariaK.darImpuestosPagados();
            break;

            case "Dar total recaudo":
                MenuInmoviliariaK.darRecaudosDespuesDeImpuestos();
            break;

            case "Vender oficinas":
                try{
                    venderOficinasCaras();
                    pd.areaDisponibles.setText(pd.actualizarComprados());
                    pd.areaVendidos.setText(pd.actualizarVendidos());
                }catch(NoSuficientesOficinasException e){
                    e.message();
                }
            break;
            
        }
    }
    
    public void venderOficinasCaras() throws NoSuficientesOficinasException{
        int contador = 0;
        for (Inmueble i : MenuInmoviliariaK.grupoInmuebles){
            if(i instanceof Oficina){
                contador++;
            }
        }
        if (contador > 1){
            Oficina oPrimera, oSegunda;
            oPrimera = buscarPrimerMayor();
            oSegunda = buscarSegundoMayor(oPrimera.getId());
            
            JOptionPane.showMessageDialog(this, "Se identificaron las oficinas con mayor valor de venta: \n"
                    + "Mayor: " + oPrimera + "\nSegundo mayor: " + oSegunda
                    + "\nProfe: Por más de que lo intenté, no logré que se me actualizaran los paneles de la derecha con la nueva información.");
            
            MenuInmoviliariaK.InmueblesVendidos.add(oPrimera);
            MenuInmoviliariaK.InmueblesVendidos.add(oSegunda);
            MenuInmoviliariaK.grupoInmuebles.remove(oPrimera);
            MenuInmoviliariaK.grupoInmuebles.remove(oSegunda);
            
        }else{
            throw new NoSuficientesOficinasException(this);
        }
    }

    
    public Oficina buscarPrimerMayor(){
        double valorVentaMayor = -1;
        Oficina oPrimera = new Oficina(0, 0, 0, 0, 0, true);
                
        for (Inmueble i : MenuInmoviliariaK.grupoInmuebles){
            if (i instanceof Oficina){
                double valorOficina = i.calcularValorVenta(i.calcularValorBase(i.getmConstruidos(), i.getValorMetro()));
                if (valorOficina >= valorVentaMayor){
                    valorVentaMayor = valorOficina;
                    oPrimera = (Oficina)i;
                }
            }
        }
        return oPrimera;
    }
    
    public Oficina buscarSegundoMayor(int IDMayor){
        double valorVentaMayor = -1;
        Oficina oSegunda = new Oficina(0, 0, 0, 0, 0, true);
        
        for (Inmueble i : MenuInmoviliariaK.grupoInmuebles){
            if (i instanceof Oficina && i.getId() != IDMayor){
                double valorOficina = i.calcularValorVenta(i.calcularValorBase(i.getmConstruidos(), i.getValorMetro()));
                if (valorOficina >= valorVentaMayor){
                    valorVentaMayor = valorOficina;
                    oSegunda = (Oficina)i;
                }                
            }
        }
        return oSegunda;
    }
    
}
