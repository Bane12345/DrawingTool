/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

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
        g2d.setStroke(new BasicStroke(8));
        g2d.drawLine(x1,y1,x2,y2);
    }

    @Override
    public boolean pointInside(Point p) {
        if(x1<=p.getX()&&x2>=p.getX()&&y1<=p.getY()+4&&y2>=p.getY()-4)
            return true;
        return false;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
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
    
    @Override
    public Point getPosition() {
        return new Point(x1,y1);
    }
    
    public void setRandomPosition(Random r){
        int x1 = r.nextInt(750);
        int y1 = r.nextInt(400);
        int x2 = r.nextInt(750);
        int y2 = r.nextInt(400);
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x1=x;
        this.y1=y;
        this.x2=x1+130;
        this.y1=y1;
    }

    @Override
    public MyLine getMyLine() {
        return this;
    }

    @Override
    public void setMyLine(MyLine myLine) {
        //
    }
    
    @Override
    public void moveShape(int x, int y) {
//        this.x=x;
//        this.y=y;
    }
    
    public void setLinePosition(Point p1,Point p2){
        this.x1=(int)p1.getX();
        this.x2=(int)p2.getX();
        this.y1=(int)p1.getY();
        this.y2=(int)p2.getY();
    }
    
    public Point getFirstPoint(){
        return new Point(x1,y1);
    }
    
    public Point getSecondPoint(){
        return new Point(x2,y2);
    }
}
