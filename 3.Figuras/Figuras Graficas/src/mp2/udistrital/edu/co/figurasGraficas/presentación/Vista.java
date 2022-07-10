package mp2.udistrital.edu.co.figurasGraficas.presentación;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 *
 * @author NATHA
 */
class Vista extends JFrame {

    Controlador c;
    Modelo m;

    private JPanel contentPane;
    private JTextField txtCoordX;
    private JTextField txtCoordY;
    private JButton btnCalculate;

    Vista(Modelo m) {
        this.m = m;
        this.c = null;

        setTitle("GaussPoligono");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 244);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel txtCoordsX = new JLabel("Ingrese las coordenadas en x: ");
        txtCoordsX.setBounds(12, 56, 184, 16);
        contentPane.add(txtCoordsX);

        txtCoordX = new JTextField();
        txtCoordX.setBounds(219, 56, 188, 22);
        contentPane.add(txtCoordX);
        txtCoordX.setColumns(10);

        JLabel txtCoordsY = new JLabel("Ingrese las coordenadas en y: ");
        txtCoordsY.setBounds(12, 85, 184, 16);
        contentPane.add(txtCoordsY);

        txtCoordY = new JTextField();
        txtCoordY.setColumns(10);
        txtCoordY.setBounds(219, 85, 188, 22);
        contentPane.add(txtCoordY);

        btnCalculate = new JButton("Calcular");
        btnCalculate.addActionListener(getControlador());
        btnCalculate.setBounds(163, 146, 97, 25);
        contentPane.add(btnCalculate);

        JLabel lblTitulo = new JLabel("Formula de Gauss: Ingresa los valores separados por una coma \",\".");
        lblTitulo.setBounds(12, 13, 397, 16);
        contentPane.add(lblTitulo);
    }

    public JTextField getTxtCoordX() {
        return txtCoordX;
    }

    public JTextField getTxtCoordY() {
        return txtCoordY;
    }

    public Controlador getControlador() {
        if (c == null) {
            c = new Controlador(this);
        }
        return c;
    }

    public JButton getBtnCalculate() {
        return btnCalculate;
    }

    Modelo getModelo() {
        return m;
    }

}
