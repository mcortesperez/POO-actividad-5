package figuras;

public class Cilindro extends Figura{
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura){
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen(){
        return Math.PI*Math.pow(radio,2)*altura;
    }
    public double calcularSuperficie(){
        return 2*Math.PI*radio*(altura+radio);
    }
}
