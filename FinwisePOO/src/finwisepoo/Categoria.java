package finwisepoo;

public class Categoria {
    private String nombre;
    private String tipo; // "INGRESO" o "GASTO"
    private int transaccionesAsociadas;

    public Categoria(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.transaccionesAsociadas = 0;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre de la categoría no puede estar vacío.");
        }
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public void setTipo(String tipo) {
        if (tipo != null && (tipo.equalsIgnoreCase("INGRESO") || tipo.equalsIgnoreCase("GASTO"))) {
            this.tipo = tipo.toUpperCase();
        } else {
            System.out.println("El tipo de categoría debe ser estrictamente 'INGRESO' o 'GASTO'.");
        }
    }

    public int getTransaccionesAsociadas() { 
        return transaccionesAsociadas; 
    }
    
    public void incrementarTransaccion() {
        this.transaccionesAsociadas++;
    }

    public void decrementarTransaccion() {
        if (this.transaccionesAsociadas > 0) {
            this.transaccionesAsociadas--;
        }
    }
}