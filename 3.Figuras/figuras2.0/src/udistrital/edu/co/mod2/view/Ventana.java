/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.edu.co.mod2.view;

import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import udistrital.edu.co.mod2.controller.Control;

/**
 *
 * @author carlos
 */
public class Ventana extends JFrame {

    public Ventana(String title) throws HeadlessException {
        super(title);
        setBounds(0, 0, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Control.graficar(g);
    }
}
