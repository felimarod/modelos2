package mp2.udistrital.edu.co.figuras;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


/**
 *
 * @author NATHA
 */
class Interfaz extends JFrame {
    private JPanel contentPane;
    private static JTextField coordX;
    private static JTextField coordY;
    
    public static void setCoordX(JTextField s){
        s=coordX; 
    }
    public static void setCoordsY(JTextField r) {
        r = coordY;
    }
	
    public static JTextField getCoordsX() {
        return coordX;
    }
	
    public static JTextField getCoordsY() {
    	return coordY;
    }
    
    public Interfaz (){
    
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
		
    coordX = new JTextField();
    coordX.setBounds(219, 56, 188, 22);
    contentPane.add(coordX);
    coordX.setColumns(10);
		
    JLabel txtCoordsY = new JLabel("Ingrese las coordenadas en y: ");
    txtCoordsY.setBounds(12, 85, 184, 16);
    contentPane.add(txtCoordsY);
		
    coordY = new JTextField();
    coordY.setColumns(10);
    coordY.setBounds(219, 85, 188, 22);
    contentPane.add(coordY);
		
		
    final Coordenadas area = new Coordenadas();
    JButton btnCalculate = new JButton("Calcular");
    btnCalculate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            double[] coordsYM = Coordenadas.getCoordsYDatos();
            double[] coordsXM = Coordenadas.getCoordsXDatos();
				
            //JOptionPane.showMessageDialog(null, "Coordenadas en X son: " + Arrays.toString(coordsXM));
            //JOptionPane.showMessageDialog(null, "Coordenadas en Y son: " + Arrays.toString(coordsYM));
				
            double[] valoresX = Coordenadas.recorrerCoordsDatos(coordsXM, coordsYM);
            double[] valoresY = Coordenadas.recorrerCoordsDatos(coordsYM, coordsXM);
				
            //JOptionPane.showMessageDialog(null, "Valores en X son: " + Arrays.toString(valoresX));
            //JOptionPane.showMessageDialog(null, "Valores en Y son: " + Arrays.toString(valoresY));
				
            double sumatoriaX = Coordenadas.sumatoriaDatos(valoresX);
            double sumatoriaY = Coordenadas.sumatoriaDatos(valoresY);
				
            //JOptionPane.showMessageDialog(null, "Sumatoria de X es: " + sumatoriaX);
            //JOptionPane.showMessageDialog(null, "Sumatoria de Y es: " + sumatoriaY);
				
            if(coordsYM.length > 0 && coordsYM.length <= 3 || coordsXM.length > 0 && coordsXM.length <= 3 ) {
                JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
            }
            if(coordsYM.length == 0 && coordsXM.length == 0) {
		JOptionPane.showMessageDialog(null, "Las coordenadas no deben estar vacias, intentelo nuevamente");
            }
				
            if(coordsYM.length > 3 && coordsXM.length > 3) {
            if(sumatoriaX > sumatoriaY) {
		double diferenciaXY = sumatoriaX - sumatoriaY;
		double resultado = diferenciaXY/2;
		JOptionPane.showMessageDialog(null, "El area del poligono irregular evaluado es: " + resultado);
            }
				
            if(sumatoriaY > sumatoriaX) {
            double diferenciaXY = sumatoriaY - sumatoriaX;
            double resultado = diferenciaXY/2;
            JOptionPane.showMessageDialog(null, "El area del poligono irregular evaluado es: " + resultado);
                }
            }
	
	}
    });
    btnCalculate.setBounds(163, 146, 97, 25);
    contentPane.add(btnCalculate);
		
    JLabel lblTitulo = new JLabel("Formula de Gauss: Ingresa los valores separados por una coma \",\".");
    lblTitulo.setBounds(12, 13, 397, 16);
    contentPane.add(lblTitulo);
    }
}
