/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import form.MyForm;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import model.Model;

/**
 *
 * @author Bane
 */
public class Main {
    public static void main(String[] args) {
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        MyForm myform = new MyForm();
        Model model = new Model();        
        Controller controller = new Controller(myform,model);
    }
}
