/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author miguel
 */
public class BusquedaPanel extends JPanel{

    private JTextField edtBuscar;
    private JButton btnBuscar;
    private JPanel pnlBuscar;
    
   private BuscarInterface listener;

    public BusquedaPanel() {
         super.setBackground(Color.WHITE);
         super.setLayout(new FlowLayout());
         

        edtBuscar = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        pnlBuscar = new JPanel();

        pnlBuscar.add(edtBuscar);
        pnlBuscar.add(btnBuscar);
        pnlBuscar.setLayout(new GridLayout(1,2, 10, 0));
        
        btnBuscar.addActionListener(new ActionListener() { 
             @Override
             public void actionPerformed(ActionEvent ae) {
                listener.buscar(edtBuscar.getText());
             }
            
        });
        
        
        
        
        super.add(pnlBuscar, BorderLayout.EAST);
        
    }

    public void setListener(BuscarInterface listener) {
        this.listener = listener;
    }

    public String getEdtBuscar() {
        return edtBuscar.getText();
    }
    
    
    
    
}
