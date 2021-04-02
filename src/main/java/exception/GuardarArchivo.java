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
public class GuardarArchivo extends Exception {

    /**
     * Creates a new instance of <code>GuardarArchivo</code> without detail
     * message.
     */
    public GuardarArchivo() {
    }

    /**
     * Constructs an instance of <code>GuardarArchivo</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GuardarArchivo(String msg) {
        super(msg);
    }
}
