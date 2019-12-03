/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import listeners.ToolPanelListener;
import repositories.ToolPanelRepository;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class ToolPanel extends javax.swing.JPanel {
    private ArrayList<Shape> toolPanelShapeList;
    private Color backgroundColor = new Color(101, 230, 189);
    private final Color normalColor = new Color(33, 92, 46);
    private final Color hoverColor = new Color(3, 148, 252);
    private final int height=600,width=200;
    public ToolPanel() {
        initComponents();
        prepareToolPanel();
        toolPanelShapeList = new ToolPanelRepository().getShapeList();
        setSize(width,height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(71, 237, 129));
        setMaximumSize(new java.awt.Dimension(200, 600));
        setMinimumSize(new java.awt.Dimension(200, 600));

        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("SHAPES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(548, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<Shape> getToolPanelShapeList() {
        return toolPanelShapeList;
    }

    public void setToolPanelShapeList(ArrayList<Shape> toolPanelShapeList) {
        this.toolPanelShapeList = toolPanelShapeList;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Shape s : toolPanelShapeList){
            s.draw(g);
        }
    }

    public JLabel getLbl1() {
        return lbl1;
    }

    public void setLbl1(JLabel lbl1) {
        this.lbl1 = lbl1;
    }
    
    private void prepareToolPanel(){
        setBackground(backgroundColor);
        prepareLbl1();
    }
    
    private void prepareLbl1() {
        Font f = new Font("Monospaced",Font.BOLD,32);
        lbl1.setBackground(backgroundColor);
        lbl1.setFont(f);
        lbl1.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl1;
    // End of variables declaration//GEN-END:variables

    public void addToolPanelListener(ToolPanelListener ToolPanelListener) {
        AWTEventMonitor.addActionListener(ToolPanelListener);
        addMouseListener(ToolPanelListener);
        addMouseMotionListener(ToolPanelListener);
    }

    public Color getNormalColor() {
        return normalColor;
    }

    public Color getHoverColor() {
        return hoverColor;
    }
}
