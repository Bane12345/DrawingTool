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
import java.util.Random;

/**
 *
 * @author Bane
 */
public class MyRectangle implements Shape{
    private int x,y;
    private int width,height;
    private Color color;
    private MyLine myLine;
    public MyRectangle(int x, int y, int width, int height,Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color=color;
    }
    
    public MyLine getMyLine() {
        return myLine;
    }

    public void setMyLine(MyLine myLine) {
        myLine.setPosition(x-width/2, y-height/2);
        this.myLine = myLine;
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
    public void setRandomPosition(Random r) {
        int x = r.nextInt(750);
        int y = r.nextInt(400);
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

    @Override
    public Point getPosition() {
        return new Point(x,y);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x=x-width/2;
        this.y=y-height/2;
    }
    
    @Override
    public void moveShape(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
