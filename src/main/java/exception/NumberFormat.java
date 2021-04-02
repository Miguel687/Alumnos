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
public class NumberFormat extends Exception {

    /**
     * Creates a new instance of <code>NumberFormat</code> without detail
     * message.
     */
    public NumberFormat() {
    }

    /**
     * Constructs an instance of <code>NumberFormat</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NumberFormat(String msg) {
        super(msg);
    }
}
