/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import form.DrawingPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class DrawingPanelListener implements ActionListener,MouseListener,MouseMotionListener{
    private DrawingPanel drawingPanel;
    private ArrayList<Shape> drawingPanelShapeList;

    public DrawingPanelListener(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.drawingPanelShapeList = this.drawingPanel.getDrawingPanelShapeList();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        drawingPanel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
