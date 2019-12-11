/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import form.MyForm;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;

/**
 *
 * @author Bane
 */
public class HeaderPanelListener implements ActionListener{
    private MyForm myForm;
    private Model model;
    
    public HeaderPanelListener(MyForm myForm,Model model){
        this.model=model;
        this.myForm=myForm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        model.setGumica(true);
        myForm.getDrawingPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
