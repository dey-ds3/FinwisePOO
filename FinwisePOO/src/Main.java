
import finwisepoo.GestorFinanciero;
import finwisepoo.MenuConsola;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando el sistema FinWise...");

        GestorFinanciero gestorFinanciero = new GestorFinanciero();

        MenuConsola menuConsola = new MenuConsola(gestorFinanciero);

        menuConsola.iniciarSistema();
    }
}
