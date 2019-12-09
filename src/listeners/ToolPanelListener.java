/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;


import form.MyForm;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Model;
import shapes.MyLine;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class ToolPanelListener implements ActionListener,MouseMotionListener,MouseListener{
    private MyForm myForm;
    private Model model;
    public ToolPanelListener(MyForm myForm,Model model) {
        this.myForm = myForm;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myForm.getToolPanel().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        hover(new Point(e.getX(),e.getY()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX()+" "+e.getY());        
        Point p = new Point(e.getX(),e.getY());
        clicked(p);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void hover(Point p){
        ArrayList<Shape> toolPanelShapeList = model.getToolPanelModel().getToolPanelShapeList();
        int n = toolPanelShapeList.size();
        
        boolean hovered = false;
        for(int i=0;i<n;i++){
            if(toolPanelShapeList.get(i).pointInside(p)){
                myForm.getToolPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
                toolPanelShapeList.get(i).setColor(myForm.getToolPanel().getHoverColor());
                hovered = true;
            }
            else{ 
                toolPanelShapeList.get(i).setColor(myForm.getToolPanel().getNormalColor());
            }
        }
        if((!hovered)&&model.getSelectedShape()==null){
            myForm.getToolPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    public void clicked(Point p){
        ArrayList<Shape> toolPanelShapeList = model.getToolPanelModel().getToolPanelShapeList();
        int n = toolPanelShapeList.size();
        for(int i=0;i<n;i++){
            if(toolPanelShapeList.get(i).pointInside(p)){
                model.setSelectedShape(toolPanelShapeList.get(i).copy());
                myForm.getDrawingPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
                myForm.getToolPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }
    }
    
    private int generateRandom(int a,int b){
        Random r = new Random();
        int result = r.nextInt(b-a) + a;
        return result;
    }

    private void insertLine(MyLine myNewLine) {
        List<Shape> drawingPanelShapeList = myForm.getDrawingPanel().getDrawingPanelShapeList();
        for(Shape shape: drawingPanelShapeList){
            if(!(shape instanceof MyLine)){
                if(shape.getMyLine()==null){
                    shape.setMyLine(myNewLine);
                }
            }
        }
    }
}
