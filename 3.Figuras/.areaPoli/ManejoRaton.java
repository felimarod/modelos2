import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ManejoRaton extends MouseAdapter {
    Lienzo lienzo;

    ManejoRaton(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void mouseClicked(MouseEvent ev) {
        lienzo.asignaPos(ev.getX(), ev.getY(), ev.getButton());
        lienzo.repaint();
    }

    public void mouseExited(MouseEvent ev) {
    }

    public void mouseEntered(MouseEvent ev) {
        Lienzo t;
        t = (Lienzo) (ev.getComponent());
        t.asignaPos(ev.getX(), ev.getY(), -1);
        t.repaint();
    }

    public void mouseReleased(MouseEvent ev) {
    }

    public void mousePressed(MouseEvent ev) {
    }
}
