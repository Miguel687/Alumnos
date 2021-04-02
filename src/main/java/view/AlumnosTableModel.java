/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javax.swing.table.AbstractTableModel;
import model.Alumno;


/**
 *
 * @author miguel
 */
public class AlumnosTableModel extends AbstractTableModel{
    
    private Controller  controller;

    public AlumnosTableModel(Controller controller) {
        this.controller = controller;
    }
    
    

    @Override
    public int getRowCount() {
        return controller.cantidadAlumnos();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alumno =    controller.getAlumno(rowIndex);
        switch(columnIndex){
            case 0:
                return alumno.getNoControl();
            case 1:
                return  alumno.getNombre();
            case 2:
                return alumno.getPaterno();
            case 3: 
                return alumno.getMaterno();
            case 4:
                return alumno.getCalificacion();
            case 5:
                return alumno.getCarrera();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "No. Control";
            case 1:
                return  "Nombre del alumno";
            case 2:
                return "Apellido paterno";
            case 3: 
                return "Apellido materno";
            case 4:
                return "Calficación";
            case 5:
                return "Carrera";
            default:
                throw new AssertionError();
        }
        
    }
    
    
    
}
