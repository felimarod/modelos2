package mp2.udistrital.edu.co;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;

class Lienzo extends Canvas {

    int con = 0, x, y, bot = 0;
    int[] savex = new int[5];
    int[] savey = new int[5];
    int[][] bothy = new int[6][2];
    double area, deter = 0;

    // organiza los puntos 5 aristas, se repite el inicial ejes X y Y
    Lienzo() {
        this.setSize(200, 200);
        this.setBackground(Color.white);
    }

    public void paint(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(0, 0, 200, 200);
        g.setColor(Color.white);

        if (bot == MouseEvent.BUTTON1 || bot == MouseEvent.BUTTON2 || bot == MouseEvent.BUTTON3) {
            if (con < 5) {
                g.drawString("" + (con + 1), x, y);
                savex[con] = x;
                savey[con] = y;
                bothy[con][0] = x;
                bothy[con][1] = y;
                if (con == 0) {
                    bothy[5][0] = x;
                    bothy[5][1] = y;
                }
            }
            if (con == 5) {
                // Hallar determinante
                for (int i = 0; i < 5; i++) {
                    deter += bothy[i][0] * bothy[i + 1][1];
                    deter -= bothy[i][1] * bothy[i + 1][0];
                }
                area = deter / 2;
                area = Math.abs(area);
                System.out
                        .println("El área es: " + area + "\n" + Arrays.toString(savex) + "\n" + Arrays.toString(savey));
            }
            if (con >= 5) {
                g.fillPolygon(savex, savey, 5);
                g.setColor(Color.white);
                g.drawString("El área es: " + area, x, y);
            }
            con++;
            if (con == 10)
                con = 0;
        }
    }

    void asignaPos(int x, int y, int button) {
        this.x = x;
        this.y = y;
        this.bot = button;
    }
}
