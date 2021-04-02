/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exception.AlumnosExistentes;
import exception.ArchivoInvalido;
import exception.CargarArchivo;
import exception.GuardarArchivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.nio.file.Files.delete;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Alumno;

/**
 *
 * @author miguel
 */
public class Controller implements Serializable{
    
    private ArrayList<Alumno> alumnos;
    
    public Controller () throws CargarArchivo, ArchivoInvalido{
        load();
    }
    
    public Alumno getAlumno(int x){
        return alumnos.get(x);
    }
    
    public boolean add(Alumno alumno) throws AlumnosExistentes{
        
        if(alumnos.contains(alumno)){
            throw new AlumnosExistentes("El número de control ya ha sido ingresado");
        }
        return  alumnos.add(alumno);
    }
    
    public ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }
    
    public int cantidadAlumnos(){
        return alumnos.size();
    }
    
    public String search(String noContrl){
        for(Alumno a : alumnos){
            if(a.getNoControl().equals(noContrl)){
                return String.format("Número de control: %s \n" + 
                        "Nombre: %s \n" +
                        "Apellido paterno: %s \n"+
                        "Apellido materno %s \n" +
                        "Calificación: %.1f",
                        a.getNoControl(),a.getNombre(),  a.getPaterno(), a.getMaterno(), a.getCalificacion());
                //System.out.println(a.getNoControl() + a.getNombre() + a.getPaterno() + a.getMaterno() );
            }else{ 
                return "NO ENCONTRADO";
            }
        }
        return null;
    }
    
    public void delete(String noControl) throws GuardarArchivo, CargarArchivo, ArchivoInvalido{
        try {
            if(!alumnos.isEmpty()){
                for(Alumno a: alumnos){
                    if(a.getNoControl().equals(noControl)){
                        alumnos.remove(a);
                    }
                }
            }
        } catch (Exception e) {
        }
        
    }
    
    public void save() throws GuardarArchivo {
        try {
            File file = new File("guardar.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);
            
            writer.writeObject(alumnos);
            
            writer.close();
            output.close();
            
            System.out.println("Se ha guardado");
        } catch (Exception e) {
            throw new GuardarArchivo("Error al guardar");
        }
    }
    
    public void load() throws CargarArchivo, ArchivoInvalido{
         File file = new File("guardar.dat");
         if (file.exists()) {
             try {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                alumnos =  (ArrayList<Alumno>)reader.readObject();

                reader.close();
                input.close();
                
            } catch (IOException e) {
                throw new CargarArchivo("Error al cargar el archivo");
            }catch (ClassNotFoundException e){
                throw new ArchivoInvalido("No se encuentra el archivo");
            }
        }else{
             alumnos = new ArrayList<>( );
         }
       

    }
    

}
