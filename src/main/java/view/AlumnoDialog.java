/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exception.CalificacionErronea;
import exception.NumberFormat;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Alumno;
import model.Carrera;

/**
 *
 * @author miguel
 */
public class AlumnoDialog extends JDialog{
    
    private JLabel lbNoControl;
    private  JTextField edtNoControl;
    
    private JLabel lbNombre;
    private JTextField edtNombre;
    
    private JLabel lbPaterno;
    private JTextField edtPaterno;
    
    private JLabel lbMaterno;
    private JTextField edtMaterno;
    
    private JLabel lbCalificacion;
    private JTextField edtCalificacion;
    
    private JLabel lbCarrera;
    private JTextField edtCarrera;
    
    private JPanel pnlControl;
    private JPanel pnlNombre;
    private JPanel pnlPaterno;
    private JPanel pnlMaterno;
    private JPanel pnlCalificacion;
    private JPanel pnlBotones;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private AlumnoDialogListener listener;
    
    
    public AlumnoDialog(JFrame parent) {
        super(parent, true);
        super.setLayout(new FlowLayout());
        super.setLocationRelativeTo(parent);
        super.setSize(320, 200);
        
        pnlControl = new JPanel();
        pnlNombre = new JPanel();
        pnlPaterno = new JPanel();
        pnlMaterno = new JPanel();
        pnlCalificacion = new JPanel();
        pnlBotones = new JPanel();
        
        lbNoControl = new JLabel("No. de Control: ");
        edtNoControl = new JTextField(15);
        pnlControl.add(lbNoControl);
        pnlControl.add(edtNoControl);
        pnlControl.setLayout(new GridLayout(1,2));

        lbNombre = new JLabel("Nombre: ");
        edtNombre = new JTextField(15);
        pnlNombre.add(lbNombre);
        pnlNombre.add(edtNombre);
        pnlNombre.setLayout(new GridLayout(1,2));
        
        lbPaterno = new JLabel("Apellido paterno: ");
        edtPaterno = new JTextField(15);
        pnlPaterno.add(lbPaterno);
        pnlPaterno.add(edtPaterno);
        pnlPaterno.setLayout(new GridLayout(1,2));
        
        lbMaterno = new JLabel("Apellido materno: ");
        edtMaterno  = new JTextField(15);
        pnlMaterno.add(lbMaterno);
        pnlMaterno.add(edtMaterno);
        pnlMaterno.setLayout(new GridLayout(1,2));
        
        lbCalificacion = new JLabel("Calificación: ");
        edtCalificacion = new JTextField(15);
        pnlCalificacion.add(lbCalificacion);
        pnlCalificacion.add(edtCalificacion);
        pnlCalificacion.setLayout(new GridLayout(1,2));
        
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        pnlBotones.add(btnAceptar);
        pnlBotones.add(btnCancelar);
        pnlBotones.setLayout(new GridLayout(1,2, 10, 0));
        
        btnAceptar.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Alumno alumno = new Alumno(
                            edtNoControl.getText(),
                            edtNombre.getText(),
                            edtPaterno.getText(),
                            edtMaterno.getText(),
                            Double.parseDouble(edtCalificacion.getText()),
                            Carrera.SISTEMAS
                    );
                    listener.aceptarButtonClick(alumno);
                } catch (CalificacionErronea ex) {
                    JOptionPane.showMessageDialog(AlumnoDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(AlumnoDialog.this, "Por favor ingrese los datoso para poder continuar", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                edtNoControl.setText(null);
                edtNombre.setText(null);
                edtPaterno.setText(null);
                edtMaterno.setText(null);
                edtCalificacion.setText(null);
               
            }
            
        });
            
        btnCancelar.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarButtonClick();
            }
            
        });
        
        
        super.add(lbNoControl);
        super.add(edtNoControl);
        super.add(lbNombre);                        
        super.add(edtNombre);
        super.add(lbPaterno);
        super.add(edtPaterno);
        super.add(lbMaterno);
        super.add(edtMaterno);
        super.add(lbCalificacion);
        super.add(edtCalificacion);
        
        super.add(pnlBotones);
    }

    public void setListener(AlumnoDialogListener listener) {
        this.listener = listener;
    }
    
    
    
}
