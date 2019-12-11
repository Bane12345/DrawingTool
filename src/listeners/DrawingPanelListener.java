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
        
        try{
        if(e.getActionCommand().equals("delete")){
            model.setGumica(true);
            myForm.getHeaderPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
            myForm.getDrawingPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
            myForm.getHeaderPanel().getLbl2().setText("Click on the shape to delete it");
        }
        }catch(NullPointerException exception){
            
        }
    }

    //Akcija za ubacivanje izabranog oblika na drawingPanel
    @Override
    public void mouseClicked(MouseEvent e) {
        Shape newShape = model.getSelectedShape();
        myForm.getHeaderPanel().getLbl2().setText("");
        if(model.isGumica()){
            int i = insideShapeList(e.getPoint());
            if(i>=0){
                Shape deleted = drawingPanelShapeList.get(i);
                int n = drawingPanelShapeList.size();
                for(int j=0;j<n;j++){
                    if(drawingPanelShapeList.get(j) instanceof MyLine){
                        MyLine deletedLine = (MyLine)drawingPanelShapeList.get(j);
                        if(deletedLine.getFirstPointShape()==deleted || deletedLine.getSecondPointShape()==deleted){
                            drawingPanelShapeList.remove(j);
                            j--;
                            n=drawingPanelShapeList.size();
                        }
                    }
                }
                drawingPanelShapeList.remove(deleted);
                myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                model.setGumica(false);
            }else{
                myForm.getHeaderPanel().getLbl2().setText("Click on the shape to delete it");               
            }
        }
        if(activeLine){
            if(!(insideShapeList(myLine.getFirstPoint())>=0)||!(insideShapeList(myLine.getSecondPoint())>=0)){
                removeMyLine(myLine);
            }else{
                int i =insideShapeList(e.getPoint());
                if(i>=0)
                    myLine.setSecondPointShape(drawingPanelShapeList.get(i));
            }
            activeLine=false;
            model.setSelectedShape(null);
            myLine=null;
            if(model.isGumica()==false){
                myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }else if(newShape!=null){
            newShape.setColor(myForm.getToolPanel().getNormalColor());
            if(newShape instanceof MyLine){
                MyLine myLine = (MyLine)newShape;
                myLine.setLinePosition(e.getPoint(),e.getPoint());
                activeLine=true;
                selectedShape=myLine;
                this.myLine=myLine;
                drawingPanelShapeList.add(model.getSelectedShape());
                if(insideShapeList(e.getPoint())>=0){
                    myLine.setColor(myForm.getToolPanel().getNormalColor());
                    myForm.getHeaderPanel().getLbl2().setText("");
                    myLine.setFirstPointShape(drawingPanelShapeList.get(insideShapeList(e.getPoint())));
                }else{
                    myLine.setColor(Color.red);
                }
                model.setGumica(false);
            }else{
                newShape.setPosition(e.getX(),e.getY());
                drawingPanelShapeList.add(model.getSelectedShape());
                model.setSelectedShape(null);
                if(model.isGumica()==false){
                    myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
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
        if(model.isGumica())
            myForm.getHeaderPanel().getLbl2().setText("Click on the shape to delete it");
        distance(e.getPoint());
        if(activeLine && selectedShape instanceof MyLine){
            MyLine myLine = (MyLine)selectedShape;
            myLine.setLinePosition(myLine.getFirstPoint(),e.getPoint());
        }
        //System.out.println(activeLine);
        try {
            if (insideShapeList(myLine.getFirstPoint())>=0 && insideShapeList(myLine.getSecondPoint())>=0) {
                myLine.setColor(myForm.getToolPanel().getNormalColor());
                myForm.getHeaderPanel().getLbl2().setText("");
            } else {
                myLine.setColor(Color.red);
                myForm.getHeaderPanel().getLbl2().setText("Line have to connect two shapes!");
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
            if(model.isGumica()==false){
                myForm.getHeaderPanel().getLbl2().setText("Drag mouse to move the "+selectedShape.printShape());
            }
            if(model.isGumica()==false){
                myForm.getDrawingPanel().setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }
        }else{                 
            if(model.getSelectedShape()==null){
                if(model.isGumica()==false){
                    myForm.getDrawingPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                if(model.isGumica()==false)
                myForm.getHeaderPanel().getLbl2().setText("");
            }
        }
    }
    
    public void move(int dx,int dy,Shape shape,Point p){
        int xp = (int) p.getX();
        int yp = (int) p.getY();
        try{
            shape.moveShape(xp-dx,yp-dy);
            for(Shape shape1: drawingPanelShapeList){
                if(shape1 instanceof MyLine){
                    MyLine myLine = (MyLine)shape1;
                    if(myLine.getFirstPointShape()==shape){
                        myLine.setLinePosition(p,myLine.getSecondPoint());
                    }
                    if(myLine.getSecondPointShape()==shape){
                        myLine.setLinePosition(myLine.getFirstPoint(),p);
                    }
                }
            }
        }catch(NullPointerException exc){
            
        }
    }
    
    //Method that checks if cursor point to an object of shapeList, except MyLine
    public int insideShapeList(Point p){
        int n=drawingPanelShapeList.size();
        for(int i=0;i<n;i++){
            if(drawingPanelShapeList.get(i).pointInside(p) && !(drawingPanelShapeList.get(i) instanceof MyLine)){
                return i;
            }
        }
        return -1;
    }
    
    private boolean removeMyLine(MyLine myLine){
        drawingPanelShapeList.remove(myLine);
        return true;
    }
}
