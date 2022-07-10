package mp2.udistrital.edu.co;

import javax.swing.*;
import java.awt.*;

public class AreaPoli extends JFrame {
    public static void main(String[] args) {
        AreaPoli marco = new AreaPoli("Manejo del raton");
        marco.setSize(300, 300);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    AreaPoli(String nom) {
        super(nom);
        getContentPane().setBackground(Color.white);
        Lienzo lienzo = new Lienzo();
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(lienzo);
        lienzo.addMouseListener(new ManejoRaton(lienzo));
    }
}
