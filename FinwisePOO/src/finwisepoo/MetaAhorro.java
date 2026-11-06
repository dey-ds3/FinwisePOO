package finwisepoo;

public class MetaAhorro {
    private String nombre;
    private double montoObjetivo;
    private double montoActual;

    public MetaAhorro(String nombre, double montoObjetivo) {
        this.nombre = nombre;
        this.montoObjetivo = montoObjetivo;
        this.montoActual = 0.0; 
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoObjetivo() {
        return montoObjetivo;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void abonar(double monto) {
        this.montoActual = this.montoActual + monto;
    }

    public double calcularProgreso() {
        if (montoObjetivo == 0) {
            return 0.0;
        }
        return (montoActual / montoObjetivo) * 100;
    }
}