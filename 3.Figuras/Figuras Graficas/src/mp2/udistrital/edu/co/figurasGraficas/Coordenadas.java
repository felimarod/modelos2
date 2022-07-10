package mp2.udistrital.edu.co.figurasGraficas;

/**
 *
 * @author NATHA
 */

public class Coordenadas {
    private static Coordenadas instance;
    private Coordenadas() {
    }

    static public Coordenadas getInstance() {
        if(instance == null)
            instance = new Coordenadas();
        return instance;
    }
    

    private int[] coordsX, coordsY;
    
    /**
     * Guarda las coordenadas de x, quitando los espacios
     * @param posX
     */
    public void setCoordsXDatos(String posX) {
        posX = posX.replaceAll("\\s+", "");
        String[] auxCoor = posX.split(",");
        coordsX = new int[auxCoor.length];
        for(int i= 0;i<coordsX.length; i++)
            try{
                coordsX[i] = Integer.parseInt(auxCoor[i]);
            } catch (NumberFormatException nfe){
                System.out.println("Se ingreso mal una coordenada en x");
            }
    }
    /**
     * 
     * Guarda las coordenadas de y, quitando los espacios
     * @param posY
     */
    public void setCoordsYDatos(String posY) {
        posY = posY.replaceAll("\\s+", "");
        String[] auxCoor = posY.split(",");
        coordsY = new int[auxCoor.length];
        for(int i= 0;i<coordsY.length; i++)
            try{
                coordsY[i] = Integer.parseInt(auxCoor[i]);
            } catch (NumberFormatException nfe){
                System.out.println("Se ingreso mal una coordenada en y");
            }
    }

    public int[] getCoordsXDatos() {
        return coordsX;
    }

    public int[] getCoordsYDatos() {
        return coordsY;
    }

    public int[] recorrerCoordsDatos(int[] x, int[] y) {
        int[] tmp = new int[x.length]; 
        int s = 0;
        for (int i = 0; i <= x.length - 2; i++) {
            s = x[i] * y[i + 1];
            tmp[i] = s;

        }
        tmp[x.length - 1] = x[x.length - 1] * y[0];

        return tmp;
    }

    public int sumatoriaDatos(int[] tmp) {
        int sum = 0;
        for (int i = 0; i < tmp.length; i++) {
            sum += tmp[i];
        }
        return sum;
    }
}
