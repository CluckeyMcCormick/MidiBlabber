/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midiblabber.voices;

/**
 *
 * @author frick
 */
public abstract class NoteMethod {
    
    public static final int MAX_NOTE = 127;
    public static final int MIN_NOTE = 32;
    public static final int NOTE_RANGE = MAX_NOTE - MIN_NOTE;
    
    public static final long DEFAULT_WAIT = 100;
    
    public static final char MIN_CHAR_LOW = 'a';
    public static final char MAX_CHAR_LOW = 'z';
    
    public static final char MIN_CHAR_HIG = 'A';
    public static final char MAX_CHAR_HIG = 'Z';
    
    public abstract int calculateNote( char c);

}
