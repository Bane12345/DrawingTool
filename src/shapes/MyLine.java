/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Bane
 */
public class MyLine implements Shape{
    private int x1,y1,x2,y2;
    private Color color;

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.drawLine(x1,y1,x2,y2);
    }

    @Override
    public boolean pointInside(Point p) {
        if(x1<=p.getX()&&x2>=p.getX()&&y1<=p.getY()+3&&y2>=p.getY()-3)
            return true;
        return false;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setPosition(int x, int y) {
        int width = x2 - x1;
        int height = y2 - y1;
        x1 = x;
        y1 = y;
        x2 = x1 +width;
        y2 = y1 +height;
    }

    @Override
    public Shape copy() {
        Shape copiedLine = new MyLine(x1,y1,x2,y2,color);
        return copiedLine;
    }

    @Override
    public void printShape() {
        System.out.println("LINE");
    }
    
}
