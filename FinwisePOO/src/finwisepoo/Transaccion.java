package finwisepoo;

public class Transaccion implements Reporteable {
    private String id;
    private String descripcion;
    private double monto;
    private String fecha;
    private Categoria categoria;
    private String tipoTransaccion; // "INGRESO" o "GASTO"
    private double limitePresupuestoAlerta; 

    public Transaccion(String id, String descripcion, double monto, String fecha, Categoria categoria, String tipoTransaccion, double limitePresupuestoAlerta) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
        thisfecha = fecha;
        this.categoria = categoria;
        this.tipoTransaccion = tipoTransaccion;
        this.limitePresupuestoAlerta = limitePresupuestoAlerta;
        
        
        categoria.incrementarTransaccion();
    }

    
    public String getId() { 
        return id; 
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("El ID de la transacción no puede estar vacío.");
        }
    }


    public String getDescripcion() { 
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("La descripción no puede estar vacía.");
        }
    }


    public double getMonto() { 
        return monto;
    }

    public void setMonto(double monto) {
        if (monto > 0) {
            this.monto = monto;
        } else {
            System.out.println("El monto de la transacción debe ser mayor a cero.");
        }
    }


    public String getFecha() { 
        return fecha;
    }

    public void setFecha(String fecha) {
        if (fecha != null && !fecha.trim().isEmpty()) {
            this.fecha = fecha;
        } else {
            System.out.println("La fecha no puede estar vacía.");
        }
    }

    public Categoria getCategoria() { 
        return categoria; 
    }

    public void setCategoria(Categoria categoria) {
        if (categoria != null) {
            this.categoria = categoria;
        } else {
            System.out.println("La categoría no puede ser nula.");
        }
    }

    public String getTipoTransaccion() { 
        return tipoTransaccion; 
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        if (tipoTransaccion != null && (tipoTransaccion.equalsIgnoreCase("INGRESO") || tipoTransaccion.equalsIgnoreCase("GASTO"))) {
            this.tipoTransaccion = tipoTransaccion.toUpperCase();
        } else {
            System.out.println("El tipo de transacción debe ser 'INGRESO' o 'GASTO'.");
        }
    }


    public double getLimitePresupuestoAlerta() { 
        return limitePresupuestoAlerta; 
    }

    public void setLimitePresupuestoAlerta(double limitePresupuestoAlerta) {
        if (limitePresupuestoAlerta >= 0) {
            this.limitePresupuestoAlerta = limitePresupuestoAlerta;
        } else {
            System.out.println("El límite de alerta no puede ser negativo.");
        }
    }

    @Override
    public void generarReporte() {
        System.out.printf("[%s] ID: %s | Fecha: %s | Desc: %s | Monto: $%.2f | Categoría: %s%n",
                tipoTransaccion, id, fecha, descripcion, monto, categoria.getNombre());
        
        if (tipoTransaccion.equals("GASTO") && limitePresupuestoAlerta > 0 && this.monto >= (this.limitePresupuestoAlerta * 0.80)) {
            System.out.println("[ALERTA DE GASTO]: ¡Atención! El gasto en '" + descripcion + 
                               "' de $" + monto + " está consumiendo el " + 
                               ((monto/limitePresupuestoAlerta)*100) + "% del límite establecido ($" + limitePresupuestoAlerta + ").");
        }
    }
}