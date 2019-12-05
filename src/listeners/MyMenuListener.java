/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import form.MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class MyMenuListener implements ActionListener{
    private JMenu menu1;
    private final JMenuItem clear;
    private final JMenuItem undo;
    private final JMenuItem settings;
    private final MyForm myForm;
    public MyMenuListener(MyForm myForm){
        JMenu menu1 = myForm.getJMenuBar().getMenu(0);
        clear = menu1.getItem(0);
        undo = menu1.getItem(1);
        settings = menu1.getItem(2);
        this.myForm = myForm;
        clear.addActionListener(this);
        undo.addActionListener(this);
        settings.addActionListener(this);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            myForm.getDrawingPanel().getDrawingPanelShapeList().clear();
        }else if(e.getSource()==undo){
            ArrayList<Shape> drawingPanelShapeList = myForm.getDrawingPanel().getDrawingPanelShapeList();
            drawingPanelShapeList.remove(drawingPanelShapeList.size()-1);
        }else if(e.getSource()==settings){
            System.out.println("SETTINGS!");
        }
    }
}
