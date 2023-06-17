package figuras;

public class Piramide extends Figura{
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema){
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen(){
        return ((double)1/3)*Math.pow(base,2)*altura;
    }
    public double calcularSuperficie(){
        return base*(2*apotema+base);
    }
}
