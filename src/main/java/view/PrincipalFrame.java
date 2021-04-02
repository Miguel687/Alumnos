/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import exception.AlumnosExistentes;
import exception.ArchivoInvalido;
import exception.CalificacionErronea;
import exception.CargarArchivo;
import exception.GuardarArchivo;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Alumno;
import model.Carrera;

/**
 *
 * @author miguel
 */
public class PrincipalFrame extends JFrame{
    
    private BusquedaPanel pnlBusqueda;
    private JTable tblAlumnos;
    private AlumnosTableModel modelAlumnos;
    
    private Controller controller;
    private MenuPanel pnlMenu;
    
    private AlumnoDialog dlgAlumno;
    private EliminarDialog dlgEliminar;
      
    public PrincipalFrame(){
        
        super("Control Escolar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(700, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        
        
        try { 
            controller = new Controller();
        } catch (ArchivoInvalido e) {
            System.out.println(e.getMessage());
        } catch (CargarArchivo e){
            
        }
        
        modelAlumnos = new AlumnosTableModel(controller);
        tblAlumnos = new JTable(modelAlumnos);
        pnlBusqueda = new BusquedaPanel();
        
        
        dlgAlumno = new AlumnoDialog(this);
        dlgEliminar = new EliminarDialog(this);
        
        dlgAlumno.setListener(new AlumnoDialogListener(){
            @Override
            public void aceptarButtonClick(Alumno a) {
                try {
                    controller.add(a);
                    dlgAlumno.setVisible(false);
                    modelAlumnos.fireTableDataChanged();    
                } catch (AlumnosExistentes ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Alumno no ingresado",  JOptionPane.ERROR_MESSAGE);
                }
                   
            }

            @Override
            public void cancelarButtonClick() {
                dlgAlumno.setVisible(false);
            }
            
        });
        
        pnlMenu = new MenuPanel();
        
        pnlMenu.setListener(new MenuInterface() {
            @Override
            public void nuevo() {
                dlgAlumno.setVisible(true);
                System.out.println("Apretó nuevo");
            }

            @Override
            public void about() {
                JOptionPane.showMessageDialog(PrincipalFrame.this, "Versión 1.0", "Versión del sistema", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void guardar() {
                try {
                    controller.save();
                    
                } catch (GuardarArchivo ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void eliminar() {
                dlgEliminar.setVisible(true);
                modelAlumnos.fireTableDataChanged();    
            }
            
        });
        
        pnlBusqueda.setListener(new BuscarInterface() {
            @Override
            public void buscar(String a) {
                a = pnlBusqueda.getEdtBuscar();
                JOptionPane.showMessageDialog(PrincipalFrame.this, controller.search(a), "Usuario encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        dlgEliminar.setListener(new EliminarInterface() {
            @Override
            public void borrar(String a) {
                a = dlgEliminar.getNoControl();
                System.out.println("delete");
                try {
                    controller.delete(a);
                    dlgEliminar.setVisible(false);
                } catch (GuardarArchivo ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
                    } catch (CargarArchivo ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
                } catch (ArchivoInvalido ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        super.add(new JScrollPane(tblAlumnos) , BorderLayout.CENTER);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        
        super.setJMenuBar(pnlMenu.getMbBar());
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new PrincipalFrame();
    }
}
