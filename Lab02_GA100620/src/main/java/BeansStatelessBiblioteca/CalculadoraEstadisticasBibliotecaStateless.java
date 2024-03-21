package BeansStatelessBiblioteca;

import javax.ejb.Stateless;
import javax.ejb.EJB;
import java.math.BigDecimal;
import java.math.RoundingMode;
import BeansLocalesBiblioteca.Biblioteca.IBibliotecaLocal;

@Stateless
public class CalculadoraEstadisticasBibliotecaStateless implements ICalculadoraEstadisticasBibliotecaStateless {
    
    @EJB
    private IBibliotecaLocal biblioteca; // Inyección del EJB local

    @Override
    public double calcularPromedioPrestamosPorUsuario(int totalPrestamos, int totalUsuarios) {
        if (totalUsuarios == 0) return 0; // Para evitar dividir entre 0
        BigDecimal prestamos = new BigDecimal(totalPrestamos);
        BigDecimal usuarios = new BigDecimal(totalUsuarios);
        return prestamos.divide(usuarios, 2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double calcularPorcentajeDevolucionesATiempo(int devolucionesATiempo, int totalPrestamos) {
        if (totalPrestamos == 0) return 0; // Para evitar dividir entre 0
        BigDecimal devoluciones = new BigDecimal(devolucionesATiempo);
        BigDecimal prestamos = new BigDecimal(totalPrestamos);
        return devoluciones.divide(prestamos, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).doubleValue();
    }
    
    // Método que utiliza el EJB local para obtener información de un libro por su ISBN
    public String obtenerInformacionLibro(String isbn) {
        // La implementación real buscaría detalles en el EJB local o la base de datos
        return "Información del libro con ISBN " + isbn + ": Este es un ejemplo de información del libro.";
    }
}
