/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.awt.Color;
import java.util.List;
import model.Theme;

/**
 *
 * @author Bane
 */
public class ThemeRepository {
    private List<Theme> themeList;
    private Theme defaultTheme;
    public ThemeRepository(){
        Theme theme1 = new Theme(new Color(0,0,0),new Color(0,0,0),"Prva");
        Theme theme2 = new Theme(new Color(0,0,0),new Color(0,0,0),"Druga");
        Theme theme3 = new Theme(new Color(0,0,0),new Color(0,0,0),"Treca");
        Theme theme4 = new Theme(new Color(0,0,0),new Color(0,0,0),"Cetvrta");
        Theme theme5 = new Theme(new Color(0,0,0),new Color(0,0,0),"Peta");
        defaultTheme=theme1;
    }
}
