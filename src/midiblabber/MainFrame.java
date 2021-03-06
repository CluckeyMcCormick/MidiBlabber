/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midiblabber;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.DefaultListModel;
import midiblabber.voices.DoubleNote;
import midiblabber.voices.StraightNote;
import midiblabber.voices.Voice;

/**
 *
 * @author frick
 */
public class MainFrame extends javax.swing.JFrame {
    
    private final int CHANNEL_INDEX = 4;
     
    private Thread currentThread;   
    
    private Voice voce;
    private Synthesizer synth;
    private MidiChannel chan[];
    private TextAreaOutputStream taos;
    private int[] dlmInt;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() throws MidiUnavailableException {
        final int channelNum = 4;
        
        DefaultListModel<String> lm;
        Instrument[] instrm;
        
        initComponents();
        
        taos = new TextAreaOutputStream(this.OutputText);
        
        this.PauseTextField.setText(this.PauseSlider.getValue() + "");
        this.VolumeTextField.setText(this.VolumeSlider.getValue() + "");

        synth = MidiSystem.getSynthesizer();
        synth.open();
        
        lm = new DefaultListModel<>();
        instrm = synth.getAvailableInstruments();
        dlmInt = new int[ instrm.length ];
        
        for( int i = 0; i < instrm.length; i++){
            dlmInt[i] = instrm[i].getPatch().getProgram();
            lm.addElement( this.dlmInt[i] + " - " + instrm[i].getName() );
        }
        
        this.InstrumentList.setModel(lm);
        
        chan = synth.getChannels(); 
        // Check for null; maybe not all 16 channels exist.
        if (chan[channelNum] == null) {
            return;
        }
        
        voce = new Voice(chan[channelNum], this.taos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        VolumePane = new javax.swing.JPanel();
        VolumeTextField = new javax.swing.JTextField();
        VolumeSlider = new javax.swing.JSlider();
        MethodPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MethodList = new javax.swing.JList<>();
        PausePane = new javax.swing.JPanel();
        PauseTextField = new javax.swing.JTextField();
        PauseSlider = new javax.swing.JSlider();
        InstrumentPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InstrumentList = new javax.swing.JList<>();
        InputPane = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        InputEditor = new javax.swing.JEditorPane();
        MiscPane = new javax.swing.JPanel();
        MiscHoldCheck = new javax.swing.JCheckBox();
        MiscPrintCheck = new javax.swing.JCheckBox();
        OutputPane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OutputText = new javax.swing.JTextArea();
        talkButton = new javax.swing.JButton();
        quietButton = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VolumePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Volume\n"));

        VolumeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolumeTextFieldActionPerformed(evt);
            }
        });

        VolumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout VolumePaneLayout = new javax.swing.GroupLayout(VolumePane);
        VolumePane.setLayout(VolumePaneLayout);
        VolumePaneLayout.setHorizontalGroup(
            VolumePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VolumePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolumeTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        VolumePaneLayout.setVerticalGroup(
            VolumePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VolumePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VolumePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VolumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MethodPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));

        MethodList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Straight", "Double" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        MethodList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(MethodList);

        javax.swing.GroupLayout MethodPaneLayout = new javax.swing.GroupLayout(MethodPane);
        MethodPane.setLayout(MethodPaneLayout);
        MethodPaneLayout.setHorizontalGroup(
            MethodPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MethodPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        MethodPaneLayout.setVerticalGroup(
            MethodPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MethodPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        PausePane.setBorder(javax.swing.BorderFactory.createTitledBorder("Pause Time"));

        PauseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseTextFieldActionPerformed(evt);
            }
        });

        PauseSlider.setMaximum(1500);
        PauseSlider.setMinimum(100);
        PauseSlider.setValue(250);
        PauseSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PauseSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PausePaneLayout = new javax.swing.GroupLayout(PausePane);
        PausePane.setLayout(PausePaneLayout);
        PausePaneLayout.setHorizontalGroup(
            PausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PausePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PauseTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PauseSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PausePaneLayout.setVerticalGroup(
            PausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PausePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PauseSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PauseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InstrumentPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Instrument"));

        InstrumentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(InstrumentList);

        javax.swing.GroupLayout InstrumentPaneLayout = new javax.swing.GroupLayout(InstrumentPane);
        InstrumentPane.setLayout(InstrumentPaneLayout);
        InstrumentPaneLayout.setHorizontalGroup(
            InstrumentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstrumentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );
        InstrumentPaneLayout.setVerticalGroup(
            InstrumentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstrumentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        InputPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Text"));

        InputEditor.setBorder(null);
        jScrollPane3.setViewportView(InputEditor);

        javax.swing.GroupLayout InputPaneLayout = new javax.swing.GroupLayout(InputPane);
        InputPane.setLayout(InputPaneLayout);
        InputPaneLayout.setHorizontalGroup(
            InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        InputPaneLayout.setVerticalGroup(
            InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        MiscPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Miscellaneous"));

        MiscHoldCheck.setText("Hold Notes");

        MiscPrintCheck.setText("Print Whole Message");

        javax.swing.GroupLayout MiscPaneLayout = new javax.swing.GroupLayout(MiscPane);
        MiscPane.setLayout(MiscPaneLayout);
        MiscPaneLayout.setHorizontalGroup(
            MiscPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiscPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MiscPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MiscHoldCheck)
                    .addComponent(MiscPrintCheck))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        MiscPaneLayout.setVerticalGroup(
            MiscPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiscPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MiscHoldCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MiscPrintCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59))
        );

        OutputPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        OutputText.setEditable(false);
        OutputText.setColumns(20);
        OutputText.setLineWrap(true);
        OutputText.setRows(5);
        jScrollPane4.setViewportView(OutputText);

        javax.swing.GroupLayout OutputPaneLayout = new javax.swing.GroupLayout(OutputPane);
        OutputPane.setLayout(OutputPaneLayout);
        OutputPaneLayout.setHorizontalGroup(
            OutputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        OutputPaneLayout.setVerticalGroup(
            OutputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        talkButton.setBackground(new java.awt.Color(0, 153, 0));
        talkButton.setText("Speak!");
        talkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talkButtonActionPerformed(evt);
            }
        });

        quietButton.setBackground(new java.awt.Color(153, 0, 0));
        quietButton.setText("Shut Up!");
        quietButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quietButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OutputPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(talkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quietButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MethodPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MiscPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InstrumentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PausePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VolumePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InputPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VolumePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PausePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(InstrumentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MethodPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MiscPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OutputPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(talkButton)
                    .addComponent(quietButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PauseSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PauseSliderStateChanged
        this.PauseTextField.setText(this.PauseSlider.getValue() + "");
    }//GEN-LAST:event_PauseSliderStateChanged

    private void VolumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumeSliderStateChanged
        this.VolumeTextField.setText(this.VolumeSlider.getValue() + "");
    }//GEN-LAST:event_VolumeSliderStateChanged

    private void VolumeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolumeTextFieldActionPerformed
        this.VolumeSlider.setValue( Integer.valueOf( this.VolumeTextField.getText() ) );
    }//GEN-LAST:event_VolumeTextFieldActionPerformed

    private void PauseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseTextFieldActionPerformed
        this.PauseSlider.setValue( Integer.valueOf( this.PauseTextField.getText() ) );
    }//GEN-LAST:event_PauseTextFieldActionPerformed

    private void talkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talkButtonActionPerformed
        StringBuilder errata;
        boolean errorDetected;
        
        try {
            this.voce.cancelTalk();
            if(this.currentThread != null)
                this.currentThread.join();
            
            errata = new StringBuilder("The following errors occured:\n");
            errorDetected = false;
            
            //Select Method
            switch( this.MethodList.getSelectedIndex() ){
                case 0:
                    this.voce.setMethod(0);
                    break;
                case 1:
                    this.voce.setMethod(1);
                    break;
                default:
                    errata.append("No method selected!\n");
                    errorDetected = true;
                    break;
            }
            
            //Select Instrument
            if(this.InstrumentList.getSelectedIndex() == -1) {
                errata.append("No instrument selected!\n");
                errorDetected = true;
            }
            else {
                this.voce.setProg( this.dlmInt[ this.InstrumentList.getSelectedIndex() ] );
            }
            
            //Retrieve Message Text
            if( this.InputEditor.getText().equals("") ){
                errata.append("No input text!\n");
                errorDetected = true;
            }
            else 
                this.voce.loadString( this.InputEditor.getText() );
            
            //Retrieve Volume
            this.voce.setVeloc( this.VolumeSlider.getValue() );
            
            //Retrieve Pause
            this.voce.setPause( (long) this.PauseSlider.getValue() );
            
            //Retrieve Hold
            this.voce.setNoteHold( this.MiscHoldCheck.isSelected() );
            
            //Retrieve Print
            this.voce.setWhole( this.MiscPrintCheck.isSelected() );
            
            if(!errorDetected){
                this.OutputText.setText("");
                this.currentThread = new Thread( this.voce );
                this.currentThread.start();
            }
            else {
                this.OutputText.setText( errata.toString() );
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_talkButtonActionPerformed

    private void quietButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quietButtonActionPerformed
        this.voce.cancelTalk();
    }//GEN-LAST:event_quietButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (MidiUnavailableException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane InputEditor;
    private javax.swing.JPanel InputPane;
    private javax.swing.JList<String> InstrumentList;
    private javax.swing.JPanel InstrumentPane;
    private javax.swing.JList<String> MethodList;
    private javax.swing.JPanel MethodPane;
    private javax.swing.JCheckBox MiscHoldCheck;
    private javax.swing.JPanel MiscPane;
    private javax.swing.JCheckBox MiscPrintCheck;
    private javax.swing.JPanel OutputPane;
    private javax.swing.JTextArea OutputText;
    private javax.swing.JPanel PausePane;
    private javax.swing.JSlider PauseSlider;
    private javax.swing.JTextField PauseTextField;
    private javax.swing.JPanel VolumePane;
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JTextField VolumeTextField;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton quietButton;
    private javax.swing.JButton talkButton;
    // End of variables declaration//GEN-END:variables
}
