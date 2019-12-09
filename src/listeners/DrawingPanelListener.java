/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import form.MyForm;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import model.Model;
import shapes.MyLine;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class DrawingPanelListener implements ActionListener,MouseListener,MouseMotionListener{
    private ArrayList<Shape> drawingPanelShapeList;
    private int dx=0,dy=0;
    private Shape selectedShape=null;
    private boolean activeLine = false; //Flag that indicates if line is in pogress of drawing
    private Model model;
    private MyForm myForm;
    private MyLine myLine;
    public DrawingPanelListener(Model model,MyForm myForm) {
        this.drawingPanelShapeList = myForm.getDrawingPanel().getDrawingPanelShapeList();
        this.myForm = myForm;
        this.model=model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        myForm.getDrawingPanel().repaint();
    }

    //Akcija za ubacivanje izabranog oblika na drawingPanel
    @Override
    public void mouseClicked(MouseEvent e) {
        Shape newShape = model.getSelectedShape();
        if(activeLine){
            if(!insideShapeList(myLine.getFirstPoint())||!insideShapeList(myLine.getSecondPoint())){
                removeMyLine(myLine);
            }
            activeLine=false;
            model.setSelectedShape(null);
            myLine=null;
            myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }else if(newShape!=null){
            newShape.setColor(myForm.getToolPanel().getNormalColor());
            if(newShape instanceof MyLine){
                MyLine myLine = (MyLine)newShape;
                myLine.setLinePosition(e.getPoint(),e.getPoint());
                activeLine=true;
                selectedShape=myLine;
                this.myLine=myLine;
                drawingPanelShapeList.add(model.getSelectedShape());
                if(insideShapeList(e.getPoint())){
                    myLine.setColor(myForm.getToolPanel().getNormalColor());
                }else{
                    myLine.setColor(Color.red);
                }
            }else{
                newShape.setPosition(e.getX(),e.getY());
                drawingPanelShapeList.add(model.getSelectedShape());
                model.setSelectedShape(null);          
                myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedShape=null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        move(dx,dy,selectedShape,e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        distance(e.getPoint());
        if(activeLine && selectedShape instanceof MyLine){
            MyLine myLine = (MyLine)selectedShape;
            myLine.setLinePosition(myLine.getFirstPoint(),e.getPoint());
        }
        //System.out.println(activeLine);
        try {
            if (insideShapeList(myLine.getFirstPoint()) && insideShapeList(myLine.getSecondPoint())) {
                myLine.setColor(myForm.getToolPanel().getNormalColor());
            } else {
                myLine.setColor(Color.red);
                if (activeLine == false) {
                    drawingPanelShapeList.remove(drawingPanelShapeList.size() - 1);
                }
            }
        } catch (NullPointerException exc) {

        }
    }
    
    public void distance(Point p){
        int n = drawingPanelShapeList.size();
        boolean hovered = false;//Flag to show move cursor
        for (Shape shape : drawingPanelShapeList){
            if(shape.pointInside(p)&&activeLine==false){
                //Udaljenost tacke klika od x i y koordinate oblika
                Point pshape = shape.getPosition(); //position of shape
                int xs =(int) pshape.getX();
                int ys =(int) pshape.getY();
                int xp =(int) p.getX();
                int yp =(int) p.getY();
                dx = xp - xs;
                dy = yp - ys;
                selectedShape=shape;
                hovered=true;
            }
        }
        if (hovered&&model.getSelectedShape()==null){
            myForm.getDrawingPanel().setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }else{                 
            if(model.getSelectedShape()==null){
                myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    
    public void move(int dx,int dy,Shape shape,Point p){
        int xp = (int) p.getX();
        int yp = (int) p.getY();
        try{
            System.out.println("AAAAAAAAAAAAA");
            shape.moveShape(xp-dx,yp-dy);
        }catch(NullPointerException exc){
            
        }
    }
    
    //Method that checks if cursor point to an object of shapeList, except MyLine
    public boolean insideShapeList(Point p){
        int n=drawingPanelShapeList.size();
        for(int i=0;i<n;i++){
            if(drawingPanelShapeList.get(i).pointInside(p) && !(drawingPanelShapeList.get(i) instanceof MyLine)){
                return true;
            }
        }
        return false;
    }
    
    private boolean removeMyLine(MyLine myLine){
        drawingPanelShapeList.remove(myLine);
        return true;
    }
}
