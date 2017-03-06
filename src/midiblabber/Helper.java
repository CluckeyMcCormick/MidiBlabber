/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midiblabber;

import javax.sound.midi.Instrument;

/**
 *
 * @author frick
 */
public class Helper {
    public static void printInstruments( Instrument[] ins ){
        for(int i = 0; i < ins.length; i++)
            System.out.println(i + " - " + ins[i].getName() + " - " + ins[i].getPatch().getProgram());
    }
}
