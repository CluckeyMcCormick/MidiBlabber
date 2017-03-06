/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midiblabber.voices;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import midiblabber.TextAreaOutputStream;

/**
 *
 * @author frick
 */
public class Voice implements Runnable {   
    
    public final int STRAIGHT_NOTE_ID = 0;
    public final int DOUBLE_NOTE_ID = 1;
    
    private TextAreaOutputStream taos;
    private String message;
    private MidiChannel channel;
    private NoteMethod method;
    
    private int methodCode;
    
    private boolean whole;
    private boolean noteHold;
    private int veloc;
    private int prog;
    private long pause;
    private boolean cancel;
   
    
    public Voice (MidiChannel channel, TextAreaOutputStream taos ){
        this.taos = taos;
        this.channel = channel;
        
        this.setMethod(-1);
    }
    
    public void loadString(String message){
        this.message = message;
    }

    @SuppressWarnings("empty-statement")
    public void run(){
        try {
            this.changeProg();
            
            if(whole)
                this.taos.write(this.message);
            
            if(cancel)
                cancel = false;
            
            for( char c : this.message.toCharArray() ){
                if(cancel)
                    break;
                if(!whole)
                    this.taos.write(c);
                
                this.playChar(c);
            }
            
            this.cleanup();
            
            cancel = false;
        } catch (IOException ex) {
            Logger.getLogger(Voice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playChar(char c) {
        int note = this.method.calculateNote(c) % (NoteMethod.NOTE_RANGE) + NoteMethod.MIN_NOTE;
        
        try {
            this.channel.noteOn(note, this.veloc);
            
            Thread.sleep( this.pause );
            if( !this.noteHold )
                this.channel.noteOff(note);
        } catch (InterruptedException ex) {
            Logger.getLogger(DoubleNote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //~~~~~~ Utility Methods ~~~~~~~~~~~~~~~~~~
    public void cancelTalk(){
        this.cancel = true;
    }
    
    public void cleanup(){
        this.channel.allNotesOff();
    }
    
    public void changeProg() {
        this.channel.programChange( this.getProg() );
    }
    
    public void setMethod(int method) {
        if(this.methodCode == method)
            return;
        
        switch(method){
            case DOUBLE_NOTE_ID:
                this.method = new DoubleNote();
                break;
            default:
                this.method = new StraightNote();
                break;
        }
    }
    
    //~~~~~~ Gettin's and Settin's ~~~~~~~~~~~~~~~~~~
    public void calibrate(boolean whole, boolean noteHold, int veloc, int prog){
        this.whole = whole;
        this.noteHold = noteHold;
        this.veloc = veloc;
        this.prog = prog;
    }
    
    public boolean isWhole() {
        return whole;
    }

    public void setWhole(boolean whole) {
        this.whole = whole;
    }

    public boolean getNoteHold() {
        return noteHold;
    }

    public void setNoteHold(boolean noteHold) {
        this.noteHold = noteHold;
    }

    public int getVeloc() {
        return veloc;
    }

    public void setVeloc(int veloc) {
        this.veloc = veloc;
    }

    public int getProg() {
        return prog;
    }

    public void setProg(int prog) {
        this.prog = prog;
    }

    public long getPause() {
        return pause;
    }

    public void setPause(long pause) {
        this.pause = pause;
    }
}
