package mp2.udistrital.edu.co.figuras;
/**
 *
 * @author NATHA
 */
public class Coordenadas {
    private static String coordX;
    private static String coordY;
    
    public static void setCoordsXDatos(String l) {
    coordX = Interfaz.getCoordsX().getText().replaceAll("\\s+","");
	l = coordX;
    }
    
    public static void setCoordsYDatos(String p) {
    coordY = Interfaz.getCoordsY().getText().replaceAll("\\s+","");
        p = coordY;
    }
    public static double[] getCoordsXDatos() {
    coordX = Interfaz.getCoordsX().getText().replaceAll("\\s+","");
    String[] coordsXS = coordX.split(",");
    double[] coordsXD = new double[coordsXS.length];
        for(int i = 0; i < coordsXS.length; i++) {
            try {
                coordsXD[i] = Double.parseDouble(coordsXS[i]);
            }catch (NumberFormatException e){
            }
		}
	return coordsXD;
	}
    public static double[] getCoordsYDatos() {
		coordY = Interfaz.getCoordsY().getText().replaceAll("\\s+","");
		String[] coordsYS = coordY.split(",");
		double[] coordsYD = new double[coordsYS.length];
		for(int i = 0; i < coordsYD.length; i++) {
		    try {
		    	coordsYD[i] = Double.parseDouble(coordsYS[i]);
		    } catch (NumberFormatException e) {
		    }
		}
		return coordsYD;
	}
    public static double[] recorrerCoordsDatos(double[] x, double[] y) {
		double[] tmp = new double[x.length];
		double s = 0;
		for(int i=0; i<=x.length-2;i++) {
				s = x[i]*y[i+1];
				tmp[i] = s;
				
		}
		tmp[x.length-1] = x[x.length-1]*y[0];
		
		return tmp;		
	}
    public static double sumatoriaDatos(double[] tmp) {
		double sum = 0;
		for(int i=0; i<tmp.length; i++) {
			sum += tmp[i];
		}
		return sum;
	}
}
