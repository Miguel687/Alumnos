/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Alumno;

/**
 *
 * @author miguel
 */
public interface AlumnoDialogListener {
    public void aceptarButtonClick(Alumno a);
    public void cancelarButtonClick();
}
