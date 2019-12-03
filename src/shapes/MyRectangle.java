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
import java.awt.Rectangle;

/**
 *
 * @author Bane
 */
public class MyRectangle implements Shape{
    private int x,y;
    private int width,height;
    private Color color;
    public MyRectangle(int x, int y, int width, int height,Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color=color;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.fill(new Rectangle(x,y,width,height));   
    }

    @Override
    public boolean pointInside(Point p) {
        if(x<=p.getX()&&x+width>=p.getX()&&y<=p.getY()&&y+height>=p.getY())
            return true;
        return false;
    }
    
    public void setColor(Color color){
        this.color=color;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public Shape copy() {
        Shape copiedRectangle = new MyRectangle(x,y,width,height,color);
        return copiedRectangle;
    }

    @Override
    public void printShape() {
        System.out.println("Rectangle");
    }
    
}
