/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 *
 * @author miguel
 */
public class MenuPanel extends JPanel{
    
    private JMenuBar mnBar;
    
    private JMenu mnAlumnos;
    private JMenu mnAyuda;

    private JMenuItem itNuevo;
    private JMenuItem itAbout;
    private JMenuItem itGuardar;
    private JMenuItem itEliminar;
    
    private MenuInterface listener;
    
    private Controller controller;
    
    public MenuPanel() {
        mnBar = new JMenuBar();
        
        mnAlumnos = new JMenu("Alumnos");
        mnAyuda = new JMenu("Ayuda");    
        itNuevo = new JMenuItem("Nuevo");
        itAbout =  new JMenuItem("Acerca de...");
        itGuardar = new JMenuItem("Guardar");
        itEliminar = new JMenuItem("Eliminar"); 
                
        itNuevo.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.nuevo();
            }
        });
        
        
        itAbout.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.about();
            }
            
        });
        
        itGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.guardar();
            }
        
        });
        
        itEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.eliminar();
            }
            
        });
        
        itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        itGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        
        mnAlumnos.add(itNuevo);
        mnAlumnos.add(new JSeparator());
        mnAlumnos.add(itGuardar);
        mnAlumnos.add(itEliminar);

        
        mnAyuda.add(itAbout);
          
        mnBar.add(mnAlumnos);
        mnBar.add(mnAyuda);
        
        super.add(mnBar);
    }
    
    public JMenuBar getMbBar() {
        return mnBar;
    }
    
    public void setListener(MenuInterface listener) {
        this.listener = listener;
    }
    
}
