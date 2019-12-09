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
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author Bane
 */
public class MyTriangle implements Shape{
    private Polygon polygon;
    private Color color;
    private int x1,x2,x3,y1,y2,y3;
    private double k1,k2,k3;
    private double n1,n2,n3;
    private MyLine myLine;
    public MyTriangle(int x1,int y1,int x2,int y2,int x3,int y3,Color color){
        this.x1=x1; this.y1=y1;
        this.x2=x2; this.y2=y2;
        this.x3=x3; this.y3=y3;
        polygon= new Polygon(
                    new int[]{x1, x2, x3},
                    new int[]{y1, y2, y3},
                    3);
        k1 = (double)(y2-y1)/(x2-x1);
        k2 = (double)(y2-y3)/(x2-x3);
        k3 = (double)(y3-y1)/(x3-x1);
        n1=y1-k1*x1;
        n2=y2-k2*x2;
        n3=y3-k3*x3;
        this.color=color;
    }
    public MyLine getMyLine() {
        return myLine;
    }

    public void setMyLine(MyLine myLine) {
        this.myLine = myLine;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.fillPolygon(polygon);
    }

    @Override
    public boolean pointInside(Point p) {
        double x=p.getX(); double y=p.getY();
        System.out.println("POINT - X:"+x+" Y:"+y);
        if(y<(k2*x+n2)&&y>(k1*x+n1)&&y>(k3*x+n3)){
            System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
            return true;
        }
        return false;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public void setRandomPosition(Random r) {
    }

    @Override
    public Shape copy() {
        Shape copiedTriangle = new MyTriangle(x1, y1, x2, y2, x3, y3, color);
        return copiedTriangle;
    }

    @Override
    public void printShape() {
        System.out.println("TRIANGLE");
    }
    
    @Override
    public Point getPosition() {
        return new Point(x1,y1+45);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x1=x;
        this.y1=y-45;
        this.y2=y1+90;
        this.y3=y1+90;
        this.x2=x+60;
        this.x3=x-60;
        k1 = (double)(y2-y1)/(x2-x1);
        k2 = (double)(y2-y3)/(x2-x3);
        k3 = (double)(y3-y1)/(x3-x1);
        n1=y1-k1*x1;
        n2=y2-k2*x2;
        n3=y3-k3*x3;
        polygon= new Polygon(
                    new int[]{x1, x2, x3},
                    new int[]{y1, y2, y3},
                    3);        
    }
    
    @Override
    public void moveShape(int x, int y) {
        setPosition(x, y);
    }
}
