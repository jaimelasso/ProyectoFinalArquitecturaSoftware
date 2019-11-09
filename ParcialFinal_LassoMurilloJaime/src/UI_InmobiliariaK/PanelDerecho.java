package UI_InmobiliariaK;

/* @author Jaime Lasso */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import inmoviliariak.*;
import java.awt.Color;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import inmobiliariaExcepciones.NoExistenInmueblesVentaException;
import inmobiliariaExcepciones.NoRecuperarInmVendidosException;
import inmobiliariaExcepciones.IDRepetidoParaRecuperarException;

public class PanelDerecho extends JPanel implements ActionListener{
    
    JTextField inmDisponibles;
    JScrollPane scrollDisponibles;
    JTextArea areaDisponibles;
    JTextField inmVendidos;
    JScrollPane scrollVendidos;
    JTextArea areaVendidos;
    JButton btnAgregar;
    JButton btnVender;
    JButton btnRecuperarVendidos;
    
    public PanelDerecho(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        inmDisponibles = new JTextField("Inmuebles Disponibles");
        inmDisponibles.setEditable(false);
        inmDisponibles.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 0; //Columna
        c.gridy = 0; //Fila
        c.gridwidth = 7; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 1; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.HORIZONTAL;
        add(inmDisponibles, c);
        
        scrollDisponibles = new JScrollPane();
        areaDisponibles = new JTextArea();
        areaDisponibles.setEditable(false);
        scrollDisponibles.setViewportView(areaDisponibles);
        c.gridx = 0; //Columna
        c.gridy = 1; //Fila
        c.gridwidth = 7; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 10; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.BOTH;
        add(scrollDisponibles, c);

      
        inmVendidos = new JTextField("Inmuebles vendidos");
        inmVendidos.setEditable(false);
        inmVendidos.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 0; //Columna
        c.gridy = 11; //Fila
        c.gridwidth = 7; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 1; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.HORIZONTAL;
        add(inmVendidos, c);        
        
        scrollVendidos = new JScrollPane();
        areaVendidos = new JTextArea();
        areaVendidos.setEditable(false);
        scrollVendidos.setViewportView(areaVendidos);
        c.gridx = 0; //Columna
        c.gridy = 17; //Fila
        c.gridwidth = 7; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 5; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.BOTH;
        add(scrollVendidos, c);        
        
        btnAgregar = new JButton("Agregar");
        c.gridx = 1; //Columna
        c.gridy = 23; //Fila
        c.gridwidth = 1; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 1; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.CENTER;
        add(btnAgregar, c);
        btnAgregar.setActionCommand("Agregar");
        btnAgregar.setBackground(Color.blue);
        btnAgregar.setForeground(Color.white);
        btnAgregar.addActionListener(this);

        btnVender = new JButton("Vender");
        c.gridx = 3; //Columna
        c.gridy = 23; //Fila
        c.gridwidth = 1; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 1; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.CENTER;
        add(btnVender, c);
        btnVender.setBackground(Color.blue);
        btnVender.setForeground(Color.white);
        btnVender.setActionCommand("Vender");
        btnVender.addActionListener(this);

        btnRecuperarVendidos = new JButton("Recuperar Vendidos");
        c.gridx = 5; //Columna
        c.gridy = 23; //Fila
        c.gridwidth = 1; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 1; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.CENTER;
        add(btnRecuperarVendidos, c);
        btnRecuperarVendidos.setBackground(Color.blue);
        btnRecuperarVendidos.setForeground(Color.white);
        btnRecuperarVendidos.setActionCommand("Recuperar Vendidos");
        btnRecuperarVendidos.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
            
            case "Agregar":
            String idInmueble;
            String opcion = JOptionPane.showInputDialog("¿Qué tipo de inmueble desea ingresar?" + 
                    "\n1. Oficina" +
                    "\n2. Casa" +
                    "\n3. Apartamento");
            if(opcion.equals("1")){
                idInmueble = MenuInmoviliariaK.agregarOficina();
                areaDisponibles.append(idInmueble + "\n");
            }else{
                if(opcion.equals("2")){
                    idInmueble = MenuInmoviliariaK.agregarCasa();
                    areaDisponibles.append(idInmueble + "\n");
                }else{
                    if(opcion.equals("3")){
                        idInmueble = MenuInmoviliariaK.agregarApartamento();
                        areaDisponibles.append(idInmueble + "\n");
                    }else{
                        JOptionPane.showMessageDialog(this, "Recuerde que solo puede ingresar valores entre 1 y 3... inténtelo de nuevo.", "Error", ERROR_MESSAGE, null);
                    }
                }
            }
            break;
            
            case "Vender":
                try{
                    if(MenuInmoviliariaK.grupoInmuebles.isEmpty()){
                        throw new NoExistenInmueblesVentaException(this);
                    }
                    String inmVendido = MenuInmoviliariaK.venderInmueble();
                    areaVendidos.append(inmVendido + "\n");
                    areaDisponibles.setText(actualizarComprados());
                    areaVendidos.setText(actualizarVendidos());
                }catch(NoExistenInmueblesVentaException e){
                    e.message();
                }
            break;
            
            case "Recuperar Vendidos":
                try{
                    recuperarInmVendidos();
                }catch(NoRecuperarInmVendidosException e){
                    e.message();
                }catch(IDRepetidoParaRecuperarException e){
                    e.message();
                }
                areaDisponibles.setText(actualizarComprados());
                areaVendidos.setText(actualizarVendidos());
            break;
            
        }
    }
    
    public String actualizarComprados(){
        String str = "";
        for (Inmueble inmuebles : MenuInmoviliariaK.grupoInmuebles){
            str += inmuebles + "\n";
        }
        return str;
    }

    public String actualizarVendidos(){
        String str = "";
        for (Inmueble inmuebles : MenuInmoviliariaK.InmueblesVendidos){
            str += inmuebles + "\n";
        }
        return str;
    }
    
    public void recuperarInmVendidos() throws NoRecuperarInmVendidosException, IDRepetidoParaRecuperarException{

        if(MenuInmoviliariaK.InmueblesVendidos.isEmpty()){
            throw new NoRecuperarInmVendidosException(this);
        }
        
        for (Inmueble i : MenuInmoviliariaK.InmueblesVendidos){
            for (Inmueble j : MenuInmoviliariaK.grupoInmuebles){
                if (i.getId() == j.getId()){
                    throw new IDRepetidoParaRecuperarException(this);
                }
            }
        }
        
        for (Inmueble i : MenuInmoviliariaK.InmueblesVendidos){
            MenuInmoviliariaK.grupoInmuebles.add(i);
        }
        
        MenuInmoviliariaK.InmueblesVendidos.removeAll(MenuInmoviliariaK.InmueblesVendidos);
        
    }
    
}