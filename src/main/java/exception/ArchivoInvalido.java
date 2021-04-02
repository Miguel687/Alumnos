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
public class ArchivoInvalido extends Exception {

    /**
     * Creates a new instance of <code>ArchivoInvalido</code> without detail
     * message.
     */
    public ArchivoInvalido() {
    }

    /**
     * Constructs an instance of <code>ArchivoInvalido</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ArchivoInvalido(String msg) {
        super(msg);
    }
}
