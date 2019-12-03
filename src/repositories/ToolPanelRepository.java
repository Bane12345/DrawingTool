/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.awt.Color;
import java.util.ArrayList;
import shapes.MyCircle;
import shapes.MyLine;
import shapes.MyRectangle;
import shapes.MyTriangle;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class ToolPanelRepository {
     private final ArrayList<Shape> shapeList;
    private final Color initialColor = new Color(33, 92, 46);
    public ToolPanelRepository(){
        Shape shape1 = new MyRectangle(40, 120, 120, 50, initialColor);
        Shape shape2 = new MyCircle(55, 200, 90, initialColor);
        Shape shape3 = new MyTriangle(100,320,40,410,160,410, initialColor);
        Shape shape4 = new MyLine(40,460,170,460,initialColor);
        shapeList = new ArrayList<>();
        shapeList.add(shape1);
        shapeList.add(shape2);
        shapeList.add(shape3);
        shapeList.add(shape4);
    }
    
    public ArrayList<Shape> getShapeList(){
        return this.shapeList;
    }
}
