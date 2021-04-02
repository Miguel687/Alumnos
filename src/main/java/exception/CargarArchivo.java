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
public class CargarArchivo extends Exception {

    /**
     * Creates a new instance of <code>CargarArchivo</code> without detail
     * message.
     */
    public CargarArchivo() {
    }

    /**
     * Constructs an instance of <code>CargarArchivo</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CargarArchivo(String msg) {
        super(msg);
    }
}
