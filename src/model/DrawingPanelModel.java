/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import shapes.MyRectangle;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class DrawingPanelModel {
    private ArrayList<Shape> drawingPanelShapeList;
    public DrawingPanelModel() {
        drawingPanelShapeList = new ArrayList<>();
    }

    public ArrayList<Shape> getDrawingPanelShapeList() {
        return drawingPanelShapeList;
    }

    public void setDrawingPanelShapeList(ArrayList<Shape> drawingPanelShapeList) {
        this.drawingPanelShapeList = drawingPanelShapeList;
    }

    public void printDrawingPanelShapeList(){
        for(Shape shape:drawingPanelShapeList){
            shape.printShape();
        }
    }
}
