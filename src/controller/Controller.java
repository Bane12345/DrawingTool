/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import form.MyForm;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.Timer;
import listeners.DrawingPanelListener;
import listeners.MyMenuListener;
import listeners.ToolPanelListener;
import model.DrawingPanelModel;
import model.Model;
import model.ToolPanelModel;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class Controller {
    private final MyForm myForm;
    private final Model model;
    private Timer timer1;
    private Timer timer2;
    public Controller(MyForm myForm, Model model) {
        this.model = model;
        this.myForm=myForm;
    }
    
    public void showMyForm(){
        prepareToolPanel();
        prepareHeaderPanel();
        prepareDrawingPanel();
        prepareMenu();
        prepareForm();
    }
    
    private void prepareToolPanel(){
        ToolPanelModel toolPanelModel = model.getToolPanelModel();
        ArrayList<Shape> toolPanelShapeList = model.getToolPanelModel().getToolPanelShapeList();
        myForm.getToolPanel().setToolPanelShapeList(toolPanelShapeList);
        createToolPanelListener();
    }
    
    private void createToolPanelListener(){
        ToolPanelListener toolPanelListener = new ToolPanelListener(myForm,model);
        myForm.getToolPanel().addToolPanelListener(toolPanelListener);
        timer1 = new Timer(3,toolPanelListener);
        timer1.start();
    }
    
    private void createDrawingPanelListener(){
        DrawingPanelListener drawingPanelListener = new DrawingPanelListener(model,myForm);
        myForm.getDrawingPanel().addDrawingPanelListener(drawingPanelListener);
        timer2 = new Timer(3,drawingPanelListener);
        timer2.start();
    }
    private void prepareHeaderPanel(){
        
    }
    
    private void prepareDrawingPanel(){
        DrawingPanelModel drawingPanelModel = model.getDrawingPanelMode();
        ArrayList<Shape> drawingPanelShapeList = drawingPanelModel.getDrawingPanelShapeList();
        myForm.getDrawingPanel().setDrawingPanelShapeList(drawingPanelShapeList);
        createDrawingPanelListener();
    }

    private void prepareForm() {
        ImageIcon img = new ImageIcon("resources\\crtanje.png");
        myForm.setIconImage(img.getImage());
        myForm.setVisible(true);
        myForm.setLocationRelativeTo(null);
        myForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void prepareMenu() {
        MyMenuListener myMenuListener = new MyMenuListener(myForm);
    }
    
    
}
