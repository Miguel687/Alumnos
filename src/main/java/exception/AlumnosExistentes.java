/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author miguel
 */
public class AlumnosExistentes extends Exception {

    /**
     * Creates a new instance of <code>AlumnosExistentes</code> without detail
     * message.
     */
    public AlumnosExistentes() {
    }

    /**
     * Constructs an instance of <code>AlumnosExistentes</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnosExistentes(String msg) {
        super(msg);
    }
}
