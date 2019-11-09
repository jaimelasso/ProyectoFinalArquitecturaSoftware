package UI_InmobiliariaK;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import inmoviliariak.MenuInmoviliariaK;
import java.util.ArrayList;

/* @author Jaime Lasso */

public class PanelCentral extends JPanel implements ActionListener{

    JLabel txt1;
    JTextField tField1;
    JLabel txt2;
    JTextField tField2;
    JLabel txt3;
    JTextField tField3;
    JLabel txt4;
    JTextField tField4;
    JLabel txt5;
    JTextField tField5;
    JLabel txt6;
    JTextField tField6;
    JLabel txt7;
    JTextField tField7;
    JButton btnAnterior;
    JButton btnSiguiente;
    
    public static String[] strOficina = {"ID: ", "Tipo: ", "Metros: ", "Estrato", "Valor base: ", "Parqueadero", "-"};
    public static String[] strCasa = {"ID: ", "Tipo: ", "Metros: ", "Estrato", "Valor base: ", "# Parqueaderos", "Vigilancia: "};
    public static String[] strApartamento = {"ID: ", "Tipo: ", "Metros: ", "Estrato", "Valor base: ", "# Parqueaderos: ", "Piso: "};
    
    int posicion = -1;
    
    public PanelCentral(){
        
        int sizeJTextField = 10;
        String nombreJLabel = "-";
        int posicionArray = -1;
        
       setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //Imágenes de panel central
        ImagesTipoInmueble img = new ImagesTipoInmueble();
        img.setURL("/images/Office.png");
        TitledBorder tb = BorderFactory.createTitledBorder("");
        img.setBorder(tb);
        img.setSize(200, 200);
        img.setBounds(0, 0, 123, 129);
        c.gridx = 0; //Columna
        c.gridy = 1; //Fila
        c.gridwidth = 1; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 3; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.BOTH;
        add(img, c);        

        txt1 = new JLabel(nombreJLabel);
        c.gridx = 2; //Columna
        c.gridy = 0; //Fila
        c.gridwidth = 1; //Tamaño que ocupa el componente a lo ancho
        c.gridheight = 1; //Tamaño que ocupa el componente a lo largo
        c.weightx = 1.0; //Distribución del 100% en x
        c.weighty = 1.0; //Distribución del 100% en y
        c.fill = GridBagConstraints.CENTER;
        add(txt1, c);
        
        tField1 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField1, c);

        txt2 = new JLabel(nombreJLabel);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(txt2, c);
        
        tField2 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField2, c);

        txt3 = new JLabel(nombreJLabel);
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(txt3, c);
        
        tField3 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField3, c);
        
        txt4 = new JLabel(nombreJLabel);
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(txt4, c);
        
        tField4 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField4, c);
        
        txt5 = new JLabel(nombreJLabel);
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(txt5, c);
        
        tField5 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField5, c);

        txt6 = new JLabel(nombreJLabel);
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(txt6, c);
        
        tField6 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField6, c);

        txt7 = new JLabel(nombreJLabel);
        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(txt7, c);
        
        tField7 = new JTextField(sizeJTextField);
        c.gridx = 3;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(tField7, c);
        
        btnAnterior = new JButton("Anterior");
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(btnAnterior, c);

        btnSiguiente = new JButton("Siguiente");
        c.gridx = 3;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.CENTER;
        add(btnSiguiente, c);
        btnSiguiente.addActionListener(this);
        
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnSiguiente){
            if(MenuInmoviliariaK.isEmpty()){
                MenuInmoviliariaK.mostrarString("Aún no se ha agregado ningún inmueble al sistema...");
            }else{
                if(posicion + 1 > MenuInmoviliariaK.grupoInmuebles.size()){
                    posicion = 0;
                }else{
                    posicion++;
                    if(MenuInmoviliariaK.grupoInmuebles.get(posicion).getTipo() == 1){
                        txt1.setText(strOficina[0]);
                        txt2.setText(strOficina[1]);
                        txt3.setText(strOficina[2]);
                        txt4.setText(strOficina[3]);
                        txt5.setText(strOficina[4]);
                        txt6.setText(strOficina[5]);
                        txt7.setText(strOficina[6]);
                    }else{
                        if(MenuInmoviliariaK.grupoInmuebles.get(posicion).getTipo() == 2){
                            txt1.setText(strCasa[0]);
                            txt2.setText(strCasa[1]);
                            txt3.setText(strCasa[2]);
                            txt4.setText(strCasa[3]);
                            txt5.setText(strCasa[4]);
                            txt6.setText(strCasa[5]);
                            txt7.setText(strCasa[6]);
                        }else{
                            txt1.setText(strApartamento[0]);
                            txt2.setText(strApartamento[1]);
                            txt3.setText(strApartamento[2]);
                            txt4.setText(strApartamento[3]);
                            txt5.setText(strApartamento[4]);
                            txt6.setText(strApartamento[5]);
                            txt7.setText(strApartamento[6]);                        
                        }
                    }
                }
            }
        }
    }
    
}
