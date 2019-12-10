/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Bane
 */
public interface Shape {
    public void draw(Graphics g);
    public void setColor(Color color);
    public boolean pointInside(Point p);
    public void setRandomPosition(Random r);
    public void setPosition(int x,int y);
    public Shape copy();
    public Point getPosition();
    public String printShape();
    public MyLine getMyLine();
    public void setMyLine(MyLine myLine);
    public void moveShape(int x,int y);
}
