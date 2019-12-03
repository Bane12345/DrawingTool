/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import form.DrawingPanel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class DrawingPanelListener implements ActionListener,MouseListener,MouseMotionListener{
    private DrawingPanel drawingPanel;
    private ArrayList<Shape> drawingPanelShapeList;
    private int dx=0,dy=0;
    private Shape selectedShape=null;
    public DrawingPanelListener(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.drawingPanelShapeList = this.drawingPanel.getDrawingPanelShapeList();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        drawingPanel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        distance(e.getPoint());
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

    @Override
    public void mouseDragged(MouseEvent e) {
        move(dx,dy,selectedShape,e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    public void distance(Point p){
        int n = drawingPanelShapeList.size();
        for (Shape shape : drawingPanelShapeList){
            if(shape.pointInside(p)){
                //Udaljenost tacke klika od x i y koordinate oblika
                Point pshape = shape.getPosition(); //position of shape
                int xs =(int) pshape.getX();
                int ys =(int) pshape.getY();
                int xp =(int) p.getX();
                int yp =(int) p.getY();
                dx = xp - xs;
                dy = yp - ys;
                selectedShape=shape;
            }
        }
    }
    
    public void move(int dx,int dy,Shape shape,Point p){
        int xp = (int) p.getX();
        int yp = (int) p.getY();
        shape.setPosition(xp-dx,yp-dy);
    }
}
