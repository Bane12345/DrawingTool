/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import form.MyForm;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;
import listeners.DrawingPanelListener;
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
        myForm.setVisible(true);
        myForm.setLocationRelativeTo(null);
        myForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        timer1 = new Timer(5,toolPanelListener);
        timer1.start();
    }
    
    private void createDrawingPanelListener(){
        DrawingPanelListener drawingPanelListener = new DrawingPanelListener(myForm.getDrawingPanel());
        myForm.getDrawingPanel().addDrawingPanelListener(drawingPanelListener);
        timer2 = new Timer(5,drawingPanelListener);
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
}
