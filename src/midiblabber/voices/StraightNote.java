/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midiblabber.voices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import midiblabber.TextAreaOutputStream;

/**
 *
 * @author frick
 */
public class StraightNote extends NoteMethod {
    
    public StraightNote() {}

    @Override
    public int calculateNote( char c) {

        int note = MIN_NOTE + ((int) c) % NOTE_RANGE;
                
        if(MIN_CHAR_LOW <= c && c <= MAX_CHAR_LOW )
            return note;
        else if(MIN_CHAR_HIG <= c  && c <= MAX_CHAR_HIG)
            return note;
        else
            return -1;
    }
}
