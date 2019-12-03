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
    public MyTriangle(int x1,int y1,int x2,int y2,int x3,int y3,Color color){
        this.x1=x1; this.y1=y1;
        this.x2=x2; this.y2=y2;
        this.x3=x3; this.y3=y3;
        k1 = (double)(y2-y1)/(x2-x1);
        k2 = (double)(y2-y3)/(x2-x3);
        k3 = (double)(y1-y3)/(x1-x3);
        n1=y1-k1*x1;
        n2=y2-k1*x2;
        n3=y3-k1*x3;
        polygon= new Polygon(
                    new int[]{x1, x2, x3},
                    new int[]{y1, y2, y3},
                    3);
        this.color=color;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.fillPolygon(polygon);
    }

    @Override
    public boolean pointInside(Point p) {
//        double x=p.getX(); double y=p.getY();
//        if(y<k1*x+n1&&y<k2*x+n2&&y<k3*x+n3)
//            return true;
        return false;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public void setPosition(int x, int y) {
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
        return new Point(x1,y1);
    }
}
