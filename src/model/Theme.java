/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Bane
 */
public class Theme {
    private final Color drawingPanelColor;
    private final Color toolPanelColor;
    private final String themeName;
    public Theme(Color drawingPanelColor, Color toolPanelColor,String themeName) {
        this.drawingPanelColor = drawingPanelColor;
        this.toolPanelColor = toolPanelColor;
        this.themeName=themeName;
    }
    public Color getDrawingPanelColor() {
        return drawingPanelColor;
    }

    public Color getToolPanelColor() {
        return toolPanelColor;
    }

    public String getThemeName() {
        return themeName;
    }
}
