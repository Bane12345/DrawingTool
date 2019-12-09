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
import java.util.Random;

/**
 *
 * @author Bane
 */
public class MyCircle implements Shape{
    private int x,y;
    private int r;
    private Color color;
    private MyLine myLine;
    public MyCircle(int x, int y, int r,Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    public MyLine getMyLine() {
        return myLine;
    }

    public void setMyLine(MyLine myLine) {
        myLine.setPosition(x-r/2, y-r/2);
        this.myLine = myLine;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.fillOval(x, y, r, r);
    }

    @Override
    public boolean pointInside(Point p) {
        int xp =(int)p.getX(); int yp=(int)p.getY();
        if(((xp-x-r/2)*(xp-x-r/2)+(yp-y-r/2)*(yp-y-r/2))<(r*r)/4)
            return true;
        return false;
    }

    @Override
    public void setColor(Color color) {
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
        Shape copiedCircle = new MyCircle(x,y,r,color);
        return copiedCircle;
    }

    @Override
    public void printShape() {
        System.out.println("CIRCLE");
    }
    
    @Override
    public Point getPosition() {
        return new Point(x,y);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x=x-r/2;
        this.y=y-r/2;
    }

    @Override
    public void moveShape(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
