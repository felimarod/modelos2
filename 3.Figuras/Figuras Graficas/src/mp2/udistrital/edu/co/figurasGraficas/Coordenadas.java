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
