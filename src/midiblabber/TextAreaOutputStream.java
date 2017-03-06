/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midiblabber;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
* An output stream that writes its output to a javax.swing.JTextArea
* control.
*
* @author  Ranganath Kini
* @see      javax.swing.JTextArea
*/
public class TextAreaOutputStream extends OutputStream {
    private JTextArea textControl;

    public TextAreaOutputStream( JTextArea control ) {
        textControl = control;
    }

    @Override
    public void write( int b ) throws IOException {
        // append the data as characters to the JTextArea control
        textControl.append( String.valueOf( ( char )b ) );
    }  
    
    public void write( char c ) throws IOException {
        // append the data as characters to the JTextArea control
        textControl.append( String.valueOf(c) );
    }
    
    public void write( String s ) throws IOException {
        // append the data as characters to the JTextArea control
        textControl.append( s );
    }
}