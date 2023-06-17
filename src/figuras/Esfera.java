package figuras;

public class Esfera extends Figura{
    private double radio;

    public Esfera(double radio){
        this.radio = radio;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen(){
        return (4/3)*Math.PI*Math.pow(radio,3);
    }
    public double calcularSuperficie(){
        return 4*Math.PI*Math.pow(radio,2);
    }
}
