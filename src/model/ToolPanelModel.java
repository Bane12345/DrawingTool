/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.awt.Color;
import java.util.ArrayList;
import repositories.ToolPanelRepository;
import shapes.Shape;

/**
 *
 * @author Bane
 */
public class ToolPanelModel {
    private ArrayList<Shape> toolPanelShapeList;
    public ToolPanelModel(){
        toolPanelShapeList = new ToolPanelRepository().getShapeList();
    }

    public ArrayList<Shape> getToolPanelShapeList() {
        return toolPanelShapeList;
    }

    public void setToolPanelShapeList(ArrayList<Shape> toolPanelShapeList) {
        this.toolPanelShapeList = toolPanelShapeList;
    }
}
