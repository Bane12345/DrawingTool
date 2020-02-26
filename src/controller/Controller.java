/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import form.MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import listeners.DrawingPanelListener;
import listeners.HeaderPanelListener;
import listeners.MyMenuListener;
import listeners.ToolPanelListener;
import main.Main;
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
        showMyForm();
    }
    
    public void showMyForm(){
        prepareToolPanel();
        prepareDrawingPanel();
        prepareHeaderPanel();
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
        DrawingPanelListener drawingPanelListener = new DrawingPanelListener(model, myForm);
        myForm.getHeaderPanel().getjButton1().addActionListener(drawingPanelListener);
       
    }
    
    private void prepareDrawingPanel(){
        DrawingPanelModel drawingPanelModel = model.getDrawingPanelMode();
        ArrayList<Shape> drawingPanelShapeList = drawingPanelModel.getDrawingPanelShapeList();
        myForm.getDrawingPanel().setDrawingPanelShapeList(drawingPanelShapeList);
        createDrawingPanelListener();
    }

    private void prepareForm() {
        URL url = Main.class.getResource("/crtanje.png");
        ImageIcon img = new ImageIcon(url);
        myForm.setIconImage(img.getImage());
        myForm.setVisible(true);
        myForm.setLocationRelativeTo(null);
        myForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void prepareMenu() {
        MyMenuListener myMenuListener = new MyMenuListener(myForm);
    }
    
    
}
