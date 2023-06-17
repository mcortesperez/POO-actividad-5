package notas;

public class Notas {
    protected double[] notas_estudiante;

    public Notas(){
        notas_estudiante = new double[5];
    }

    public double mean(){
        double m;
        double sum = 0;
        for(int i = 0; i < notas_estudiante.length; i++){
            sum += notas_estudiante[i];
        }
        m = sum/notas_estudiante.length;
        return m;
    }

    public double std(){
        double s;
        double prom = mean();
        double sum = 0;
        for (int i = 0; i < notas_estudiante.length; i++){
            sum += Math.pow(notas_estudiante[i]-prom, 2);
        }
        return Math.sqrt(sum/notas_estudiante.length);
    }

    public double max(){
        double mayor = 0;
        for (int i = 0; i < notas_estudiante.length; i++){
            mayor = Math.max(mayor, notas_estudiante[i]);
        }
        return mayor;
    }

    public double min(){
        double menor = notas_estudiante[0];
        for (int i = 1; i < notas_estudiante.length; i++){
            menor = Math.min(menor, notas_estudiante[i]);
        }
        return menor;
    }
}
