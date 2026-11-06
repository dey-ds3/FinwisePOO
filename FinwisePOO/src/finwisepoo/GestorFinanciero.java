package finwisepoo;

public class GestorFinanciero {
    private ArrayList<Double> ingresos;
    private ArrayList<Double> gastos;
    private ArrayList<String> categorias;
    private ArrayList<MetaAhorro> metasAhorro;

    public GestorFinanciero() {
        this.ingresos = new ArrayList<>();
        this.gastos = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.metasAhorro = new ArrayList<>();
        
        // Categorías por defecto
        this.categorias.add("Alimentación");
        this.categorias.add("Transporte");
        this.categorias.add("Estudios");
    }


    public void registrarIngreso(double monto, String descripcion, String categoria) {
        ingresos.add(monto);
        System.out.println("-> Ingreso registrado con éxito: $" + monto + " (" + descripcion + " - " + categoria + ")");
    }

    public void registrarGasto(double monto, String descripcion, String categoria) {
        gastos.add(monto);
        System.out.println("-> Gasto registrado con éxito: $" + monto + " (" + descripcion + " - " + categoria + ")");
    }

 
    public void registrarCategoria(String nombreCategoria) {
        categorias.add(nombreCategoria);
        System.out.println("-> Categoría '" + nombreCategoria + "' registrada correctamente.");
    }

  
    public void crearMetaAhorro(String nombre, double montoObjetivo) {
        MetaAhorro nuevaMeta = new MetaAhorro(nombre, montoObjetivo);
        metasAhorro.add(nuevaMeta);
        System.out.println("-> Meta de ahorro '" + nombre + "' creada con un objetivo de $" + montoObjetivo);
    }

    public void abonarMetaAhorro(String nombre, double abono) {
        boolean encontrada = false;
        int i = 0;
        while (i < metasAhorro.size() && !encontrada) {
            MetaAhorro meta = metasAhorro.get(i);
            if (meta.getNombre().equalsIgnoreCase(nombre)) {
                meta.abonar(abono);
                System.out.println("-> Abono exitoso de $" + abono + " a la meta '" + nombre + "'.");
                System.out.println("   Monto acumulado: $" + meta.getMontoActual() + " de $" + meta.getMontoObjetivo());
                encontrada = true;
            }
            i++;
        }

        if (!encontrada) {
            System.out.println("-> No se encontró ninguna meta con el nombre '" + nombre + "'.");
        }
    }


    public void consultarResumenFinanciero() {
        double totalIngresos = 0;
        double totalGastos = 0;

        int i = 0;
        while (i < ingresos.size()) {
            totalIngresos = totalIngresos + ingresos.get(i);
            i++;
        }

        int j = 0;
        while (j < gastos.size()) {
            totalGastos = totalGastos + gastos.get(j);
            j++;
        }

        double balance = totalIngresos - totalGastos;

        System.out.println("Total Ingresos: $" + totalIngresos);
        System.out.println("Total Gastos:   $" + totalGastos);
        System.out.println("Balance Actual: $" + balance);
    }

    public void consultarListadosYProgreso() {
        System.out.println("\n--- LISTA DE CATEGORÍAS ---");
        int i = 0;
        while (i < categorias.size()) {
            System.out.println("- " + categorias.get(i));
            i++;
        }

        System.out.println("\n--- PROGRESO DE METAS DE AHORRO ---");
        if (metasAhorro.isEmpty()) {
            System.out.println("No hay metas creadas todavía.");
        } else {
            int j = 0;
            while (j < metasAhorro.size()) {
                MetaAhorro meta = metasAhorro.get(j);
                System.out.println("Meta: " + meta.getNombre());
                System.out.println("  Acumulado: $" + meta.getMontoActual() + " / $" + meta.getMontoObjetivo());
                System.out.println("  Progreso:  " + String.format("%.2f", meta.calcularProgreso()) + "%");
                System.out.println("----------------------------------------");
                j++;
            }
        }
    }
}