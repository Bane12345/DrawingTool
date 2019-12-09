/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import shapes.Shape;

/**
 *
 * @author Bane
 */
public class Model {
    private ToolPanelModel toolPanelModel;
    private HeaderPanelModel headerPanelModel;
    private DrawingPanelModel drawingPanelMode;
    private Shape selectedShape;
    public Model() {
        this.toolPanelModel = new ToolPanelModel();
        this.headerPanelModel = new HeaderPanelModel();
        this.drawingPanelMode = new DrawingPanelModel();
    }

    public ToolPanelModel getToolPanelModel() {
        return toolPanelModel;
    }

    public void setToolPanelModel(ToolPanelModel toolPanelModel) {
        this.toolPanelModel = toolPanelModel;
    }

    public HeaderPanelModel getHeaderPanelModel() {
        return headerPanelModel;
    }

    public void setHeaderPanelModel(HeaderPanelModel headerPanelModel) {
        this.headerPanelModel = headerPanelModel;
    }

    public DrawingPanelModel getDrawingPanelMode() {
        return drawingPanelMode;
    }

    public void setDrawingPanelMode(DrawingPanelModel drawingPanelMode) {
        this.drawingPanelMode = drawingPanelMode;
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }
}
