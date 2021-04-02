/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author miguel
 */
public class EliminarDialog extends JDialog{
    
    private JTextField edtNoControl;
    private JButton btnEliminar;
    
    private EliminarInterface listener;

    public EliminarDialog(JFrame parent) {
        super(parent, true);
        super.setLayout(new FlowLayout());
        super.setLocationRelativeTo(parent);
        super.setSize(200, 100);
        
        edtNoControl = new JTextField(14);
        btnEliminar = new JButton("Eliminar");
        
        
        
        btnEliminar.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.borrar(edtNoControl.getText());

            }
            
        });
        
        
        super.add(edtNoControl);
        super.add(btnEliminar);
    }

    public void setListener(EliminarInterface listener) {
        this.listener = listener;
    }
    
    public String getNoControl(){
        return edtNoControl.getText();
    }
    
    
    
}
