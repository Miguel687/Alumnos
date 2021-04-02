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
public class CalificacionErronea extends Exception {

    /**
     * Creates a new instance of <code>CalificacionErronea</code> without detail
     * message.
     */
    public CalificacionErronea() {
    }

    /**
     * Constructs an instance of <code>CalificacionErronea</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CalificacionErronea(String msg) {
        super(msg);
    }
}
